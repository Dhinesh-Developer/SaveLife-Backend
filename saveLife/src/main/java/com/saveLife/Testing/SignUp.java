package com.saveLife.Testing;

import com.saveLife.Model.User;
import com.saveLife.Service.UserService;
import com.saveLife.ServiceImpl.ServiceImpl;

public class SignUp {
	public static void main(String[] args) {
		
		User user = new User("kumar","kumar@gmail.com","kumar123","admin");
		UserService us = new ServiceImpl();
		int status = us.insert(user);
		
		if(status > 0) {
			System.out.println("Inserted successfully");
		}else {
			System.out.println("Not inserted");
		}
		
	}
}
