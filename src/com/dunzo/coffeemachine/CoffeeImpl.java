package com.dunzo.coffeemachine;

import com.dunzo.coffeemachine.inventory.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CoffeeImpl {
	private static CoffeeImpl instance = null;
	private static ParseJson parse;
	private CoffeeImpl() {
		
	}
	public static CoffeeImpl getInstance() {
		if(instance == null)
			instance = new CoffeeImpl();
		return instance;
	}
	public void getOutput(String file_location) throws FileNotFoundException, IOException, ParseException, NullPointerException {        
        	parse = ParseJson.getInstance();
            parse.parseJsonFile(file_location);     
	}
	public void addIngredients() {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Ingredients> inventory = parse.getIngredients();
		AddIngredients add = new AddIngredients();
		add.addIngredients(inventory);
		Iterator<Entry<String, Ingredients>> it = inventory.entrySet().iterator();
			
	}
}