package com.ing.hackaton.model;

public class BankAccount {
	int id;
	String account_number;
	String bank_holder_name;
	String bank_name;
	int id_owner;
	
	public BankAccount(String account_number, String bank_holder_name,
			String bank_name, int id_owner) {
		this.account_number = account_number;
		this.bank_holder_name = bank_holder_name;
		this.bank_name = bank_name;
		this.id_owner = id_owner;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getBank_holder_name() {
		return bank_holder_name;
	}
	public void setBank_holder_name(String bank_holder_name) {
		this.bank_holder_name = bank_holder_name;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public int getId_owner() {
		return id_owner;
	}
	public void setId_owner(int id_owner) {
		this.id_owner = id_owner;
	}
	
	
}
