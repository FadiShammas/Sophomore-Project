/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LangWars;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author Levi
 */
public class CardArray {
    BufferedImage[] images;
    
    
    public CardArray(BufferedImage[] images){
        this.images = images; 
       
    }
    private JPanel getContent(){
        JPanel panel =  new JPanel(new GridLayout(0,2,5,5));
        for (BufferedImage image : images) {
            ImageIcon icon = new ImageIcon(image);
            panel.add(panel);
        }
        return panel;
        
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String prefix = "C:/Users/Levi/Pictures/CardPics/";
        String[] ids = {"Boiler", "Dragon-Lord", "Fire-Ball","Freezer","Get-Behind-Me","Junkrat", "Priest","Red-Ice","Shuffler(Spell)","Spirit-Queen","Tank"};
        String ext = ".png";
        BufferedImage[] images = new BufferedImage[ids.length];
        for(int i=0; i < images.length; i++){
            String path = prefix + ids[i] + ext;
            images[i]=ImageIO.read(new File(path));
            
        }
        CardArray app = new CardArray(images);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(app.getContent());
        f.pack();
        f.setLocation(200,200);
        f.setVisible(true);
        
        
       
        

   
    }
    
}
