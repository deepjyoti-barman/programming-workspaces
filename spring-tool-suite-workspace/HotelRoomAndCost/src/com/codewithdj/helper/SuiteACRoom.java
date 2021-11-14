package com.codewithdj.helper;

public class SuiteACRoom extends HotelRoom {
	
	private Integer ratePerSqFeet;
	
	public SuiteACRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTV, Boolean hasWifi) {
		super(hotelName, numberOfSqFeet, hasTV, hasWifi);
		this.ratePerSqFeet = 15;
	}
	
	@Override
	public Integer getRatePerSqFeet() {
		if (this.hasWifi)
			return this.ratePerSqFeet + 2;
		else
			return this.ratePerSqFeet;
	}
}
