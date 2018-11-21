package com.rain.app.web.controller;

import com.rain.app.web.bean.Buy;
import com.rain.app.web.bean.Shopping;
import com.rain.app.web.bean.User;
import com.rain.app.web.dao.BuyDao;
import com.rain.app.web.dao.ShoppingDao;
import com.rain.app.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BuyController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ShoppingDao shoppingDao;
    @Autowired
    private BuyDao buyDao;


    @RequestMapping("/index/shopping")
    public String shopping(WebRequest webRequest){
        List<Shopping> list = shoppingDao.queryShoppingList();
        webRequest.setAttribute("list", list, RequestAttributes.SCOPE_REQUEST);
        return "shopping";
    }
    @RequestMapping("/index/addcart")
    public String addcart(HttpServletRequest request,String id){
        HttpSession session = request.getSession();
        User userbean = (User) session.getAttribute("user");
        Buy buybean = new Buy(userbean.getId(),Integer.parseInt(id),0);
        buyDao.addBuy(buybean);
        return "redirect:/index/shopping";
    }
    @RequestMapping("/index/buyshopping")
    public String buyshopping(){
        List<Buy> list = buyDao.queryBuyList(0);
        for (Buy bean: list) {
            bean.setState(1);
            buyDao.updateBuyById(bean);
        }
        return "redirect:/index/mycart";
    }
    @RequestMapping("/index/myorder")
    public String myorder(WebRequest webRequest){
        List<Buy> list = buyDao.queryBuyList(1);
        List<Shopping> list2 = new ArrayList<Shopping>();
        for (Buy bean: list) {
            Shopping shoppingbean = shoppingDao.queryShoppingById(bean.getS_id());
            list2.add(shoppingbean);
        }
        webRequest.setAttribute("list", list2, RequestAttributes.SCOPE_REQUEST);
        return "myorder";
    }
    @RequestMapping("/index/mycart")
    public String mycart(WebRequest webRequest){
        List<Buy> list = buyDao.queryBuyList(0);
        List<Shopping> list2 = new ArrayList<Shopping>();
        for (Buy bean: list) {
            Shopping shoppingbean = shoppingDao.queryShoppingById(bean.getS_id());
            list2.add(shoppingbean);
        }
        webRequest.setAttribute("list", list2, RequestAttributes.SCOPE_REQUEST);
        return "mycart";
    }
}
