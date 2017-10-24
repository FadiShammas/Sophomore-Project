/*
 * To change this license header, choose License Headers in Project Properties.
2 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestWars;

import java.util.Scanner;

/**
 *
 * @author Jake
 */
public class TestWars {
    
    
    
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        Boolean endturn = false;
        int php, ohp, mana, cmana;
        php = 10;
        ohp = 10;
        mana = 0;
        cmana = 0;
        Creature yeti = new Creature("Chillwind Yeti", 4, 4, 5);
        Creature tank = new Creature("Spider Tank", 3, 3, 4);
        yeti.setName("Chillwind Yeti");
        tank.setName("Spider Tank");
        Creature hand[] = new Creature[]{tank, yeti};
        yeti.setInhand(1);
        tank.setInhand(1);
        while(php > 0 & ohp > 0){
            tank.setExhausted(0);
            yeti.setExhausted(0);
            if(mana<10)
            mana++;
            cmana = mana;
            endturn = false;
            Clear();
            while(!endturn){
                System.out.println("Your turn!\nYou have " + php + " health and " + cmana + "/" + mana + " mana.\nYour opponent has " + ohp + " health.");
                System.out.println("Check Hand(1) Check Board(2) Attack(3) Play Creature(4) EndTurn(5)");
                int c = scan.nextInt();
                switch(c){
                    case 1 :
                        Clear();
                        if(yeti.getInhand() == 1 | tank.getInhand() == 1){
                            System.out.print("You have: ");
                            if(yeti.getInhand() == 1 & tank.getInhand() == 1)
                                System.out.println(tank.getName() + " and " + yeti.getName() + " in your hand.");
                            else if(yeti.getInhand() == 1)
                                System.out.println(yeti.getName() + " in your hand.");
                            else
                                System.out.println(tank.getName() + " in your hand.");
                        }
                        else
                            System.out.println("Your hand is empty!");
                        break;
                    case 2 :
                        Clear();
                        if(yeti.getInhand() == 0 & tank.getInhand() == 0)
                            System.out.println("There is " + tank.getName() + " and " + yeti.getName() + " on board");
                        else if(yeti.getInhand() == 0)
                                System.out.println(yeti.getName() + " is on the board.");
                            else if(tank.getInhand() == 0)
                                System.out.println(tank.getName() + " is on the board.");
                            else
                                System.out.println("The board is empty.");
                        break;
                    case 3 :
                        Clear();
                        if(yeti.getInhand() == 1 & tank.getInhand() == 1)
                            System.out.println("There are no creatures to attack with!");
                        else if(yeti.getInhand() == 0 & tank.getInhand() == 0){
                            System.out.println("Attack with Chillwind Yeti(1) Attack with Spider Tank(2) Back(3)");
                            int a = scan.nextInt();
                            Clear();
                            switch(a){
                                case 1 :
                                    if(yeti.getExhausted() == 1)
                                        System.out.println("That unit is exhausted!");
                                    else{
                                        yeti.setExhausted(1);
                                        ohp = Attack(yeti, ohp);
                                    } 
                                    break;
                                case 2 :
                                    if(tank.getExhausted() == 1)
                                        System.out.println("That unit is exhausted!");
                                    else{
                                        tank.setExhausted(1);
                                        ohp = Attack(tank, ohp);
                                    }
                                    break;
                                case 3 :
                                    break;
                            }
                        }
                        else if(yeti.getInhand() == 0){
                            System.out.println("Attack with Chillwind Yeti(1) Back(2)");
                            int a = scan.nextInt();
                            Clear();
                            switch(a){
                                case 1 :
                                    if(yeti.getExhausted() == 1)
                                        System.out.println("That unit is exhausted!");
                                    else{
                                        yeti.setExhausted(1);
                                        ohp = Attack(yeti, ohp);
                                    } 
                                    break;
                                case 2 :
                                    break;
                            }
                        }
                        else{
                            System.out.println("Attack with Spider Tank(1) Back(2)");
                            int a = scan.nextInt();
                            Clear();
                            switch(a){
                                case 1 :
                                    if(tank.getExhausted() == 1)
                                        System.out.println("That unit is exhausted!");
                                    else{
                                        tank.setExhausted(1);
                                        ohp = Attack(tank, ohp);
                                    } 
                                    break;
                                case 2 :
                                    break;
                            }
                            
                        }
                        break;
                    case 4 :
                        Clear();
                        if(yeti.getInhand() == 1 & tank.getInhand() == 1){
                            System.out.println("Play Chillwind Yeti(1) Play Spider Tank(2) Back(3)");
                            int p = scan.nextInt();
                            Clear();
                            switch (p){
                                case 1 :
                                    if(cmana<yeti.getCost())
                                        System.out.println("You do not have enough mana to play this!");
                                    else{
                                        cmana = Summon(yeti, cmana);
                                        yeti.setExhausted(1);
                                        yeti.setInhand(0);
                                    }
                                break;
                                case 2 :
                                    if(cmana<tank.getCost())
                                        System.out.println("You do not have enough mana to play this!");
                                    else{
                                        cmana = Summon(tank, cmana);
                                        tank.setExhausted(1);
                                        tank.setInhand(0);
                                    }
                                break;
                                case 3:
                                break;
                            }
                        }
                        else if(yeti.getInhand() == 1){
                            System.out.println("Play Chillwind Yeti(1) Back(2)");
                            int p = scan.nextInt();
                            Clear();
                            switch (p){
                                case 1 :
                                    if(cmana<yeti.getCost())
                                        System.out.println("You do not have enough mana to play this!");
                                    else{
                                        cmana = Summon(yeti, cmana);
                                        yeti.setExhausted(1);
                                        yeti.setInhand(0);
                                    }
                                break;
                                case 2 :
                                break;
                            }
                        }
                        else if(tank.getInhand() == 1){
                            System.out.println("Play Spider Tank(1) Back(2)");
                            int p = scan.nextInt();
                            Clear();
                            switch (p){
                                case 1 :
                                    if(cmana<tank.getCost())
                                        System.out.println("You do not have enough mana to play this!");
                                    else{
                                        cmana = Summon(tank, cmana);
                                        tank.setExhausted(1);
                                        tank.setInhand(0);
                                    }
                                break;
                                case 2 :
                                break;
                            }
                        }
                        else{
                            Clear();
                            System.out.println("Your hand is empty!");
                        }
                    break;
                    case 5:
                        endturn = true;
                        break;
                    
                }
            }    
        }
        Clear();
        System.out.println("Opponent has been defeated!\nYou win!");
    }
    
    public static int Attack(Creature source, int ohp){
        Clear();
        System.out.println(source.getName() + " hits the opponent for " + source.getAtk() + " Damage!");
        ohp -= source.getAtk();
        return ohp;
    }
    
    public static int Summon(Creature source, int cmana){
        System.out.println("You play " + source.getName() + ".");
        return cmana-=source.getCost();
    }
    
    public static void Clear() {
        for(int i = 0; i < 100; i++) {
        System.out.println();
        }
    }
}



