package com.ing.hackaton.model;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Account {
	private String id;
	private String label;

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void parse(String jsonString) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);

		JSONArray accounts = (JSONArray) jsonObject.get("accounts");

		Iterator i = accounts.iterator();

		// take each value from the json array separately
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			
			this.id = (String) innerObj.get("id");
			this.label = (String) innerObj.get("label");
			
		}
		
	}
}
