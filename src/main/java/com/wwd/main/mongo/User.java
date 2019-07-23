package com.wwd.main.mongo;

public class User {
	
	
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", wife=" + wife + "]";
	}

	private String userName;
	
	private Object[] email;
	
	private String wife;
	
	private String son;

	public Object[] getEmail() {
		return email;
	}

	public void setEmail(Object[] email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWife() {
		return wife;
	}

	public void setWife(String wife) {
		this.wife = wife;
	}

	public String getSon() {
		return son;
	}

	public void setSon(String son) {
		this.son = son;
	}
}
