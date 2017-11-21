/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package langwars;

/**
 *
 * @author Jake
 */
public class Card {
    protected String name, art, desc;
    protected int cost, state;
    
    public Card(){
        
    }
    
    public Card(String name, String art, String desc, int cost){
        this.name = name;
        this.art = art;
        this.desc = desc;
        this.cost = cost;
    }

    public Card(String name, int state, int cost) {         //Constructor for testing purposes
        this.cost = cost;
        this.state = state;
    }
    
    
    
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
  
    public void setExhausted(int exhausted){}
}
