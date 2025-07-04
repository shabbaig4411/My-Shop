package com.shop.model_service;

public interface SignIn {
	public void connectionDB();	
	public boolean newUser(String name,String mobile,String email,String password1);
	public boolean verify(String mobile_email,String password);
	
}
