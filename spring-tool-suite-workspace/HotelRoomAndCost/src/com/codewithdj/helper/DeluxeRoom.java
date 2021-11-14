package com.codewithdj.helper;

public class DeluxeRoom extends HotelRoom {
	protected Integer ratePerSqFeet;
	
	public DeluxeRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTV, Boolean hasWifi) {
		super(hotelName, numberOfSqFeet, hasTV, hasWifi);
		this.ratePerSqFeet = 10;
	}
	
	@Override
	public Integer getRatePerSqFeet() {
		if (this.hasWifi)
			return this.ratePerSqFeet + 2;
		else
			return this.ratePerSqFeet;
	}
}
