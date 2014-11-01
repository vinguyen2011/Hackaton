package com.ing.hackaton.datagather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bank {

    private String id;
    private String short_name;
    private String full_name;
    private String logo;
    private String website;
    
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


}