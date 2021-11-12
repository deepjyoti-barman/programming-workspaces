package com.codewithdj.main;

import java.util.Scanner;

import com.codewithdj.helper.Delivery;
import com.codewithdj.helper.DeliveryBO;
import com.codewithdj.helper.Innings;
import com.codewithdj.helper.InningsBO;

import lombok.Cleanup;

public class Main {

	public static void main(String[] args) {
		@Cleanup Scanner sc = new Scanner(System.in);
		InningsBO innBo = new InningsBO();
		DeliveryBO delBo = new DeliveryBO();
	
		
		System.out.println("Enter the number of innings:");
		int noOfInnings = sc.nextInt();
		sc.nextLine();				// ignore the trailing newline in input buffer
		Innings[] inningsList = new Innings[noOfInnings];
		
		for (int i = 0; i < noOfInnings; i++) {
			System.out.println("Enter innings " + (i + 1) + " details");
			
			inningsList[i] = innBo.createInnings(sc.nextLine());
		}
		
		
		System.out.println("Enter the number of deliveries:");
		int noOfDeliveries = sc.nextInt();
		sc.nextLine();				// ignore the trailing newline in input buffer
		Delivery[] deliveryList = new Delivery[noOfDeliveries];
		
		for (int i = 0; i < noOfDeliveries; i++) {
			System.out.println("Enter delivery " + (i + 1) + " details");
			
			deliveryList[i] = delBo.createDelivery(sc.nextLine(), inningsList);
		}
		
		System.out.println("Enter the delivery number for which you need to find the innings number");
		long deliveryNumber = sc.nextLong();
		
		System.out.println("Innings : " + delBo.findInningsNumber(deliveryList, deliveryNumber));
	}
}
