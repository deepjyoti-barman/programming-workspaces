package com.codewithdj.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Delivery {

	private Long deliveryNumber;
	private String batsman;
	private String bowler;
	private Long runs;
	private Long inningsNumber;
	private Innings innings;
}
