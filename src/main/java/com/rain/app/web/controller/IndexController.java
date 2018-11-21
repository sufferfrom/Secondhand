package com.rain.app.web.controller;

import com.rain.app.web.bean.Shopping;
import com.rain.app.web.config.MyFileUtil;
import com.rain.app.web.bean.User;
import com.rain.app.web.dao.ShoppingDao;
import com.rain.app.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    /**
     *
     */
    @Autowired
    private UserDao userDao;
    @Autowired
    private ShoppingDao shoppingDao;

    @RequestMapping("/index/index")
    public String index(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user;
        try {
            user = (User) session.getAttribute("user");
            System.out.println(user.toString());
        }catch (Exception e){
            user = null;
        }

        return "index";
    }

    @RequestMapping("/index/addshopping")
    public String addshopping(){
        return "addshopping";
    }

    //处理文件上传
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request,String content,String title,String money) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        System.out.println(filePath+fileName);
        try {
            MyFileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        Shopping shopping_bean = new Shopping();
        shopping_bean.setContent(content);
        shopping_bean.setMoney(money);
        shopping_bean.setTitle(title);
        shopping_bean.setPhoto("http://localhost:8090/imgupload/"+fileName);
        HttpSession session = request.getSession();
        User user_bean = (User) session.getAttribute("user");
        shopping_bean.setC_id(user_bean.getId());
        shoppingDao.addShopping(shopping_bean);


        //返回json
        return "addshopping";
    }

    @RequestMapping("/index/myshopping")
    public String myshopping(WebRequest webRequest){
        List<Shopping> list = shoppingDao.queryShoppingList();
        webRequest.setAttribute("list", list, RequestAttributes.SCOPE_REQUEST);
        return "myshopping";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register_validate")
    public String register2(@RequestParam(name = "name",
            required = false, defaultValue = "World") String name, Model model,String username, String email, String password){
        User userbean = new User();
        userbean.setUsername(username);
        userbean.setEmail(email);
        userbean.setPassword(password);
        userDao.addUser(userbean);
        model.addAttribute("name","success");
        return "login";
    }
    @PostMapping("/login_validate")
    public String login2(String username, String password, String email,HttpServletRequest request){
        HttpSession session = request.getSession();

//        System.out.println(username+" : "+password);
//        userDao.queryUserList();
//        这里是因为查询不到数据会报控制在的错误
        User list ;
        try {
             list = userDao.queryUserBy(email);
        }catch (Exception e){
            list = null;
        }
        if (list!=null&&list.getPassword().equals(password)){
            System.out.println("success");
            session.setAttribute("user",list);
            return "redirect:/index/index";
        }else{
            return "login";
        }
    }
}
