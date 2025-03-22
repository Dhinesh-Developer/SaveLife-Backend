package com.saveLife.Service;

import java.util.List;

import com.saveLife.Model.User;

public interface UserService {

	List<User> fetchAll();
	int insert(User user);
	int update(User user);
	void delete(int id);
	User fetchById();
	User fetchById(String email, String password);
	
}
