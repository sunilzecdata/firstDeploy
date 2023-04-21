package com.example.demo.dto;

public class Credential {
	
	private String userName;
	private int password;
	
	public Credential() {
		
	}
	
	public Credential(String userName, int password) {
		this.userName = userName;
		this.password = password;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
	

}
