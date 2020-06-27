package com.dunzo.coffeemachine;

import com.dunzo.coffeemachine.CoffeeImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;


public class Driver {
	public static void main(String[] args) throws Exception  
    { 
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the test file location");
		String file_location = sc.next();
		
//		String file_location = "C:\\Users\\Laptop\\Desktop\\CoffeeMachine\\FunctionalTestingJson\\testInput1.json";
        
        CoffeeImpl impl = CoffeeImpl.getInstance();
        try {
        	impl.getOutput(file_location);
        	System.out.println("\nEnter 'Y' to Refill Ingredients, press any other Button to Exit: ");
            String s = sc.next();
            if(s.equals("Y") || s.contentEquals("y")) {
           	 impl.addIngredients();
            }
           System.out.println("\nTHANK YOU !!!!!");
           sc.close();
        }
        catch(NullPointerException e) {
        	System.out.println("Json Keys/Format is incorrect...\nExiting ...");
        }
        catch(FileNotFoundException e){
        	System.out.println("File not Found. Try again...");
        }
		catch(IOException e){
			System.out.println("IO exception. Please try again !!!");
        }
		catch(ParseException e){
			System.out.println("Cannot Parse Json Input, invalid Json provided");
        }
		catch(Exception e){
        	e.printStackTrace();
        }
         
    }
}
