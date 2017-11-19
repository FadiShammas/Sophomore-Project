package langwars;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Board extends JFrame{
   public int health = 50;
   public int enemyHealth = 50;
   public int userMana = 0;
   public int enemyMana = 0;

//    public static void main(String[] args) {
//        new Board();
//  }

    public Board() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            
            public void run() {

                try {
                    // Load the background image
                    Image img = ImageIO.read(getClass().getResource("board.jpg"));
                    

                    // Create the frame. Close application on close window
                    JFrame frame = new JFrame("LangWars");
                    frame.addMouseListener(new MouseHandler());
 /*Mouse coordinates*/  /*frame.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                        System.out.println(e.getPoint());}
                            });*/
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    // Set background image                     
                    frame.setContentPane(new JLabel(new ImageIcon(img)));
                    
                    frame.setLayout(null);
                    
                    // End Turn Button
                    JButton endTurn = new JButton("End Turn");
                    endTurn.addMouseListener(new MouseHandler());
                    endTurn.setBounds(1050,683,150,50);
                    endTurn.setFont(new Font("Impact", Font.PLAIN, 20));
                    endTurn.setBackground(Color.magenta);
                    endTurn.setFocusPainted(false);
                    frame.add(endTurn);
                    
                  
                    
                    
                    
                    //HP
                    
                    
                    //User
                    JLabel hp = new JLabel();
                    hp.setText("HP: " + String.valueOf(health));
                    hp.setBounds(930,685,150,50);
                    hp.setFont(new Font("Algerian", Font.PLAIN, 40));
                    hp.setForeground(Color.red);
                    frame.add(hp);
                    
                    //Enemy
                    JLabel enemyHP = new JLabel();
                    enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                    enemyHP.setBounds(930,5,150,50);
                    enemyHP.setFont(new Font("Algerian", Font.PLAIN, 40));
                    enemyHP.setForeground(Color.red);
                    frame.add(enemyHP);
                    
                    //Mana
                    
                    //User
                    JLabel mana = new JLabel();
                    mana.setText("Mana: " + String.valueOf(userMana));
                    mana.setBounds(865,735,200,70);
                    mana.setFont(new Font("Algerian", Font.PLAIN, 40));
                    mana.setForeground(Color.blue);
                    frame.add(mana);
                    
                    //Enemy
                    JLabel enemyM = new JLabel();
                    enemyM.setText("Mana: " + String.valueOf(enemyMana));
                    enemyM.setBounds(865,55,200,50);
                    enemyM.setFont(new Font("Algerian", Font.PLAIN, 40));
                    enemyM.setForeground(Color.blue);
                    frame.add(enemyM);

                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setSize(1200,853);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }
    
    public class MouseHandler extends MouseAdapter implements MouseListener{
        int x, y;
        
        public void init(){
            addMouseListener(this);
        }
        
        public void mouseClicked(MouseEvent e){
            
           //Enemy Cards
           
            if(x>1 && x<78 && y>0 && y<180){
                System.out.println("Deck");
            }
            if(x>135 && x<213 && y>0 && y<180){
                System.out.println("1");
            }
            if(x>223 && x<301 && y>0 && y<180){
                System.out.println("2");
            }
            if(x>311 && x<389 && y>0 && y<180){
                System.out.println("3");
            }
            if(x>399 && x<477 && y>0 && y<180){
                System.out.println("4");
            }
            if(x>487 && x<565 && y>0 && y<180){
                System.out.println("6");
            }
            if(x>575 && x<653 && y>0 && y<180){
                System.out.println("7");
            }
            if(x>663 && x<741 && y>0 && y<180){
                System.out.println("8");
            }
            
            //User Cards
             if(x>1 && x<78 && y>720 && y<853){
                System.out.println("Deck");
            }
            if(x>135 && x<213 && y>720 && y<853){
                System.out.println("1");
            }
            if(x>223 && x<301 && y>720 && y<853){
                System.out.println("2");
            }
            if(x>311 && x<389 && y>720 && y<853){
                System.out.println("3");
            }
            if(x>399 && x<477 && y>720 && y<853){
                System.out.println("4");
            }
            if(x>487 && x<565 && y>720 && y<853){
                System.out.println("6");
            }
            if(x>575 && x<653 && y>720 && y<853){
                System.out.println("7");
            }
            if(x>663 && x<741 && y>720 && y<853){
                System.out.println("8");
            }
            
            //User Playables
            if(x>306 && x<384 && y>500 && y<633){
                System.out.println("5");
            }
            if(x>394 && x<472 && y>500 && y<633){
                System.out.println("3");
            }
            if(x>482 && x<560 && y>500 && y<633){
                System.out.println("1");
            }
            if(x>570 && x<648 && y>500 && y<633){
                System.out.println("Middle");
            }
            if(x>658 && x<736 && y>500 && y<633){
                System.out.println("2");
            }
            if(x>746 && x<824 && y>500 && y<633){
                System.out.println("4");
            }
            if(x>834 && x<912 && y>500 && y<633){
                System.out.println("6");
            }
            
            //Enemy Playble
            if(x>306 && x<384 && y>280 && y<413){
                System.out.println("5");
            }
            if(x>394 && x<472 && y>280 && y<413){
                System.out.println("3");
            }
            if(x>482 && x<560 && y>280 && y<413){
                System.out.println("1");
            }
            if(x>570 && x<648 && y>280 && y<413){
                System.out.println("Middle");
            }
            if(x>658 && x<736 && y>280 && y<413){
                System.out.println("2");
            }
            if(x>746 && x<824 && y>280 && y<413){
                System.out.println("4");
            }
            if(x>834 && x<912 && y>280 && y<413){
                System.out.println("6");
            }
        }
        
        public void mousePressed (MouseEvent e){
            x = e.getX();
            y = e.getY();
            
            repaint();
        }
        
    }
}
