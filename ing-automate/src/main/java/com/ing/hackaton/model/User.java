package com.ing.hackaton.model;

public class User {
    private String username;
    private String password;
    private String email;
    private String image;
    private String firstname;
    private String lastname;
    private String access_token;
    private int id;
    
    public User(String username, String password, String image, String email,
    		String firstname, String lastname) {
    	this.username = username;
    	this.password = password;
    	this.email = email;
    	this.image = image;
    	this.firstname = firstname;
    	this.lastname = lastname;
    }
    		
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
}
