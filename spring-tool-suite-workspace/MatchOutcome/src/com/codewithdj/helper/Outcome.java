package com.codewithdj.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Outcome {
	
	private String status;
	private String winnerTeam;
	
	@Override
	public String toString() {
		return String.format("%-15s %-15s", this.status, this.winnerTeam);
	}
}
