package langwars;

import java.text.NumberFormat;

public class LangWarsPlayer 
{
    private int hitPoints;
    private int manaPoints;
    private String name;
    
    NumberFormat fmt = NumberFormat.getIntegerInstance();
    
    public LangWarsPlayer(int newHP, int newMP, String newName)
    {
        hitPoints = newHP;
        manaPoints = newMP;
        name = newName;
    }
    
    public void damageHP(int usedHP)
    {
        hitPoints = hitPoints - usedHP;
    }
    
    public void restoreHP(int restoredHP)
    {        
        hitPoints = hitPoints + restoredHP;
    }

    public void damageMP(int usedMP)
    {
        manaPoints = manaPoints - usedMP;
    }
    
    public void restoreMP(int restoredMP)
    {        
        manaPoints = manaPoints + restoredMP;
    }

    public String getHP()
    {
        return fmt.format(hitPoints);
    }

    public String getMP()
    {
        return fmt.format(manaPoints);
    }
    
    public void changeName(String changedName)
    {
        name = changedName;
    }
    
    @Override
    public String toString()
    {
        String result = name + "," + Integer.toString(hitPoints) + "," + fmt.format(manaPoints);
        return result;
    }
}