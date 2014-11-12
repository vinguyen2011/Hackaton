package com.ing.hackaton.model;

public class Campaign {
	private String id;
	private String name;
	private String description;
	private double target_amount;
	private double current_amount;
	private String currency;
	private String id_receiving_account;
	private int id_creator_user;
	
	public Campaign(String name, String description, double target_amount, double current_amount,
    		String currency, String id_receiving_account, int id_creator_user) {
    	this.name = name;
    	this.description = description;
    	this.target_amount = target_amount;
    	this.current_amount = current_amount;
    	this.currency = currency;
    	this.id_receiving_account = id_receiving_account;
    	this.id_creator_user = id_creator_user;
    }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public int getId_creator_user() {
		return id_creator_user;
	}
	public void setId_creator_user(int id_creator_user) {
		this.id_creator_user = id_creator_user;
	}
	
	
}
