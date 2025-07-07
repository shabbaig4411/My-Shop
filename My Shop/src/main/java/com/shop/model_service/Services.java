package com.shop.model_service;

import java.sql.ResultSet;

public interface Services {
	public void connectionDB();
	public boolean newUser(String name,String mobile,String email,String password1);
	public boolean verify(String mobile_email,String password);
	public int getuserId(String mobile_email);
	public ResultSet getDistributors(int userId);
	public ResultSet addDistributors(int userId,int distributorId,String name,String mobile,String email);
	public int getDid(int userId);
	//public void distributorsTable();
	//public void createDb_tables();
	//public ResultSet getDistributor(int userId, int distributorId);
	

}
