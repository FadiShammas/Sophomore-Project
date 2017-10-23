package lang.wars;

/**
 * Template for a spell card
 * 
 * @author Jake
 */
public class Spell extends Card {
    
    protected String mechanic;
    
    public Spell(){
        
    }
    
    public Spell(String name, String art, String desc, int cost, String mechanic){
        super(name, art, desc, cost);
        this.mechanic = mechanic;
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    
}
