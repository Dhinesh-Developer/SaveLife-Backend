package com.saveLife.Testing;

import java.util.List;

import com.saveLife.Model.User;
import com.saveLife.Service.UserService;
import com.saveLife.ServiceImpl.ServiceImpl;

public class SignIn {
	public static void main(String[] args) {
		
		UserService us = new ServiceImpl();
		String email = "dhinesh@gmail.com";
		String password = "dhinesh123";

		List<User> userList = us.fetchAll();


		boolean userFound = false;
		for (User user : userList) {
			if (user.getEmail().equals(email) && user.getPasswd().equals(password)) {
				userFound = true;
				break;
			}
		}


		if (userFound) {
			System.out.println("User is available");
		} else {
			System.out.println("User is unavailable");
		}
	}
}
