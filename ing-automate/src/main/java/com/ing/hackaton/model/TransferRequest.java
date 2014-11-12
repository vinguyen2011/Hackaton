package com.ing.hackaton.model;

import org.json.simple.JSONObject;

public class TransferRequest {
	@SuppressWarnings("unchecked")
	public String newTransfer(String source_account_id, 
			String target_account_id, 
			String target_account_user, double amount, 
			String campaign_name, String comment) {
		 JSONObject obj=new JSONObject();
		  obj.put("sourceProductId", source_account_id);
		  obj.put("sourceProductIdentification", source_account_id);
		  obj.put("targetProductId", target_account_id);
		  obj.put("targetProductIdentification", target_account_id);
		  
		  //target code type
		  JSONObject innerObj=new JSONObject();
		  innerObj.put("code", "1100");
		  innerObj.put("label", "label");
		  obj.put("targetCodeType",innerObj);

		  obj.put("targetCode", target_account_id);
		  obj.put("targetBICCode","INGBNL2A");
		  obj.put("targetCustomerName", target_account_user);
		  
		  //amount
		  innerObj=new JSONObject();
		  innerObj.put("code", "EUR");
		  innerObj.put("label", "unknown");
		  
		  JSONObject innerObj2=new JSONObject();
		  innerObj2.put("currency", innerObj);
		  innerObj2.put("value", amount);

		  obj.put("amount",innerObj2);
		  
		  //commision
		  innerObj=new JSONObject();
		  innerObj.put("code", "EUR");
		  innerObj.put("label", "unknown");
		  
		  innerObj2=new JSONObject();
		  innerObj2.put("currency", innerObj);
		  innerObj2.put("value", 0);

		  obj.put("commission",innerObj2);
	  
		  //executionDate
		  innerObj=new JSONObject();
		  innerObj.put("datetime", "2014-11-12T19:30:00.000+01:00");
		  obj.put("executionDate",innerObj);
		  
		  //transferType
		  innerObj=new JSONObject();
		  innerObj.put("code", "C2C");
		  innerObj.put("label", "unknown");
		  obj.put("transferType",innerObj);
		  
		  obj.put("description", comment);
		  obj.put("paymentReference", campaign_name);

		  System.out.println(obj.toString());
		  return obj.toString();
	}
}
