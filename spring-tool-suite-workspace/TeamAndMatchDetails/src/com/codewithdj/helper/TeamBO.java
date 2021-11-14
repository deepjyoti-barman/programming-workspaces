package com.codewithdj.helper;

public class TeamBO {
	
	public Team createTeam(String data, Player[] playerList) {
		String[] teamDetails = data.split(",");
		
		if (teamDetails.length != 2)
			throw new IllegalArgumentException("No of arugments passed are more or less than 2");
		
		String teamName = teamDetails[0];
		String playerName = teamDetails[1];
		Player playerObj = null;
		
		for (Player player : playerList) {
			if (player.getName().equalsIgnoreCase(playerName)) {
				playerObj = player;
				break;
			}
		}
		
		if (playerObj == null)
			throw new RuntimeException("Given player name does not exist");
		
		return new Team(teamName, playerObj);
	}
}
