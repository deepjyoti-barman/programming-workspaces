package com.codewithdj.main;

import java.util.Scanner;

import com.codewithdj.helper.Match;
import com.codewithdj.helper.MatchBO;
import com.codewithdj.helper.Outcome;

import lombok.Cleanup;

public class Main {
	
	public static void main(String[] args) {
		@Cleanup Scanner sc = new Scanner(System.in);
		MatchBO matchBo = new MatchBO();
		String dateHeader = "Date";
		String teamOneHeader = "Team 1";
		String teamTwoHeader = "Team 2";
		String venueHeader = "Venue";
		String statusHeader = "Status";
		String winnerTeamHeader = "Winner";
		
		System.out.println("Enter the number of matches:");
		int noOfMatches = sc.nextInt();
		sc.nextLine();				// ignore the trailing newline in input buffer
		Match[] matchList = new Match[noOfMatches];
		
		for (int i = 0; i < noOfMatches; i++) {
			System.out.println("\nEnter match " + (i + 1) + " details:");
			
			System.out.println("Enter match date");
			String matchDate = sc.nextLine();
			
			System.out.println("Enter team one");
			String teamOne = sc.nextLine();
			
			System.out.println("Enter team two");
			String teamTwo = sc.nextLine();
			
			System.out.println("Enter venue");
			String venue = sc.nextLine();
			
			System.out.println("Enter status");
			String status = sc.nextLine();
			
			System.out.println("Enter winner team");
			String winnerTeam = sc.nextLine();
			
			matchList[i] = new Match(matchDate, teamOne, teamTwo, venue, new Outcome(status, winnerTeam));
		}
		
		while (true) {
			System.out.println("\nMenu");
			System.out.println("-----");
			System.out.println("1. View match details");
			System.out.println("2. Filter match details with outcome status");
			System.out.println("3. Filter match details with outcome winner team");
			System.out.println("4. Exit");
			System.out.println("\nEnter your choice:");
			int choice = sc.nextInt();
			sc.nextLine();				// ignore the trailing newline in input buffer
		
			switch (choice) {
				case 1:
					System.out.println("\nMatch Details");
					System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", dateHeader, teamOneHeader, teamTwoHeader, venueHeader, statusHeader, winnerTeamHeader);
					matchBo.printAllMatchDetails(matchList);
					break;
				case 2:
					System.out.println("\nEnter outcome status");
					String outcomeStatus = sc.nextLine();
					
					System.out.println("\nMatch Details");
					System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", dateHeader, teamOneHeader, teamTwoHeader, venueHeader, statusHeader, winnerTeamHeader);
					matchBo.printMatchDetailsWithOutcomeStatus(matchList, outcomeStatus);
					break;
				case 3:
					System.out.println("\nEnter outcome winner team");
					String outcomeWinnerTeam = sc.nextLine();
					
					System.out.println("\nMatch Details");
					System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", dateHeader, teamOneHeader, teamTwoHeader, venueHeader, statusHeader, winnerTeamHeader);
					matchBo.printMatchDetailsWithOutcomeWinnerTeam(matchList, outcomeWinnerTeam);
					break;
				case 4:
					System.exit(0);
				default:
					break;
			}
		}		
	}
}
