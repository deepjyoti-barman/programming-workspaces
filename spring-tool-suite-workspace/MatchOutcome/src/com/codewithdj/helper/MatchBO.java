package com.codewithdj.helper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MatchBO {
	
	public void printAllMatchDetails(Match[] matchList) {
		for (Match match : matchList) {
			System.out.println(match);
		}
	}
	
	public void printMatchDetailsWithOutcomeStatus(Match[] matchList, String outcomeStatus) {
		Boolean isOutcomeStatusAvailable = false;
		
		for (Match match : matchList) {
		 	if (match.getOutcome().getStatus().equalsIgnoreCase(outcomeStatus)) {
		 		System.out.println(match);
		 		isOutcomeStatusAvailable = true;
		 	}
		}
		
		if (!isOutcomeStatusAvailable) 
			System.out.println("Outcome status not found");
	}
	
	public void printMatchDetailsWithOutcomeWinnerTeam(Match[] matchList, String outcomeWinnerTeam) {
		Boolean isWinnerTeamAvailable = false;
		
		for (Match match : matchList) {
			if (match.getOutcome().getWinnerTeam().equalsIgnoreCase(outcomeWinnerTeam)) {
				System.out.println(match);
				isWinnerTeamAvailable = true;
			}
		}
		
		if (!isWinnerTeamAvailable)
			System.out.println("Winner team not found");
	}
}
