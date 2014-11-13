package com.ing.hackaton.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Campaign {
	private int id;
	private String name;
	private String description;
	private double target_amount;
	private double current_amount;
	private String currency;
	private String id_receiving_account;
	private String creator_username;
	private String image_url;
	private String type;
	private String date; 
	
	public Campaign(String name, String description, double target_amount, double current_amount,
    		String currency, String id_receiving_account, String creator_username,
    		String image_url, String type, String date) {
    	this.name = name;
    	this.description = description;
    	this.target_amount = target_amount;
    	this.current_amount = current_amount;
    	this.currency = currency;
    	this.id_receiving_account = id_receiving_account;
    	this.creator_username = creator_username;
    	this.image_url = image_url;
    	this.type = type;
    	this.date = date;
    }
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTarget_amount() {
		return target_amount;
	}
	public void setTarget_amount(double target_amount) {
		this.target_amount = target_amount;
	}
	public double getCurrent_amount() {
		return current_amount;
	}
	public void setCurrent_amount(double current_amount) {
		this.current_amount = current_amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getId_receiving_account() {
		return id_receiving_account;
	}
	public void setId_receiving_account(String id_receiving_account) {
		this.id_receiving_account = id_receiving_account;
	}
	
	

	public String getCreator_username() {
		return creator_username;
	}

	public void setCreator_username(String creator_username) {
		this.creator_username = creator_username;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
