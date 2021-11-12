package com.codewithdj.helper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InningsBO {
	
	public Innings createInnings(String data) {
		String[] inningsDetails = data.split(",");
		
		if (inningsDetails.length != 2)
			throw new IllegalArgumentException("No of arugments passed are more or less than 2");
		
		return new Innings(Long.parseLong(inningsDetails[0]), inningsDetails[1]);
	}
}
