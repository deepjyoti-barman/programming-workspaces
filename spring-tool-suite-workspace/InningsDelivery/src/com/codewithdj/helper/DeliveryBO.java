package com.codewithdj.helper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DeliveryBO {
	
	public Delivery createDelivery(String data, Innings[] inningsList) {
		String[] deliveryDetails = data.split(",");
		
		if (deliveryDetails.length != 5)
			throw new IllegalArgumentException("No of arugments passed are more or less than 5");
		
		Long deliveryNumber = Long.parseLong(deliveryDetails[0]);
		String batsman = deliveryDetails[1];
		String bowler = deliveryDetails[2];
		Long runs = Long.parseLong(deliveryDetails[3]);
		Long inningsNumber = Long.parseLong(deliveryDetails[4]);
		Innings innings = null;
		
		for (Innings inn : inningsList) {
			if (inn.getInningsNumber().equals(inningsNumber)) {
				innings = inn;
				break;
			}
		}
		
		if (innings == null)
			throw new RuntimeException("Given innings number does not exist");
		
		return new Delivery(deliveryNumber, batsman, bowler, runs, inningsNumber, innings);
	}
	
	
	public String findInningsNumber(Delivery[] deliveryList, long deliveryNumber) {
		Long deliveryNo = deliveryNumber;
		String inningsNo = null;
		
		for (Delivery delivery : deliveryList) {
			if (delivery.getDeliveryNumber().equals(deliveryNo)) {
				inningsNo = delivery.getInningsNumber().toString();
				break;
			}
		}
		
		if (inningsNo == null)
			throw new RuntimeException("Given delivery number does not exist");
		
		
		return inningsNo;
	}
}
