/**
 * @author CSE29999_Fall2017_Team6
 */

package langwars_demo2;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LangWars_Demo2
    {
    private static Board myFrame;

    public static void main(String[] args)
    {
        try
        {
        Thread.sleep(4500);    
        } 
        catch(Exception e)
        {
        }
        
        myFrame = new Board();
        //you can edit myFrame's properties here.
        
        LangWarsPlayer player = new LangWarsPlayer(30,10,"New Player");
        LangWarsPlayer computer = new LangWarsPlayer(30,10,"Computer");

        System.out.println("New Player : " + player);
        System.out.println("Computer   : " + computer);
        
    }
}