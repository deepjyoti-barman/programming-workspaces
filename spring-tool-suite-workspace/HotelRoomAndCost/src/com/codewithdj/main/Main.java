package com.codewithdj.main;

import java.util.Scanner;

import com.codewithdj.helper.DeluxeACRoom;
import com.codewithdj.helper.DeluxeRoom;
import com.codewithdj.helper.HotelRoom;
import com.codewithdj.helper.SuiteACRoom;

import lombok.Cleanup;

public class Main {
	
	public static void main(String[] args) {
		@Cleanup Scanner sc = new Scanner(System.in);
		
		System.out.println("Hotel Tariff Calculator");
		System.out.println("\t1. Deluxe Room");
		System.out.println("\t2. Deluxe AC Room");
		System.out.println("\t3. Suite AC Room");
		
		System.out.println("Select Room Type:");
		int roomType = sc.nextInt();
		sc.nextLine();				// ignore the trailing newline in input buffer
		
		System.out.println("Hotel Name:");
		String hotelName = sc.nextLine();
		
		System.out.println("Room Square Feet Area:");
		Integer roomSqFeetArea = sc.nextInt();
		sc.nextLine();				// ignore the trailing newline in input buffer
		
		System.out.println("Room has TV (yes/no):");
		Boolean hasTV = sc.next().equalsIgnoreCase("yes") ? true : false;
		
		System.out.println("Room has Wifi (yes/no):");
		Boolean hasWifi = sc.next().equalsIgnoreCase("yes") ? true : false;
		
		HotelRoom hotelRoom = null;
		switch(roomType) {
			case 1:
				hotelRoom = new DeluxeRoom(hotelName, roomSqFeetArea, hasTV, hasWifi);
				break;
			case 2:
				hotelRoom = new DeluxeACRoom(hotelName, roomSqFeetArea, hasTV, hasWifi);
				break;
			case 3:
				hotelRoom = new SuiteACRoom(hotelName, roomSqFeetArea, hasTV, hasWifi);
			default:
				throw new IllegalArgumentException("Chosen room type is not available in the list");
		}
		
		Integer roomTarif = hotelRoom.calculateTariff();
		System.out.println("Room tariff per day is: " + roomTarif);		
	}
}
