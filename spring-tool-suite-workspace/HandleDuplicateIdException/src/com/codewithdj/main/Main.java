package com.codewithdj.main;

import java.util.Arrays;
import java.util.Scanner;

import lombok.Cleanup;

public class Main {
	
	public static void main(String[] args) {
		@Cleanup Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the team name");
		String teamName = sc.nextLine();
		
		System.out.println("Enter the number of players suggested");
		int noOfPlayers = sc.nextInt();
		int[] playerIds = new int[noOfPlayers];
		String[] playerNames = new String[noOfPlayers];
		
		try {
			// taking input of all the player ids along with their names
			for (int i = 0; i < noOfPlayers; i++) {
				System.out.println("Enter player " + (i + 1) + " details");
				int id = sc.nextInt();
				sc.nextLine();				// ignore the trailing newline in input buffer
				String name = sc.nextLine();
				
				if (Arrays.binarySearch(playerIds, id) >= 0) {
					throw new DuplicateIdException("Player id must be unique");
				}
				
				playerIds[i] = id;
				playerNames[i] = name; 
			}
			System.out.println();
			
			// displaying the player names
			for (int i = 0; i < noOfPlayers; i++)
				System.out.println(playerIds[i] + " " + playerNames[i] + " " + teamName);
			
		} catch (DuplicateIdException die) {
			System.out.println(die.getClass().getSimpleName() + ": " + die.getMessage());
		} finally {
			sc.close();
		}
	}
}
