package com.codewithdj.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Match {
	
	private String date;
	private String teamOne;
	private String teamTwo;
	private String venue;
	private Outcome outcome;
	
	@Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s %-30s", this.date, this.teamOne, this.teamTwo, this.venue, this.outcome);
	}
}
