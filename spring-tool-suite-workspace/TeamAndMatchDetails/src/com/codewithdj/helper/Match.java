package com.codewithdj.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Match {
	
	private String date;
	private Team teamOne;
	private Team teamTwo;
	private String venue;
	
	@Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s", this.date, this.teamOne.getName(), this.teamTwo.getName(), this.venue);
	}
}
