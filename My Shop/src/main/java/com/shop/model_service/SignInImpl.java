package com.shop.model_service;

import java.sql.*;

//import jakarta.servlet.RequestDispatcher;

public class SignInImpl implements SignIn {

	private Connection con = null;
	private Statement st = null;

	@Override
	public void connectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Shabbir@123");
			st = con.createStatement();
			st.executeUpdate("CREATE DATABASE IF NOT EXISTS myShopCustomers");
			st.executeUpdate("USE myShopCustomers");
			st.executeUpdate(
					"CREATE TABLE IF NOT EXISTS allCustomersData(name varchar(40) not null,mobile varchar(10) primary key,email varchar(40) UNIQUE,password varchar(35) not null)");

		} catch (Exception e) {

		}
	}

	@Override
	public boolean newUser(String name, String mobile, String email, String password) {
		try {
			
			st.executeUpdate("INSERT INTO allCustomersData VALUES('" + name + "','" + mobile + "','" + email + "','"
					+ password + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean verify(String mobile_email, String password) {
		try {			
			ResultSet result = st.executeQuery("SELECT password FROM allcustomersdata WHERE mobile= '" + mobile_email
					+ "' || email ='" + mobile_email + "' ");			
			while (result.next()) {
				String password1 = result.getString("password");
				if (password1.equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {

		}
		return false;
	}
}







