package TestWars;

/**
 * Template for a creature card
 * 
 * @author Jake
 */
public class Creature extends Card {
    
    protected int hp, atk, chp, inhand, exhausted;

    public Creature(String name, int cost, int atk, int hp) {
        super(name, cost);
        this.hp = hp;
        this.atk = atk;
        chp = hp;
        exhausted = 1;
    }

    
    
    public Creature(String name, String art, String desc, int cost, int hp, int atk) {
        super(name, art, desc, cost);
        this.hp = hp;
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
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

    public int getChp() {
        return chp;
    }

    public void setChp(int chp) {
        this.chp = chp;
    }

    public int getInhand() {
        return inhand;
    }

    public void setInhand(int inhand) {
        this.inhand = inhand;
    }

    public int getExhausted() {
        return exhausted;
    }

    public void setExhausted(int exhausted) {
        this.exhausted = exhausted;
    }
    
    
}