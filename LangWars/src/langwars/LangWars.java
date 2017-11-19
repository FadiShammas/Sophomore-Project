/**
 * @author CSE29999_Fall2017_Team6
 */

package langwars;

import langwars.Board;


public class LangWars
    {
    private static Board myFrame;

    public static void main(String[] args)
    {
        myFrame = new Board();
        //you can edit myFrame's properties here.
        
        LangWarsPlayer player = new LangWarsPlayer(30,10,"New Player");
        LangWarsPlayer computer = new LangWarsPlayer(30,10,"Computer");

        System.out.println("New Player : " + player);
        System.out.println("Computer   : " + computer);

        
    }
}