package com.codewithdj.helper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MatchBO {
	
	public Match createMatch(String data, Team[] teamList) {
		String[] matchDetails = data.split(",");
		
		if (matchDetails.length != 4)
			throw new IllegalArgumentException("No of arugments passed are more or less than 4");
		
		String date = matchDetails[0];
		String teamOneName = matchDetails[1];
		String teamTwoName = matchDetails[2];
		String venue = matchDetails[3];
		Team teamOneObj = null;
		Team teamTwoObj = null;
		
		for (Team team : teamList) {
			if (team.getName().equalsIgnoreCase(teamOneName)) {
				teamOneObj = team;
				break;
			}	
		}
		
		if (teamOneObj == null)
			throw new RuntimeException("Given team name for 'Team 1' does not exist");
		
		for (Team team : teamList) {
			if (team.getName().equalsIgnoreCase(teamTwoName)) {
				teamTwoObj = team;
				break;
			}	
		}
		
		if (teamTwoObj == null)
			throw new RuntimeException("Given team name for 'Team 2' does not exist");
		
		
		return new Match(date, teamOneObj, teamTwoObj, venue);
	}
	
	public void findTeams(String matchDate, Match[] matchList) {
		// logic is built considering multiple matches can be scheduled on a given date
		Boolean isMatchFound = false;
		
		for (Match match : matchList) {
			if (match.getDate().equalsIgnoreCase(matchDate)) {
				System.out.println(match.getTeamOne().getName() + ", " + match.getTeamTwo().getName());
				isMatchFound = true;
			}
		}
		
		if (!isMatchFound)
			System.out.println("No matches are scheduled on " + matchDate);	
	}
	
	public void findAllMatchesOfTeam(String teamName, Match[] matchList) {
		// logic is built considering a team can be a part of multiple matches
		Boolean isTeamFound = false;
		
		for (Match match : matchList) {
			if (match.getTeamOne().getName().equalsIgnoreCase(teamName) || 
					match.getTeamTwo().getName().equalsIgnoreCase(teamName)) {
				System.out.println(match);
				isTeamFound = true;
			}
		}
		
		if (!isTeamFound)
			System.out.println(teamName + " is not playing any matches");
	}	
}
