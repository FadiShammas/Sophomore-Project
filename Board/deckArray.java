/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package langwars;

import java.util.Random;

 public static Creature[] deck = new Creature[11];
 public static Creature[] hand = new Creature[6];
 public static Creature[] field = new Creature[7];

/**
 *
 * @author levi
 This all works inside of the board class/**
public class deckArray {
    public static Creature[] deck = new Creature[11];
    public static Creature[] hand = new Creature[2];
    public static Creature[] field = new Creature[7];
    for (int i = 0; i < 11; i++) {
                    field[i] = new Creature("blank",0, 0, 0, 0);
                }
       deck[0] = new Creature("C#",1,7,3,3); 
                deck[1] = new Creature("C++",1,6,4,8);
                deck[2] = new Creature("HTML",1,6,3,1);
                deck[3] = new Creature("JAVA-SCRIPT",1,7,0,0);
                deck[4] = new Creature("JAVA",1,7,10,1);
                deck[5] = new Creature("PHP",1,4,4,4);
                deck[6] = new Creature("PYTHON",1,7,3,2);
                deck[7] = new Creature("RUBY",1,4,3,1);
                deck[8] = new Creature("SQL",1,6,6,1);
                deck[9] = new Creature("C#",1,5,4,1);
    
                Random generator = new Random();
                hand[0] = (deck[new Random().nextInt(deck.length)]);
                hand[1] = (deck[new Random().nextInt(deck.length)]);
                hand[2] = (deck[new Random().nextInt(deck.length)]);
                hand[3] = (deck[new Random().nextInt(deck.length)]);
                hand[4] = (deck[new Random().nextInt(deck.length)]);
                hand[5] = (deck[new Random().nextInt(deck.length)]);
                hand[6] = (deck[new Random().nextInt(deck.length)]);
                Creature css = new Creature("CSS", 2, 6, 2, 2);
}
