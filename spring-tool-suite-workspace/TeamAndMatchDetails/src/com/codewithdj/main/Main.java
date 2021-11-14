package com.codewithdj.main;

import java.util.Scanner;

import com.codewithdj.helper.Match;
import com.codewithdj.helper.MatchBO;
import com.codewithdj.helper.Player;
import com.codewithdj.helper.PlayerBO;
import com.codewithdj.helper.Team;
import com.codewithdj.helper.TeamBO;

import lombok.Cleanup;

public class Main {
	
	public static void main(String[] args) {
		@Cleanup Scanner sc = new Scanner(System.in);
		PlayerBO playerBo = new PlayerBO();
		TeamBO teamBo = new TeamBO();
		MatchBO matchBo = new MatchBO();		
		
		// creating the player list
		System.out.println("Enter the player count");
		int noOfPlayers = sc.nextInt();
		sc.nextLine();				// ignore the trailing newline in input buffer
		Player[] playerList = new Player[noOfPlayers];
		
		for (int i = 0; i < noOfPlayers; i++) {
			System.out.println("Enter player " + (i + 1) + " details");
			playerList[i] = playerBo.createPlayer(sc.nextLine());
		}
		
		// creating the team list
		System.out.println("\nEnter the team count");
		int noOfTeams = sc.nextInt();
		sc.nextLine();				// ignore the trailing newline in input buffer
		Team[] teamList = new Team[noOfTeams];
		
		for (int i = 0; i < noOfTeams; i++) {
			System.out.println("Enter team " + (i + 1 + " details"));
			teamList[i] = teamBo.createTeam(sc.nextLine(), playerList);
		}
		
		// creating the match list
		System.out.println("\nEnter the match count");
		int noOfMatches = sc.nextInt();
		sc.nextLine();				// ignore the trailing newline in input buffer
		Match[] matchList = new Match[noOfMatches];
		
		for (int i = 0; i < noOfMatches; i++) {
			System.out.println("Enter match " + (i + 1) + " details");
			matchList[i] = matchBo.createMatch(sc.nextLine(), teamList);
		}
		
		// initiating the menu driven application
		String option = null;
		do {
			System.out.println("\nMenu");
			System.out.println("-----");
			System.out.println("1. Find teams by match date");
			System.out.println("2. Find all matches of a specific team");
			System.out.println("Type 1 or 2");
			
			System.out.println("\nEnter your choice");
			int choice = sc.nextInt();
			sc.nextLine();				// ignore the trailing newline in input buffer
			
			switch (choice) {
				case 1:
					System.out.println("\nEnter match date");
					String matchDate = sc.nextLine();
					System.out.println("Teams");
					matchBo.findTeams(matchDate, matchList);
					break;
				case 2:
					System.out.println("\nEnter team name");
					String teamName = sc.nextLine();
					System.out.printf("%-15s %-15s %-15s %-15s\n", "Date", "Team 1", "Team 2", "Venue");
					matchBo.findAllMatchesOfTeam(teamName, matchList);
					break;
				default:
					System.out.println("Invalid choice entered, kindly choose between 1 or 2");
			}
			
			System.out.println("\nDo you want to continue? Type 'Yes' or  'No' (without quotes)");
			option = sc.next();
		} while (option.equalsIgnoreCase("yes"));
	}
}
