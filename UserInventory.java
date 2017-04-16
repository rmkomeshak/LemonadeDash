package lemonadedash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */

import java.util.Random;


public class UserInventory {
    private int cups, lemons, ice, sugar, day, price;
    private int recipe_lemons, recipe_ice, recipe_sugar;
    private int score, day;
    private double income, expenses;
    private String weatherStored;
    private String name;
    private double money = 20;
    private static volatile UserInventory instance;

    private UserInventory(){
        cups = 0;
        lemons = 0;
        ice = 0;
        sugar = 0;
        money = 20;
	income = 0;
	expenses = 0;
	day = 1;
	score = 0;
	weatherStored = "";
        recipe_lemons = 0;
        recipe_sugar = 0;
        recipe_ice = 0;
    }
    

    public static synchronized UserInventory getInstance(){
        if(instance == null){
            instance = new UserInventory();
        }
        return instance;
    }       
    
    
    public void setCups(int x){
        cups = x;
    }
    
    public void setLemons(int x){
        lemons = x;
    }
    
    public void setIce(int x){
        ice = x;
    }
    
    public void setSugar(int x){
        sugar = x;
    }
    
    public void setMoney(double x){
        money = x;
    }
    
    public void setName(String n){
        name = n;
    }
    
    
    public void setDay(int d){
        day= d;
    }
    
    public void setRecipeLemons(int l){
        recipe_lemons = l;
    }
    
    public void setRecipeIce(int i){
        recipe_ice = i;
    }
    
    public void setRecipeSugar(int s){
        recipe_sugar = s;
    }
    
    public void setPrice(int p){
        price = p;
    }
	
    public void setScore(int s){
	    score = s;
    }
	
    public void setDay(int d){
	    day = d;
    }
	
    public void setIncome(double i){
	    income = i;
    }
	
    public void setExpenses(double e){
	    expenses = e;
    }
	
    public void setWeatherStored(String w){
	    weatherStored = s;
    }
    
    public int getCups(){
        return cups;
    }
    
    public int getLemons(){
        return lemons;
    }
    
    public int getIce(){
        return ice;
    }
    
    public int getSugar(){
        return sugar;
    }
    
    public double getMoney(){
        return money;
    }
    
    public String getName(){
        return name;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getRecipeLemons(){
        return recipe_lemons;
    }
    
    public int getRecipeIce(){
        return recipe_ice;
    }
    
    public int getRecipeSugar(){
        return recipe_sugar;
    }
    
    public int getPrice(){
        return price;
    }
	
    public int getScore(){
	    return score;
    }
	
    public int getDay(){
	    return day;
    }
	
    public double getIncome(){
	    return income;
    }
	
    public double getExpenses(){
	    return expenses;
    }
	
    public String getWeatherStored(){
	    return weatherStored;
    }
    
    
    //RECIPE STUFF: PROBABLY GONNA MOVE SOME TO THE TOP BUT STILL WORKING ON IT
    int o_lem, o_ice, o_sug, o_price;
    int diff_lem, diff_ice, diff_sug, diff_price;
    int cups_per_pitcher = 5;
    int weather = 3;
    int recipe_factor, inventory_factor, weather_factor;
    int price_factor;
    //NOT the display score - this score is for determining how "good" your
    //recipe, weather, and inventory are for that day, determining sales.
    int score = 0;
    
    public void generateOptimalRecipe(){
        o_lem = (int) ((Math.random() * 10000) % 5) + 1;
        o_sug = (int) ((Math.random() * 10000) % 5) + 1;
        o_ice = (int) ((Math.random() * 10000) % 5) + 1;
        
        //1 pitcher = 5 cups
        //lemons = per pitcher; 1 lemon = 50 cents, lemon/cup = 10 cents
        //sugar = per pitcher; 1 sugar = 50 cents, sugar/cup = 10 cents
        //ice = per cup; ice/cup = 1 cent
        //MINIMUM PRICE = 21 CENTS; >21 TO MAKE PROFIT;
        //MAXIMUM PRICE = 101 CENTS; >101 TO MAKE PROFIT
        
        //add 15 so that the optimal price is always going to make 15 cents profit
        o_price = (o_lem * 10) + (o_sug * 10) + o_ice + 15;
        
        
        System.out.println(o_lem);
        System.out.println(o_sug);
        System.out.println(o_ice);
        System.out.println(o_price);
    }
    
    public void calculateDifference(){
        diff_lem = Math.abs(o_lem - recipe_lemons);
        diff_ice = Math.abs(o_ice - recipe_ice);
        diff_sug = Math.abs(o_sug - recipe_sugar);
        diff_price = Math.abs (o_price - price);
        
        if(diff_price <= 10)
            price_factor = 10;
        else if(diff_price > 10 && diff_price <= 25 && (price > o_price))
            price_factor = 12;
        else if(diff_price > 10 && diff_price <= 25 && (price < o_price))
            price_factor = 5;
        else if(diff_price > 25 && diff_price <= 50 && (price > o_price))
            price_factor = 15;
        else if(diff_price > 25 && diff_price <= 50 && (price < o_price))
            price_factor = 2;
        else if(diff_price > 50 && (price > o_price))
            price_factor = 20;
        else if(diff_price > 50 && (price < o_price))
            price_factor = 0;
        
        if(diff_lem >= 15 || diff_ice >= 15 || diff_sug >= 15)
            price_factor = 400;
    }   
    
    public void generateScore(){
        recipe_factor = 400 - ((diff_lem + diff_ice + diff_sug) * price_factor);
        
        inventory_factor = 5;
        if(lemons == 0 || ice == 0 || sugar == 0 || cups == 0 || price_factor == 400)
            inventory_factor = 0;
        weather_factor = 100 * weather;
        
        score = inventory_factor * (recipe_factor + (weather_factor));
        System.out.println("price: " + price_factor);
        System.out.println("recipe: "+ recipe_factor);
        System.out.println("inventory: " + inventory_factor);
        System.out.println("weather: " + weather_factor);
        System.out.println(score);
        
    }
    
    

    //Method to generate the random weather to be called within the store screen and recipe screen
   
    
    public String generateWeather()
    {
                
             
    Random rand= new Random();
    
    int weather= rand.nextInt(4);
 
    switch (weather) 
  {
        case 0:
        return "Rainy"; 
        
        case 1:
        return "Windy";
        
      
        case 2:
        return "Cloudy";   
       
        case 3:
        return "Sunny";
       
	
        	
  }
    
    setWeatherStored(Integer.toString(weather);
    return Integer.toString(weather);
    
    }
    
    
}

