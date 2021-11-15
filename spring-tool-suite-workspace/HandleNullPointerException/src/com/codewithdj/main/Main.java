package com.codewithdj.main;

import java.util.Scanner;

import com.codewithdj.helper.Player;
import com.codewithdj.helper.PlayerBO;

import lombok.Cleanup;

public class Main {

	public static void main(String[] args) {
		@Cleanup Scanner sc = new Scanner(System.in);
		PlayerBO playerBo = new PlayerBO();
		
		System.out.println("Enter the number of players");
		int noOfPlayers = sc.nextInt();
		sc.nextLine();				// ignore the trailing newline in input buffer
		Player[] playersList = new Player[noOfPlayers];
		
		Player captain = null;
		System.out.println("Do you know the details of the captain? Type 'Yes' or 'No' (without quotes)");
		boolean isCaptainDetailsAvailable = sc.next().equalsIgnoreCase("yes") ? true : false;
		System.out.println();
		sc.nextLine();				// ignore the trailing newline in input buffer
		
		// taking input of the captain's details (if available)
		if (isCaptainDetailsAvailable) {
			System.out.println("Enter the name of the captain");
			String name = sc.nextLine().trim();
			
			System.out.println("Enter the country of the captain");
			String country = sc.nextLine().trim();
			
			System.out.println("Enter the skillset of the captain");
			String skillset = sc.nextLine().trim();
			
			captain = new Player(name, country, skillset);	
		}
		
		// taking input of the player(s) details
		for (int i = 0; i < noOfPlayers; i++) {
			System.out.println("Enter the name of player " + (i + 1));
			String name = sc.nextLine().trim();
			
			System.out.println("Enter the country of player " +  (i + 1));
			String country = sc.nextLine().trim();
			
			System.out.println("Enter the skillset of player " + (i + 1));
			String skillset = sc.nextLine().trim();
			
			playersList[i] = new Player(name, country, skillset);
		}
		System.out.println();
		
		// displaying the details of the captain
		try {
			playerBo.displayPlayerDetails(captain);
		} catch (NullPointerException npe) {
			System.out.println("Exception occurred: " + npe.getClass().getCanonicalName());
			System.out.println("Captain's details are not available");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// displaying the details of the player(s)
		System.out.println("Player details");
		for (Player player : playersList)
			playerBo.displayPlayerDetails(player);
	}
}
