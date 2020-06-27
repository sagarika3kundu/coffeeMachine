package com.dunzo.coffeemachine.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.dunzo.coffeemachine.alert.Alert;
import com.dunzo.coffeemachine.inventory.Ingredients;


public class CheckInventory extends Alert{
	public CheckInventory() {
		
	}
	public void checkIngredients(HashMap<String, Ingredients> inventory) {
		Iterator<Entry<String, Ingredients>> it = inventory.entrySet().iterator();
		while(it.hasNext()) {
			HashMap.Entry<String, Ingredients> pair = (HashMap.Entry<String, Ingredients>) it.next();
			if(pair.getValue().getQuantity() <= 50) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("ALERT " + pair.getValue().getIngredient() + " is low");
			}
		}
	}
}
