package com.codewithdj.helper;

public class PlayerBO {
	
	public Player createPlayer(String data) {
		String[] playerDetails = data.split(",");
		
		if (playerDetails.length != 3)
			throw new IllegalArgumentException("No of arugments passed are more or less than 3");
		
		return new Player(playerDetails[0], playerDetails[1], playerDetails[2]);
	}
}
