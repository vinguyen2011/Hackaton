package com.ing.hackaton.model;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentBankAccount {

    private String id;
    private String currency;
    private String customerDescription;
    private double availableBalance;
    
    public CurrentBankAccount() {
		
	}
    
	public String getId() {
		return id;
	}
	
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomerDescription() {
		return customerDescription;
	}

	public void setCustomerDescription(String customerDescription) {
		this.customerDescription = customerDescription;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void parse(String jsonString) throws ParseException
	{
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);

		JSONArray list = (JSONArray) jsonObject.get("list");

		Iterator i = list.iterator();

		// take each value from the json array separately
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			
			JSONObject structure = (JSONObject) innerObj.get("subType");
			if(structure.get("code").toString().equalsIgnoreCase("1100")) {
				this.id = (String) innerObj.get("id");
				this.customerDescription = (String) innerObj.get("customerDescription");
				
				structure = (JSONObject) innerObj.get("currency");
				this.currency = (String) structure.get("code");
				
				structure = (JSONObject) innerObj.get("availableBalance");
				this.availableBalance = Double.parseDouble(structure.get("value").toString());
			}
				

		}
	}
}