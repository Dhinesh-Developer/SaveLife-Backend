package com.saveLife.ServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.saveLife.Model.User;
import com.saveLife.Service.UserService;

public class ServiceImpl implements UserService {
	
	private static final String URL = "jdbc:mysql://localhost:3306/savelife";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root@dk";
	
	private static final String INSERT = "INSERT INTO User(name,email,password,role) VALUES (?,?,?,?)";
	private static final String SELECTALL = "SELECT * FROM user";
	private static final String SELECTBYID = "SELECT * FROM user WHERE email=? AND password=?"; 

	@Override
	public List<User> fetchAll() {
		List<User> userList = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = con.createStatement();
			res = stmt.executeQuery(SELECTALL);
			
			while (res.next()) {
				User user = new User(
					res.getInt("uId"), 
					res.getString("name"), 
					res.getString("email"), 
					res.getString("password"), 
					res.getString("role")
				);
				userList.add(user);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
		
			try {
				if (res != null) res.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return userList;
	}

	@Override
	public int insert(User user) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getRole());

			result = pstmt.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int update(User user) {
		return 0;
	}

	@Override
	public void delete(int id) {
	}

	@Override
	public User fetchById(String email, String password) {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(SELECTBYID);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			res = pstmt.executeQuery();
			
			if (res.next()) {
				user = new User(
					res.getInt("id"), 
					res.getString("name"), 
					res.getString("email"), 
					res.getString("password"), 
					res.getString("role")
				);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (res != null) res.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}

	@Override
	public User fetchById() {
		return null;
	}
}
