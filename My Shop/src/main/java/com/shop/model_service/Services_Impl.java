package com.shop.model_service;

import java.sql.*;

import jakarta.servlet.RequestDispatcher;

public class Services_Impl implements Services {
	private Connection con = null;
	private Statement st = null;
	ResultSet result = null;
	RequestDispatcher rd = null;

	@Override
	public void connectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Shabbir@123");
			st = con.createStatement();
			st.executeUpdate("CREATE DATABASE IF NOT EXISTS myShop");
			st.executeUpdate("USE myShop");
			st.executeUpdate(
					"CREATE TABLE IF NOT EXISTS myShopUsers(userId INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(40) NOT NULL,mobile VARCHAR(10) UNIQUE,email VARCHAR(40) UNIQUE,password VARCHAR(35) NOT NULL)");
			st.executeUpdate(
					"CREATE TABLE IF NOT EXISTS usersDistributors(userId INT NOT NULL,distributorId INT PRIMARY KEY, name VARCHAR(40),mobile VARCHAR(10) NOT NULL,email VARCHAR(40))");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean newUser(String name, String mobile, String email, String password) {
		try {

			st.executeUpdate("INSERT INTO myShopUsers(name, mobile, email, password) VALUES('" + name + "','" + mobile
					+ "','" + email + "','" + password + "')");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean verify(String mobile_email, String password) {
		try {
			ResultSet result = st.executeQuery("SELECT password FROM myShopUsers WHERE mobile= '" + mobile_email
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

	@Override
	public int getuserId(String mobile_email) {
		try {
			ResultSet result = st.executeQuery("SELECT userId FROM myShopUsers WHERE mobile= '" + mobile_email
					+ "' || email ='" + mobile_email + "' ");
			while (result.next()) {
				int userId = result.getInt("userId");

				return userId;
			}

		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public ResultSet addDistributors(int userId, int distributorId, String name, String mobile, String email) {
		try {
			result = st.executeQuery(
					"SELECT name FROM usersDistributors WHERE userId='" + userId + "' AND name='" + name + "'");
			if (!result.next()) {

				st.executeUpdate("INSERT INTO usersDistributors(userId,distributorId,name, mobile, email) VALUES("
						+ userId + "," + distributorId + ",'" + name + "','" + mobile + "','" + email + "')");
				result = st.executeQuery("SELECT * FROM usersDistributors WHERE userId='" + userId + "'");
				return result;
			} else {
				String name1 = (String) result.getString("name");
				if (!name1.equals(name)) {
					st.executeUpdate("INSERT INTO usersDistributors(userId,distributorId,name, mobile, email) VALUES("
							+ userId + "," + distributorId + ",'" + name + "','" + mobile + "','" + email + "')");
					result = st.executeQuery("SELECT * FROM usersDistributors WHERE userId='" + userId + "'");
					return result;
				}
			}
			result = st.executeQuery("SELECT * FROM usersDistributors WHERE userId='" + userId + "'");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getDid(int userId) {

		try {
			result = st.executeQuery(
					"SELECT MAX(distributorId) AS mdid FROM usersDistributors WHERE userId='" + userId + "'");
			if (result.next()) {
				int did = result.getInt("mdid");
				return ++did;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public ResultSet getDistributors(int userId) {
		try {
			result = st.executeQuery("SELECT * FROM usersDistributors WHERE userId='" + userId + "'");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * public void distributorsTable() { try { st.executeUpdate( "CREATE TABLE IF
	 * NOT EXISTS usersDistributors(userId INT NOT NULL,distributorId INT
	 * AUTO_INCREMENT PRIMARY KEY, name VARCHAR(40) NOT NULL,mobile VARCHAR(10) NOT
	 * NULL,email VARCHAR(40))"); } catch (Exception e) {
	 * 
	 * } }
	 */

}
