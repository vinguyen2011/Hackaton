package com.ing.hackaton.model;

import java.util.Date;

public class Contribution {
	private int id;
	private double amount;
	private String currency;
	private Date date;
	private String comment;
	private int id_campaign;
	private String id_contributing_account;
	private String description;
	
	public Contribution(double amount, String currency, Date date, String comment,
			int id_campaign, String id_contributing_account, String description) {
    	this.amount = amount;
    	this.currency = currency;
    	this.date = date;
    	this.comment = comment;
    	this.currency = currency;
    	this.id_campaign = id_campaign;
    	this.id_contributing_account = id_contributing_account;
    	this.description = description;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getId_campaign() {
		return id_campaign;
	}
	public void setId_campaign(int id_campaign) {
		this.id_campaign = id_campaign;
	}
	public String getId_contributing_account() {
		return id_contributing_account;
	}
	public void setId_contributing_account(String id_contributing_account) {
		this.id_contributing_account = id_contributing_account;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
