package com.shop.model_service;

import java.sql.ResultSet;

public interface Services {
	public void connectionDB();
	public boolean newUser(String name,String mobile,String email,String password1);
	public boolean verify(String mobile_email,String password);
	public String getuserId(String mobile_email);
	public String getDid(String userId);
	public ResultSet getDistributors(String userId);
	public ResultSet addDistributors(String userId,String distributorId,String name,String mobile,String email);
	public ResultSet getDistributor(String userId,String distributorId);
	public ResultSet updateDistributor(String userId,String distributorId,String name, String mobile,String email);
	
	//public void distributorsTable();
	//public void createDb_tables();
	//public ResultSet getDistributor(int userId, int distributorId);
	

}
