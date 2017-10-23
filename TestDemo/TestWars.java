/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.wars;

/**
 *
 * @author Jake
 */
public class TestWars {
    public static void main(String[] args) {
    
        Boolean endturn = false;
        int php, ohp, mana, cmana;
        php = 10;
        ohp = 10;
        mana = 0;
        cmana = 0;
        Creature yeti = new Creature(4, 4, 5);
        Creature tank = new Creature(3, 3, 4);
        Creature hand[] = new Creature[]{tank, yeti};
        yeti.setInhand(1);
        tank.setInhand(1);
        while(php > 0 & ohp > 0){
            while(!endturn){
                if(mana<10)
                    mana++;
                System.out.println("Your turn!\nYou have " + mana + " mana.\n");
                if(yeti.getInhand() == 1 | tank.getInhand() == 1){
                    System.out.print("You have: ");
                    if(yeti.getInhand() == 1 & tank.getInhand() == 1)
                        System.out.println("Tank and Yeti in your hand");
                    else if(yeti.getInhand() == 1)
                        System.out.println("Yeti in your hand");
                    else
                        System.out.println("Tank in your hand");
                }
            }    
        }
    }
}
