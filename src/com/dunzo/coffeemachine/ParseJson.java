package com.dunzo.coffeemachine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.dunzo.coffeemachine.beverages.Beverages;
import com.dunzo.coffeemachine.inventory.Ingredients;
import com.dunzo.coffeemachine.utility.GetCoffee;

class ParseJson {
	private static ParseJson instance = null;
	HashMap<String, Ingredients> inventory;
	private ParseJson() {
		
	}
	public static ParseJson getInstance() {
		if(instance == null)
			instance = new ParseJson();
		return instance;
	}
	public void parseJsonFile(String file_location) throws FileNotFoundException, IOException, ParseException, NullPointerException{
//		try {
			// parsing file_location 
        	Object obj = new JSONParser().parse(new FileReader(file_location));
    		// typecasting obj to JSONObject 
        	JSONObject jo = (JSONObject) obj;
        	
        	// getting Machine 
            Map machine = (Map) jo.get("machine"); 
            Iterator<Map.Entry> itr3 = machine.entrySet().iterator(); 
            
            Map outlets = (Map) machine.get("outlets");
            double outlet = (long) outlets.get("count_n");
            
            
            //ADDING Ingredients IN INVENTORY
            Map Inventory = (Map) machine.get("total_items_quantity");
            Iterator<Map.Entry> items = Inventory.entrySet().iterator();
            
            inventory = new HashMap<>();
            while (items.hasNext()) { 
                Map.Entry pair = items.next(); 
                String name = (String)pair.getKey();
                double quantity = ((Number) pair.getValue()).doubleValue();
                Ingredients ing = new Ingredients(name, quantity);
                inventory.put(name, ing);
            } 

            
            //ADDING BEVERAGES REQUESTED BY USER
            Map beverages = (Map) machine.get("beverages");
            Iterator<Map.Entry> bitr = beverages.entrySet().iterator();
            ArrayList<Beverages> beverage = new ArrayList<Beverages>();
            while(bitr.hasNext()) {
            	Map.Entry pair = bitr.next();
            	String drink = (String)pair.getKey();
            	 ArrayList<Ingredients> ingts = new ArrayList<Ingredients>();
            	 Map ingred = (Map) beverages.get(drink);
            	 Iterator<Map.Entry> itr = ingred.entrySet().iterator();
                 while (itr.hasNext()) { 
    	             Map.Entry pair1 = itr.next(); 
    	             String name = (String)pair1.getKey();
    	             double quantity = ((Number) pair1.getValue()).doubleValue();
    	             Ingredients ing = new Ingredients(name, quantity);
    	             ingts.add(ing);
                 }
                 Beverages b = new Beverages(drink, ingts);
                 beverage.add(b);
                 
                 //If N beverages are parsed, we produce the drink
                 if(beverage.size() == outlet) {
                	 System.out.println("Processing " + beverage.size() + " order/s...");
                	 try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                	 for(int s = 0; s < outlet; ++s) {
                		 Beverages b1 = beverage.get(s);
                		 GetCoffee drink1 = new GetCoffee();
                     	 drink1.getDrink(b1, inventory);
                	 }
                	 beverage = new ArrayList<Beverages>();
                	 System.out.println();
                 }
            }
            if(beverage.size() > 0) {
            System.out.println("Processing " + beverage.size() + " order/s...");
            try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
           	 for(int s = 0; s < beverage.size(); ++s) {
           		 Beverages b1 = beverage.get(s);
           		 GetCoffee drink1 = new GetCoffee();
                	 drink1.getDrink(b1, inventory);
           	 }
           	 beverage = new ArrayList<Beverages>();
            }

        }
	
//Returns the Inventory
	public HashMap<String, Ingredients> getIngredients(){
		return inventory;
	}
}