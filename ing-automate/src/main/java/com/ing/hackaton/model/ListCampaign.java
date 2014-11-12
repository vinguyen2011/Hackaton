package com.ing.hackaton.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListCampaign {
	private List<Campaign> lists;

	public List<Campaign> getLists() {
		return lists;
	}

	public void setLists(List<Campaign> lists) {
		this.lists = lists;
	}
	
	
}
