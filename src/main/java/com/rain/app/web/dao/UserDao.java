package com.rain.app.web.dao;

import java.util.List;

import com.rain.app.web.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	int addUser(User user);
	
	int deleteUserById(int id);
	
	int updateUserById(User user);

	User queryUserById(int id);

	User queryUserBy(String email);

	List<User> queryUserList();
}
