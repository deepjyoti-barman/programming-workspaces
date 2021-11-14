package com.codewithdj.helper;

public class DeluxeACRoom extends DeluxeRoom {
	
	public DeluxeACRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTV, Boolean hasWifi) {
		super(hotelName, numberOfSqFeet, hasTV, hasWifi);
		this.ratePerSqFeet = 12;
	}
}
