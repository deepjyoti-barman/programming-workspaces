package com.codewithdj.helper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlayerBO {
	
	public void displayPlayerDetails(Player player) {
		System.out.println(player.getName() + ", " + player.getCountry() + ", " + player.getSkill());
	}
}
