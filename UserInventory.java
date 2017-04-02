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
    private int cups, lemons, ice, sugar, money;
    
    public UserInventory(){
        cups = 0;
        lemons = 0;
        ice = 0;
        sugar = 0;
        money = 20;
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
    
    public void setMoney(int x){
        money = x;
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
    
    public int getMoney(){
        return money;
    }
    
    
}
