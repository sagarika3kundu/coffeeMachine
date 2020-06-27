package com.dunzo.coffeemachine.utility;

import java.util.ArrayList;
import java.util.HashMap;

import com.dunzo.coffeemachine.alert.Alert;
import com.dunzo.coffeemachine.beverages.Beverages;
import com.dunzo.coffeemachine.inventory.Ingredients;

public class GetCoffee {
	public void getDrink(Beverages b, HashMap<String, Ingredients> inventory) {
		ArrayList<Ingredients> ingred = b.getIngts();
		for(int i=0; i<ingred.size(); ++i) {
			if(inventory.containsKey(ingred.get(i).getIngredient())) {
				if(ingred.get(i).getQuantity() > inventory.get(ingred.get(i).getIngredient()).getQuantity()) {
					System.out.println(b.getBeverage() + " cannot be prepared because " + ingred.get(i).getIngredient() + " is not sufficient");
					return;
				}
			}
			else {
				System.out.println(b.getBeverage() + " cannot be prepared because " + ingred.get(i).getIngredient() + " is not available");
				return;
			}
		}
		
		
		for(int i=0; i<ingred.size(); ++i) {
			double val = inventory.get(ingred.get(i).getIngredient()).getQuantity() - ingred.get(i).getQuantity();
			inventory.get(ingred.get(i).getIngredient()).setQuantity(val);
		}
		System.out.println(b.getBeverage() + " is prepared");
		
		Alert a;
		a = new CheckInventory();
		a.checkIngredients(inventory);
	}
}