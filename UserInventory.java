/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemonadedash;

/**
 *
 * @author Ryan
 */
public class UserInventory {
    private int cups, lemons, ice, sugar;
    private String name;
    private double money = 20;
    int day_choice;
    private static volatile UserInventory instance;

    private UserInventory(){
        cups = 0;
        lemons = 0;
        ice = 0;
        sugar = 0;
        money = 20;
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
        day_choice = d;
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
        return day_choice;
    }
    
    
}
