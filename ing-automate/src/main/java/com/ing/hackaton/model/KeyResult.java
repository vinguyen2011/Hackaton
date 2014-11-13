package com.ing.hackaton.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyResult {
	private String result = "false";
    private String key;
    
    public KeyResult(boolean r) {
		if (r) {
			result = "true";
		}
	}
    
	public String getResult() {
		return result;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
