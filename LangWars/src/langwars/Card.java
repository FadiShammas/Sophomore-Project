package langwars;

/**
 * Basic Template for a Card
 * 
 * @author Jake
 */
public class Card {
    protected String name, art, desc;
    protected int cost;
    
    public Card(){
        
    }
    
    public Card(String name, String art, String desc, int cost){
        this.name = name;
        this.art = art;
        this.desc = desc;
        this.cost = cost;
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
}
