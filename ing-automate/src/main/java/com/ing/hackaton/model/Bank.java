package com.ing.hackaton.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bank {

    private String id;
    private String short_name;
    private String full_name;
    private String logo;
    private String website;
    
    public Bank() {
		
	}
    
	public String getId() {
		return id;
	}
	public String getShort_name() {
		return short_name;
	}
	public String getFull_name() {
		return full_name;
	}
	public String getLogo() {
		return logo;
	}
	public String getWebsite() {
		return website;
	}
	
	public void parse(String jsonString) throws ParseException
	{
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);

		this.id = (String) jsonObject.get("id");
		this.short_name = (String) jsonObject.get("short_name");
		this.full_name = (String) jsonObject.get("full_name");
		this.logo = (String) jsonObject.get("logo");
		this.website = (String) jsonObject.get("website");
		
	}
}