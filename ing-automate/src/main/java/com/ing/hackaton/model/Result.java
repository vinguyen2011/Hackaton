package com.ing.hackaton.model;

public class Result {
	private String result = "false";
    
    public Result(boolean r) {
		if (r) {
			result = "true";
		}
	}
    
	public String getResult() {
		return result;
	}
}
