package com.dunzo.coffeemachine.inventory;

import java.util.HashMap;
import java.util.Scanner;


public class AddIngredients {
	public void addIngredients(HashMap<String, Ingredients> inventory) {
		//Refilling Ingredients as given by user
		String response;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Enter Ingredient Name to refill : ");
			String name = sc.next();
			System.out.println("Enter Ingredient Quantity to refill : ");
			double q = sc.nextDouble();
			if(q < 0) {
				System.out.println("Refill Quantity is Negative");
				System.out.println("Exiting.....");
				return;
			}
			try {
				double val = inventory.get(name).getQuantity();
				inventory.get(name).setQuantity(val + q);
				System.out.println("Successfully Refilled " + name);
				System.out.println("Current Quantity is " + inventory.get(name).getQuantity());
			}
			catch(Exception e) {
				System.out.println(name + " does not exist in inventory");
			}
			System.out.println("Do you want to Refill another item? Press 'Y' to continue or any other button to exit");
			response = sc.next();
		}while(response.equals("Y") || response.contentEquals("y"));
		sc.close();
	}
}