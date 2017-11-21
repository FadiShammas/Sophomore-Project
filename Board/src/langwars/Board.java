package langwars;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Board extends JFrame{
   public int health = 50;
   public int enemyHealth = 50;
   public int userMana = 0;
   public int enemyMana = 0;
   public int x, y;
   public JFrame frame = new JFrame("LangWars");
   
   public JPanel cards = new JPanel();
   public JPanel cards1 = new JPanel();
   public JPanel cards2 = new JPanel();
   public JPanel cards3 = new JPanel();
   public JPanel cards4 = new JPanel();
   public JPanel cards5 = new JPanel();
   public JPanel cards6 = new JPanel();
   public JPanel cards7 = new JPanel();
   public JPanel cards8 = new JPanel();
   public JPanel cards9 = new JPanel();
   public JPanel cards10 = new JPanel();
   public JPanel cards11 = new JPanel();
   public JPanel cards12 = new JPanel();
   public JPanel cards13 = new JPanel();
   public JPanel cards14 = new JPanel();
   public JPanel cards15 = new JPanel();
   public JPanel cards16 = new JPanel();
   public JPanel cards17 = new JPanel();
   public JPanel cards18 = new JPanel();
   public JPanel cards19 = new JPanel();
   public JPanel cards20 = new JPanel();
   public JPanel cards21 = new JPanel();
   public JPanel cards22 = new JPanel();
   public JPanel cards23 = new JPanel();
   public JPanel cards24 = new JPanel();
   public JPanel cards25 = new JPanel();
   public JPanel cards26 = new JPanel();
   public JPanel cards27 = new JPanel();
   
   
   
   public JLabel card = new JLabel();
   public ImageIcon ii;

    public static void main(String[] args) {
        new Board();
        
  }

    public Board() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            
            public void run() {

                //try {
                    // Create the frame. Close application on close window
                    frame.addMouseListener(new MouseHandler());
 /*Mouse coordinates*/  /*frame.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                        System.out.println(e.getPoint());}
                            });*/
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    // End Turn Button
                    JButton endTurn = new JButton("End Turn");
                    endTurn.addMouseListener(new MouseHandler());
                    endTurn.setBounds(1050,683,150,50);
                    endTurn.setFont(new Font("Impact", Font.PLAIN, 20));
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
                    enemyM.setBounds(865,40,200,70);
                    enemyM.setFont(new Font("Algerian", Font.PLAIN, 40));
                    enemyM.setForeground(Color.blue);
                    frame.add(enemyM);
                    
                    JLabel ghost = new JLabel();
                    frame.add(ghost);

                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setSize(1200,840);
                    frame.setLayout(null);
                    
                    
                    
                    //card.setIcon(getImageIcon(new File("images/c#.png")));
                    
                    //User Hand
                    cards.setBounds(135,685,78,120);
                    cards1.setBounds(223,685,78,120);
                    cards2.setBounds(311,685,78,120);
                    cards3.setBounds(399,685,78,120);
                    cards4.setBounds(487,685,78,120);
                    cards5.setBounds(575,685,78,120);
                    cards6.setBounds(663,685,78,120);
                    cards.add(card);
                    frame.add(cards);
                    frame.add(cards1);
                    frame.add(cards2);
                    frame.add(cards3);
                    frame.add(cards4);
                    frame.add(cards5);
                    frame.add(cards6);
                    
                    //Enemy Hand
                    cards7.setBounds(135,5,78,120);
                    cards8.setBounds(223,5,78,120);
                    cards9.setBounds(311,5,78,120);
                    cards10.setBounds(399,5,78,120);
                    cards11.setBounds(487,5,78,120);
                    cards12.setBounds(575,5,78,120);
                    cards13.setBounds(663,5,78,120);
                    frame.add(cards7);
                    frame.add(cards8);
                    frame.add(cards9);
                    frame.add(cards10);
                    frame.add(cards11);
                    frame.add(cards12);
                    frame.add(cards13);
                    
                    //User Playable
                    cards14.setBounds(308,470,78,120);
                    cards15.setBounds(396,470,78,120);
                    cards16.setBounds(484,470,78,120);
                    cards17.setBounds(572,470,78,120);
                    cards18.setBounds(660,470,78,120);
                    cards19.setBounds(748,470,78,120);
                    cards20.setBounds(836,470,78,120);
                    frame.add(cards14);
                    frame.add(cards15);
                    frame.add(cards16);
                    frame.add(cards17);
                    frame.add(cards18);
                    frame.add(cards19);
                    frame.add(cards20);
                    
                    //Enemy Playable
                    cards21.setBounds(308,230,78,120);
                    cards22.setBounds(396,230,78,120);
                    cards23.setBounds(484,230,78,120);
                    cards24.setBounds(572,230,78,120);
                    cards25.setBounds(660,230,78,120);
                    cards26.setBounds(748,230,78,120);
                    cards27.setBounds(836,230,78,120);
                    frame.add(cards21);
                    frame.add(cards22);
                    frame.add(cards23);
                    frame.add(cards24);
                    frame.add(cards25);
                    frame.add(cards26);
                    frame.add(cards27);
                    
                    loadBoard();
                   
                    
                    frame.setVisible(true);
            }
            
            public void loadBoard(){
                JPanel board = new JPanel();
                    JLabel bLabel = new JLabel();
                    bLabel.setIcon(getImageIcon(new File("images/board.jpg")));
                    board.setBounds(0,0,1200,840);
                    board.add(bLabel);
                    frame.add(board);
            }
        });
    }
    
    
    public class MouseHandler extends MouseAdapter implements MouseListener{
      
        
        public void init(){
            addMouseListener(this);
        }
        
        public void mouseClicked(MouseEvent e){
            
           //Enemy Cards from left to right
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
                System.out.println("5");
            }
            if(x>575 && x<653 && y>0 && y<180){
                System.out.println("6");
            }
            if(x>663 && x<741 && y>0 && y<180){
                System.out.println("7");
            }
            
            //User Cards from left to right
             if(x>1 && x<78 && y>720 && y<853){
                System.out.println("Deck");
                card.setIcon(getImageIcon(new File("images/c# (1).png")));
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
                System.out.println("5");
            }
            if(x>575 && x<653 && y>720 && y<853){
                System.out.println("6");
            }
            if(x>663 && x<741 && y>720 && y<853){
                System.out.println("7");
            }
            
            //User Playables from left to right
            if(x>306 && x<384 && y>500 && y<633){
                System.out.println("1");
            }
            if(x>394 && x<472 && y>500 && y<633){
                System.out.println("2");
            }
            if(x>482 && x<560 && y>500 && y<633){
                System.out.println("3");
            }
            if(x>570 && x<648 && y>500 && y<633){
                System.out.println("Middle");
            }
            if(x>658 && x<736 && y>500 && y<633){
                System.out.println("5");
            }
            if(x>746 && x<824 && y>500 && y<633){
                System.out.println("6");
            }
            if(x>834 && x<912 && y>500 && y<633){
                System.out.println("7");
            }
            
            //Enemy Playble from left to right
            if(x>306 && x<384 && y>280 && y<413){
                System.out.println("1");
            }
            if(x>394 && x<472 && y>280 && y<413){
                System.out.println("2");
            }
            if(x>482 && x<560 && y>280 && y<413){
                System.out.println("3");
            }
            if(x>570 && x<648 && y>280 && y<413){
                System.out.println("Middle");
            }
            if(x>658 && x<736 && y>280 && y<413){
                System.out.println("5");
            }
            if(x>746 && x<824 && y>280 && y<413){
                System.out.println("6");
            }
            if(x>834 && x<912 && y>280 && y<413){
                System.out.println("7");
            }
        }
        
        public void mousePressed (MouseEvent e){
            x = e.getX();
            y = e.getY();
            
            repaint();
        }
        
    }
    
    
    public ImageIcon getImageIcon(File f)
    {


        try
        {
            Image im = ImageIO.read(f);


            ii = new ImageIcon(im);


        }
        catch(IOException i)
        {

            i.printStackTrace();


        }



        finally
        {

            return ii;

        }


    }


}
