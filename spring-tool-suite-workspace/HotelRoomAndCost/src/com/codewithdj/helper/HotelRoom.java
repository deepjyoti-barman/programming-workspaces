package com.codewithdj.helper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HotelRoom {
	protected String hotelName;
	protected Integer numberOfSqFeet;
	protected Boolean hasTV;
	protected Boolean hasWifi;
	
	public Integer calculateTariff() {
		Integer cost = this.numberOfSqFeet * this.getRatePerSqFeet();
		return cost;
	}
	
	public Integer getRatePerSqFeet() {
		return 0;
	}
}
