package com.JordanAmeri100Internship.Beans;


public class User {
	
	private int UserID;
	private String Name = null;
	private String Password;
	private String Email;
	private String Role;
	private String Date;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}



}
