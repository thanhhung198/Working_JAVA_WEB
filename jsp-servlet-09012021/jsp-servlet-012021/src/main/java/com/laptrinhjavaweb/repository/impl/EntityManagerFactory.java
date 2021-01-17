package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EntityManagerFactory {
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

	public static Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		EntityManagerFactory cp = new EntityManagerFactory();
		Connection con = cp.getConnection();
		if (con != null) {
			System.out.println("Thanh cong");
		} else {
			System.out.println("fail");
		}
	}
}
