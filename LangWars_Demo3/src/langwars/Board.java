package langwars;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Board extends JFrame {

    public static Boolean mouseRead = false;
    public static int clickPos = 0;
    public static Boolean endturn = false;
    public static int gameState = 1;
    public static Creature[] hand = new Creature[2];
    public static Creature[] field = new Creature[7];
    public static Creature[] enemyHand = new Creature[2];
    public static Creature[] enemyField = new Creature[7];
    public static Creature css = new Creature("CSS", 2, 6, 2, 2);
    public int health = 10;
    public int enemyHealth = 10;
    public int userMana = 0;
    public int userCMana = 0;
    public int enemyMana = 0;
    public int enemyCMana = 0;
    public int x, y;
    public static JFrame frame = new JFrame("LangWars");
    public JLabel cards = new JLabel();
    public JLabel cards1 = new JLabel();
    public JLabel cards2 = new JLabel();
    public JLabel cards3 = new JLabel();
    public JLabel cards4 = new JLabel();
    public JLabel cards5 = new JLabel();
    public JLabel cards6 = new JLabel();
    public JLabel cards7 = new JLabel();
    public JLabel cards8 = new JLabel();
    public JLabel cards9 = new JLabel();
    public JLabel cards10 = new JLabel();
    public JLabel cards11 = new JLabel();
    public JLabel cards12 = new JLabel();
    public JLabel cards13 = new JLabel();
    public JLabel cards14 = new JLabel();
    public JLabel cards15 = new JLabel();
    public JLabel cards16 = new JLabel();
    public JLabel cards17 = new JLabel();
    public JLabel cards18 = new JLabel();
    public JLabel cards19 = new JLabel();
    public JLabel cards20 = new JLabel();
    public JLabel cards21 = new JLabel();
    public JLabel cards22 = new JLabel();
    public JLabel cards23 = new JLabel();
    public JLabel cards24 = new JLabel();
    public JLabel cards25 = new JLabel();
    public JLabel cards26 = new JLabel();
    public JLabel cards27 = new JLabel();
    public static JLabel mana = new JLabel();
    public static JLabel enemyHP = new JLabel();
    public static JLabel enemyM = new JLabel();

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
                /*Mouse coordinates*/ /*frame.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                        System.out.println(e.getPoint());}
                            });*/
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // End Turn Button
                JButton endTurn = new JButton("End Turn");
                endTurn.addMouseListener(new MouseHandler());
                endTurn.setBounds(1050, 683, 150, 50);
                endTurn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameState != 4) {
                            for (int i = 0; i < 7; i++) {
                                field[i].setExhausted(0);
                            }
                            gameState = 100;

                            if (userMana < 10) {
                                userMana++;
                            }
                            userCMana = userMana;
                            mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));

                            //Computer Mana
                            if (enemyMana < 10) {
                                enemyMana++;
                            }
                            enemyCMana = enemyMana;
                            enemyM.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));

                            //Computer Logic Goes Here

                            for (int i = 0; i < 7; i++) {
                                field[i] = new Creature("blank", 0, 0, 0, 0);
                            }

                            hand[0] = new Creature("PHP", 1, 4, 4, 5);
                            hand[1] = new Creature("HTML", 1, 6, 3, 4);
                            Creature css = new Creature("CSS", 2, 6, 2, 2);
                            cards.setIcon(getImageIcon(new File("images/PHP.png")));
                            cards.setVisible(true);
                            cards1.setIcon(getImageIcon(new File("images/HTML.png")));
                            cards1.setVisible(true);

                        }
                        else
                            frame.dispose();
                    }
                });
                endTurn.setFont(new Font("Impact", Font.PLAIN, 20));
                endTurn.setFocusPainted(false);
                frame.add(endTurn);

                //HP
                //User
                JLabel hp = new JLabel();
                hp.setText("HP: " + String.valueOf(health));
                hp.setBounds(930, 685, 150, 50);
                hp.setFont(new Font("Algerian", Font.PLAIN, 40));
                hp.setForeground(Color.red);
                frame.add(hp);

                //Enemy
                
                enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                enemyHP.setBounds(930, 5, 150, 50);
                enemyHP.setFont(new Font("Algerian", Font.PLAIN, 40));
                enemyHP.setForeground(Color.red);
                frame.add(enemyHP);

                //Mana
                //User
                mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                mana.setBounds(865, 735, 300, 70);
                mana.setFont(new Font("Algerian", Font.PLAIN, 40));
                mana.setForeground(Color.blue);
                frame.add(mana);

                //Enemy
                //JLabel enemyM = new JLabel();
                enemyM.setText("Mana: " + String.valueOf(enemyMana) + "/" + String.valueOf(enemyCMana));
                enemyM.setBounds(865, 40, 300, 70);
                enemyM.setFont(new Font("Algerian", Font.PLAIN, 40));
                enemyM.setForeground(Color.blue);
                frame.add(enemyM);

                JLabel ghost = new JLabel();
                frame.add(ghost);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setSize(1200, 840);
                frame.setLayout(null);

                //card.setIcon(getImageIcon(new File("images/c#.png")));
                //User Hand
                cards.setBounds(135, 685, 78, 120);
                cards.setVisible(false);
                cards1.setBounds(223, 685, 78, 120);
                cards1.setVisible(false);
                cards2.setBounds(311, 685, 78, 120);
                cards2.setVisible(false);
                cards3.setBounds(399, 685, 78, 120);
                cards3.setVisible(false);
                cards4.setBounds(487, 685, 78, 120);
                cards4.setVisible(false);
                cards5.setBounds(575, 685, 78, 120);
                cards5.setVisible(false);
                cards6.setBounds(663, 685, 78, 120);
                cards6.setVisible(false);
                cards.add(card);
                frame.add(cards);
                frame.add(cards1);
                frame.add(cards2);
                frame.add(cards3);
                frame.add(cards4);
                frame.add(cards5);
                frame.add(cards6);

                //Enemy Hand
                cards7.setBounds(135, 5, 78, 120);
                cards7.setVisible(false);
                cards8.setBounds(223, 5, 78, 120);
                cards8.setVisible(false);
                cards9.setBounds(311, 5, 78, 120);
                cards9.setVisible(false);
                cards10.setBounds(399, 5, 78, 120);
                cards10.setVisible(false);
                cards11.setBounds(487, 5, 78, 120);
                cards11.setVisible(false);
                cards12.setBounds(575, 5, 78, 120);
                cards12.setVisible(false);
                cards13.setBounds(663, 5, 78, 120);
                cards13.setVisible(false);
                frame.add(cards7);
                frame.add(cards8);
                frame.add(cards9);
                frame.add(cards10);
                frame.add(cards11);
                frame.add(cards12);
                frame.add(cards13);

                //User Playable
                cards14.setBounds(308, 470, 78, 120);
                cards14.setVisible(false);
                cards15.setBounds(396, 470, 78, 120);
                cards15.setVisible(false);
                cards16.setBounds(484, 470, 78, 120);
                cards16.setVisible(false);
                cards17.setBounds(572, 470, 78, 120);
                cards17.setVisible(false);
                cards18.setBounds(660, 470, 78, 120);
                cards18.setVisible(false);
                cards19.setBounds(748, 470, 78, 120);
                cards19.setVisible(false);
                cards20.setBounds(836, 470, 78, 120);
                cards20.setVisible(false);
                frame.add(cards14);
                frame.add(cards15);
                frame.add(cards16);
                frame.add(cards17);
                frame.add(cards18);
                frame.add(cards19);
                frame.add(cards20);

                //Enemy Playable
                cards21.setBounds(308, 230, 78, 120);
                cards21.setVisible(false);
                cards22.setBounds(396, 230, 78, 120);
                cards22.setVisible(false);
                cards23.setBounds(484, 230, 78, 120);
                cards23.setVisible(false);
                cards24.setBounds(572, 230, 78, 120);
                cards24.setVisible(false);
                cards25.setBounds(660, 230, 78, 120);
                cards25.setVisible(false);
                cards26.setBounds(748, 230, 78, 120);
                cards26.setVisible(false);
                cards27.setBounds(836, 230, 78, 120);
                cards27.setVisible(false);
                frame.add(cards21);
                frame.add(cards22);
                frame.add(cards23);
                frame.add(cards24);
                frame.add(cards25);
                frame.add(cards26);
                frame.add(cards27);

                loadBoard();

                frame.setVisible(true);

                runGame();

            }

            public void runGame() {

                gameState = 100; //100 = beginning of turn, card = card selected, 0 = end
                for (int i = 0; i < 7; i++) {
                    field[i] = new Creature("blank", 0, 0, 0, 0);
                }
                hand[0] = new Creature("PHP", 1, 4, 4, 5);
                hand[1] = new Creature("HTML", 1, 6, 3, 4);
                Creature css = new Creature("CSS", 2, 6, 2, 2);
                cards.setIcon(getImageIcon(new File("images/PHP.png")));
                cards.setVisible(true);
                cards1.setIcon(getImageIcon(new File("images/HTML.png")));
                cards1.setVisible(true);

                /*while(health > 0 & enemyHealth > 0){
                        for(int i = 0; i<7; i++)
                            field[i].setExhausted(0);
                        if(userMana<10)
                        userMana++;
                        userCMana = userMana;
                        endturn = false;
                        while(!endturn){
                            userClick();
                            switch (clickPos) {
                                case 1:
                                    if (hand[0].getState() == 1 && userCMana >= hand[0].getCost()) {
                                        boolean endloop = false;
                                        do {
                                            userClick();
                                            switch(clickPos){
                                                case 11:
                                                    if(field[0].getState()==0){
                                                        field[0] = hand[0];
                                                        field[0].setState(2);
                                                        userCMana -= hand[0].getCost();
                                                        hand[0].setState(0);
                                                        field[0].setExhausted(1);
                                                        cards.setVisible(false);
                                                        cards14.setIcon(getImageIcon(new File("images/PHP.png")));
                                                        cards14.setVisible(true);
                                                        endloop = true;
                                                    }
                                                    break;
                                                case 12:
                                                    if(field[1].getState()==0){
                                                        field[1] = hand[0];
                                                        field[1].setState(2);
                                                        userCMana -= hand[0].getCost();
                                                        hand[0].setState(0);
                                                        field[1].setExhausted(1);
                                                        cards.setVisible(false);
                                                        cards15.setIcon(getImageIcon(new File("images/PHP.png")));
                                                        cards15.setVisible(true);
                                                        endloop = true;
                                                    }
                                                    break;
                                                case 13:
                                                    if(field[2].getState()==0){
                                                        field[2] = hand[0];
                                                        field[2].setState(2);
                                                        userCMana -= hand[0].getCost();
                                                        hand[0].setState(0);
                                                        field[2].setExhausted(1);
                                                        cards.setVisible(false);
                                                        cards16.setIcon(getImageIcon(new File("images/PHP.png")));
                                                        cards16.setVisible(true);
                                                        endloop = true;
                                                    }
                                                    break;
                                                case 14:
                                                    if(field[3].getState()==0){
                                                        field[3] = hand[0];
                                                        field[3].setState(2);
                                                        userCMana -= hand[0].getCost();
                                                        hand[0].setState(0);
                                                        field[3].setExhausted(1);
                                                        cards.setVisible(false);
                                                        cards17.setIcon(getImageIcon(new File("images/PHP.png")));
                                                        cards17.setVisible(true);
                                                        endloop = true;
                                                    }
                                                    break;
                                                case 15:
                                                    if(field[4].getState()==0){
                                                        field[4] = hand[0];
                                                        field[4].setState(2);
                                                        userCMana -= hand[0].getCost();
                                                        hand[0].setState(0);
                                                        field[4].setExhausted(1);
                                                        cards.setVisible(false);
                                                        cards18.setIcon(getImageIcon(new File("images/PHP.png")));
                                                        cards18.setVisible(true);
                                                        endloop = true;
                                                    }
                                                    break;
                                                case 16:
                                                    if(field[5].getState()==0){
                                                        field[5] = hand[0];
                                                        field[5].setState(2);
                                                        userCMana -= hand[0].getCost();
                                                        hand[0].setState(0);
                                                        field[5].setExhausted(1);
                                                        cards.setVisible(false);
                                                        cards19.setIcon(getImageIcon(new File("images/PHP.png")));
                                                        cards19.setVisible(true);
                                                        endloop = true;
                                                    }
                                                    break;
                                                case 17:
                                                    if(field[6].getState()==0){
                                                        field[6] = hand[0];
                                                        field[6].setState(2);
                                                        userCMana -= hand[0].getCost();
                                                        hand[0].setState(0);
                                                        field[6].setExhausted(1);
                                                        cards.setVisible(false);
                                                        cards20.setIcon(getImageIcon(new File("images/PHP.png")));
                                                        cards20.setVisible(true);
                                                        endloop = true;
                                                    }
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }while(endloop);
                                    }
                                    break;
                                case 2:
                                    if (hand[0].getState() == 1) {

                                    }
                                    break;
                                case 11:
                                    break;
                                case 12:
                                    break;
                                case 13:
                                    break;
                                case 14:
                                    break;
                                case 15:
                                    break;
                                case 16:
                                    break;
                                case 17:
                                    break;
                                case 100:
                                    break;
                                default:
                                    break;
                            }
                        }
                    }*/
            }

            public void loadBoard() {
                JPanel board = new JPanel();
                JLabel bLabel = new JLabel();
                bLabel.setIcon(getImageIcon(new File("images/board.jpg")));
                board.setBounds(0, 0, 1200, 840);
                board.add(bLabel);
                frame.add(board);
            }

            /*public int userClick(){
                clickPos = 0;
                mouseRead = true;
                do{} while (clickPos != 0);
                mouseRead = false;
                return clickPos;
            }*/
        });
    }

    public class MouseHandler extends MouseAdapter implements MouseListener {

        public void init() {
            addMouseListener(this);
        }

        public void mouseClicked(MouseEvent e) {
            System.out.println("\nGame State: " + gameState);

            //Right Click Magnify
            if (e.getModifiers() == MouseEvent.BUTTON3_MASK)
            {
                if(x>135 && x<213 && y>720 && y<853){
                    cards.setBounds(500,400,233,359);  
                    card.setIcon(getImageIcon(new File("images/c# (Big).png")));
                }
                else{
                    cards.setBounds(135,685,78,120);
                    card.setIcon(getImageIcon(new File("images/c# (1).png")));
                }
            }

            //Enemy Cards from left to right
            if (x > 1 && x < 78 && y > 0 && y < 180) {
                //enemy deck
                System.out.println("User Clicked on Enemy Deck");
                if (mouseRead == true) {
                    clickPos = 80;
                }
            }
            if (x > 135 && x < 213 && y > 0 && y < 180) {
                //enemy card 1
                System.out.println("User Clicked on Enemy Card 1");
                if (mouseRead == true) {
                    clickPos = 81;
                }
            }
            if (x > 223 && x < 301 && y > 0 && y < 180) {
                System.out.println("User Clicked on Enemy Card 2");
                if (mouseRead == true) {
                    clickPos = 82;
                }
            }
            if (x > 311 && x < 389 && y > 0 && y < 180) {
                //enemy card 3
                System.out.println("User Clicked on Enemy Card 3");
                if (mouseRead == true) {
                    clickPos = 83;
                }
            }
            if (x > 399 && x < 477 && y > 0 && y < 180) {
                //enemy card 4
                System.out.println("User Clicked on Enemy Card 4");
                if (mouseRead == true) {
                    clickPos = 84;
                }
            }
            if (x > 487 && x < 565 && y > 0 && y < 180) {
                //enemy card 5
                System.out.println("User Clicked on Enemy Card 5");
                if (mouseRead == true) {
                    clickPos = 85;
                }
            }
            if (x > 575 && x < 653 && y > 0 && y < 180) {
                //enemy card 6
                System.out.println("User Clicked on Enemy Card 6");
                if (mouseRead == true) {
                    clickPos = 86;
                }
            }
            if (x > 663 && x < 741 && y > 0 && y < 180) {
                //enemy card 7
                System.out.println("User Clicked on Enemy Card 7");
                if (mouseRead == true) {
                    clickPos = 87;
                }
            }

            //User Cards from left to right
            if (x > 1 && x < 78 && y > 720 && y < 853) {
                //player deck
            }
            if (x > 135 && x < 213 && y > 720 && y < 853) { //hand 1
                if (mouseRead == true) 
                    clickPos = 1;
                    if (gameState == 100) {
                        if (hand[0].getState() == 1 && userCMana >= hand[0].getCost()){
                            gameState = 1;
                        }
                    }
                

            }
            if (x > 223 && x < 301 && y > 720 && y < 853) { //hand 2
                if (mouseRead == true) 
                    clickPos = 2;
                if (gameState == 100) {
                        if (hand[1].getState() == 1 && userCMana >= hand[1].getCost()){
                            gameState = 2;
                        }
                    }
                
            }
            if (x > 311 && x < 389 && y > 720 && y < 853) { //hand 3
                if (mouseRead == true) {
                    clickPos = 3;
                }
            }
            if (x > 399 && x < 477 && y > 720 && y < 853) { //hand 4
                if (mouseRead == true) {
                    clickPos = 4;
                }
            }
            if (x > 487 && x < 565 && y > 720 && y < 853) { //hand 5
                if (mouseRead == true) {
                    clickPos = 5;
                }
            }
            if (x > 575 && x < 653 && y > 720 && y < 853) { //hand 6
                if (mouseRead == true) {
                    clickPos = 6;
                }
            }
            if (x > 663 && x < 741 && y > 720 && y < 853) { //hand 7
                if (mouseRead == true) {
                    clickPos = 7;
                }
            }

            //User Playables from left to right
            if (x > 306 && x < 384 && y > 500 && y < 633) { //space 1
                System.out.println("Space 1");
                if (mouseRead == true) {
                    clickPos = 11;
                }
                
                if (gameState == 1) {
                    if (field[0].getState() == 0) {
                        field[0].setAtk(hand[0].getAtk());
                        field[0].setHp(hand[0].getHp());
                        field[0].setState(2);
                        userCMana -= hand[0].getCost();
                        hand[0].setState(0);
                        field[0].setExhausted(1);
                        cards.setVisible(false);
                        cards14.setIcon(getImageIcon(new File("images/PHP.png")));
                        cards14.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                } else if (gameState == 2) {
                    if (field[0].getState() == 0) {
                        field[0].setAtk(hand[1].getAtk());
                        field[0].setHp(hand[1].getHp());
                        field[0].setState(2);
                        boolean cssPlayed = false;
                        for (int i = 0; i < 6; i++) {
                            if (!cssPlayed && field[i].getState() == 0) {
                                cssPlayed = true;
                                field[i].setAtk(2);
                                field[i].setHp(2);
                                field[i].setState(2);
                                field[i].setExhausted(1);
                                if (i == 0) {
                                    cards14.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards14.setVisible(true);
                                } else if (i == 1) {
                                    cards15.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards15.setVisible(true);
                                } else if (i == 2) {
                                    cards16.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards16.setVisible(true);
                                } else if (i == 3) {
                                    cards17.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards17.setVisible(true);
                                } else if (i == 4) {
                                    cards18.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards18.setVisible(true);
                                } else if (i == 5) {
                                    cards19.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards19.setVisible(true);
                                } else if (i == 6) {
                                    cards20.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards20.setVisible(true);
                                }
                            }

                        }
                        userCMana -= hand[1].getCost();
                        hand[1].setState(0);
                        field[0].setExhausted(1);
                        cards1.setVisible(false);
                        cards14.setIcon(getImageIcon(new File("images/HTML.png")));
                        cards14.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                }
                else if(gameState == 100){
                    if(field[0].getState()==2 && field[0].getExhausted() == 0){
                        gameState = 11;
                    }         
                }

            }
            if (x > 394 && x < 472 && y > 500 && y < 633) { //space 2
                System.out.println("Space 2");
                if (mouseRead == true) {
                    clickPos = 12;
                }
                if (gameState == 1) {
                    if (field[1].getState() == 0) {
                        field[1].setAtk(hand[0].getAtk());
                        field[1].setHp(hand[0].getHp());
                        field[1].setState(2);
                        userCMana -= hand[0].getCost();
                        hand[0].setState(0);
                        field[1].setExhausted(1);
                        cards.setVisible(false);
                        cards15.setIcon(getImageIcon(new File("images/PHP.png")));
                        cards15.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                } else if (gameState == 2) {
                    if (field[1].getState() == 0) {
                        field[1].setAtk(hand[1].getAtk());
                        field[1].setHp(hand[1].getHp());
                        field[1].setState(2);
                        boolean cssPlayed = false;
                        for (int i = 0; i < 6; i++) {
                            if (!cssPlayed && field[i].getState() == 0) {
                                cssPlayed = true;
                                field[i].setAtk(2);
                                field[i].setHp(2);
                                field[i].setState(2);
                                field[i].setExhausted(1);
                                if (i == 0) {
                                    cards14.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards14.setVisible(true);
                                } else if (i == 1) {
                                    cards15.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards15.setVisible(true);
                                } else if (i == 2) {
                                    cards16.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards16.setVisible(true);
                                } else if (i == 3) {
                                    cards17.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards17.setVisible(true);
                                } else if (i == 4) {
                                    cards18.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards18.setVisible(true);
                                } else if (i == 5) {
                                    cards19.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards19.setVisible(true);
                                } else if (i == 6) {
                                    cards20.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards20.setVisible(true);
                                }
                            }

                        }
                        userCMana -= hand[1].getCost();
                        hand[1].setState(0);
                        field[1].setExhausted(1);
                        cards1.setVisible(false);
                        cards15.setIcon(getImageIcon(new File("images/HTML.png")));
                        cards15.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                }
                else if(gameState == 100){
                    if(field[1].getState()==2 && field[1].getExhausted() == 0){
                        gameState = 12;
                    }         
                }
            }
            if (x > 482 && x < 560 && y > 500 && y < 633) { //space 3
                System.out.println("Space 3");
                if (mouseRead == true) {
                    clickPos = 13;
                }
                if (gameState == 1) {
                    if (field[2].getState() == 0) {
                        field[2].setAtk(hand[0].getAtk());
                        field[2].setHp(hand[0].getHp());
                        field[2].setState(2);
                        userCMana -= hand[0].getCost();
                        hand[0].setState(0);
                        field[2].setExhausted(1);
                        cards.setVisible(false);
                        cards16.setIcon(getImageIcon(new File("images/PHP.png")));
                        cards16.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                } else if (gameState == 2) {
                    if (field[2].getState() == 0) {
                        field[2].setAtk(hand[1].getAtk());
                        field[2].setHp(hand[1].getHp());
                        field[2].setState(2);
                        boolean cssPlayed = false;
                        for (int i = 0; i < 6; i++) {
                            if (!cssPlayed && field[i].getState() == 0) {
                                cssPlayed = true;
                                field[i].setAtk(2);
                                field[i].setHp(2);
                                field[i].setState(2);
                                field[i].setExhausted(1);
                                if (i == 0) {
                                    cards14.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards14.setVisible(true);
                                } else if (i == 1) {
                                    cards15.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards15.setVisible(true);
                                } else if (i == 2) {
                                    cards16.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards16.setVisible(true);
                                } else if (i == 3) {
                                    cards17.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards17.setVisible(true);
                                } else if (i == 4) {
                                    cards18.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards18.setVisible(true);
                                } else if (i == 5) {
                                    cards19.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards19.setVisible(true);
                                } else if (i == 6) {
                                    cards20.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards20.setVisible(true);
                                }
                            }

                        }
                        userCMana -= hand[1].getCost();
                        hand[1].setState(0);
                        field[2].setExhausted(1);
                        cards1.setVisible(false);
                        cards16.setIcon(getImageIcon(new File("images/HTML.png")));
                        cards16.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                }
                else if(gameState == 100){
                    if(field[2].getState()==2 && field[2].getExhausted() == 0){
                        gameState = 13;
                    }         
                }
            }
            if (x > 570 && x < 648 && y > 500 && y < 633) { //space 4
                System.out.println("Space 4");
                if (mouseRead == true) {
                    clickPos = 14;
                }
                if (gameState == 1) {
                    if (field[3].getState() == 0) {
                        field[3].setAtk(hand[0].getAtk());
                        field[3].setHp(hand[0].getHp());
                        field[3].setState(2);
                        userCMana -= hand[0].getCost();
                        hand[0].setState(0);
                        field[3].setExhausted(1);
                        cards.setVisible(false);
                        cards17.setIcon(getImageIcon(new File("images/PHP.png")));
                        cards17.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                } else if (gameState == 2) {
                    if (field[3].getState() == 0) {
                        field[3].setAtk(hand[1].getAtk());
                        field[3].setHp(hand[1].getHp());
                        field[3].setState(2);
                        boolean cssPlayed = false;
                        for (int i = 0; i < 6; i++) {
                            if (!cssPlayed && field[i].getState() == 0) {
                                cssPlayed = true;
                                field[i].setAtk(2);
                                field[i].setHp(2);
                                field[i].setState(2);
                                field[i].setExhausted(1);
                                if (i == 0) {
                                    cards14.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards14.setVisible(true);
                                } else if (i == 1) {
                                    cards15.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards15.setVisible(true);
                                } else if (i == 2) {
                                    cards16.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards16.setVisible(true);
                                } else if (i == 3) {
                                    cards17.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards17.setVisible(true);
                                } else if (i == 4) {
                                    cards18.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards18.setVisible(true);
                                } else if (i == 5) {
                                    cards19.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards19.setVisible(true);
                                } else if (i == 6) {
                                    cards20.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards20.setVisible(true);
                                }
                            }

                        }
                        userCMana -= hand[1].getCost();
                        hand[1].setState(0);
                        field[3].setExhausted(1);
                        cards1.setVisible(false);
                        cards17.setIcon(getImageIcon(new File("images/HTML.png")));
                        cards17.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                }
                else if(gameState == 100){
                    System.out.println(field[3].getState());
                    if(field[3].getState()==2 && field[3].getExhausted() == 0){
                        gameState = 14;
                    }         
                }
            }
            if (x > 658 && x < 736 && y > 500 && y < 633) { //space 5
                System.out.println("Space 5");
                if (mouseRead == true) {
                    clickPos = 15;
                }
                if (gameState == 1) {
                    if (field[4].getState() == 0) {
                        field[4].setAtk(hand[0].getAtk());
                        field[4].setHp(hand[0].getHp());
                        field[4].setState(2);
                        userCMana -= hand[0].getCost();
                        hand[0].setState(0);
                        field[4].setExhausted(1);
                        cards.setVisible(false);
                        cards18.setIcon(getImageIcon(new File("images/PHP.png")));
                        cards18.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                } else if (gameState == 2) {
                    if (field[4].getState() == 0) {
                        field[4].setAtk(hand[1].getAtk());
                        field[4].setHp(hand[1].getHp());
                        field[4].setState(2);
                        boolean cssPlayed = false;
                        for (int i = 0; i < 6; i++) {
                            if (!cssPlayed && field[i].getState() == 0) {
                                cssPlayed = true;
                                field[i].setAtk(2);
                                field[i].setHp(2);
                                field[i].setState(2);
                                field[i].setExhausted(1);
                                if (i == 0) {
                                    cards14.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards14.setVisible(true);
                                } else if (i == 1) {
                                    cards15.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards15.setVisible(true);
                                } else if (i == 2) {
                                    cards16.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards16.setVisible(true);
                                } else if (i == 3) {
                                    cards17.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards17.setVisible(true);
                                } else if (i == 4) {
                                    cards18.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards18.setVisible(true);
                                } else if (i == 5) {
                                    cards19.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards19.setVisible(true);
                                } else if (i == 6) {
                                    cards20.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards20.setVisible(true);
                                }
                            }

                        }
                        userCMana -= hand[1].getCost();
                        hand[1].setState(0);
                        field[4].setExhausted(1);
                        cards1.setVisible(false);
                        cards18.setIcon(getImageIcon(new File("images/HTML.png")));
                        cards18.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                }
                else if(gameState == 100){
                    if(field[4].getState()==2 && field[4].getExhausted() == 0){
                        gameState = 15;
                    }         
                }
            }
            if (x > 746 && x < 824 && y > 500 && y < 633) { //space 6
                System.out.println("Space 6");
                if (mouseRead == true) {
                    clickPos = 16;
                }
                if (gameState == 1) {
                    if (field[5].getState() == 0) {
                        field[5].setAtk(hand[0].getAtk());
                        field[5].setHp(hand[0].getHp());
                        field[5].setState(2);
                        userCMana -= hand[0].getCost();
                        hand[0].setState(0);
                        field[5].setExhausted(1);
                        cards.setVisible(false);
                        cards19.setIcon(getImageIcon(new File("images/PHP.png")));
                        cards19.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                } else if (gameState == 2) {
                    if (field[5].getState() == 0) {
                        field[5].setAtk(hand[1].getAtk());
                        field[5].setHp(hand[1].getHp());
                        field[5].setState(2);
                        boolean cssPlayed = false;
                        for (int i = 0; i < 6; i++) {
                            if (!cssPlayed && field[i].getState() == 0) {
                                cssPlayed = true;
                                field[i].setAtk(2);
                                field[i].setHp(2);
                                field[i].setState(2);
                                field[i].setExhausted(1);
                                if (i == 0) {
                                    cards14.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards14.setVisible(true);
                                } else if (i == 1) {
                                    cards15.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards15.setVisible(true);
                                } else if (i == 2) {
                                    cards16.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards16.setVisible(true);
                                } else if (i == 3) {
                                    cards17.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards17.setVisible(true);
                                } else if (i == 4) {
                                    cards18.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards18.setVisible(true);
                                } else if (i == 5) {
                                    cards19.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards19.setVisible(true);
                                } else if (i == 6) {
                                    cards20.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards20.setVisible(true);
                                }
                            }

                        }
                        userCMana -= hand[1].getCost();
                        hand[1].setState(0);
                        field[5].setExhausted(1);
                        cards1.setVisible(false);
                        cards19.setIcon(getImageIcon(new File("images/HTML.png")));
                        cards19.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                }
                else if(gameState == 100){
                    if(field[5].getState()==2 && field[5].getExhausted() == 0){
                        gameState = 16;
                    }         
                }
            }
            if (x > 834 && x < 912 && y > 500 && y < 633) { //space 7
                System.out.println("Space 7");
                if (mouseRead == true) {
                    clickPos = 17;
                }
                if (gameState == 1) {
                    if (field[6].getState() == 0) {
                        field[6].setAtk(hand[0].getAtk());
                        field[6].setHp(hand[0].getHp());
                        field[6].setState(2);
                        field[6].setState(2);
                        userCMana -= hand[0].getCost();
                        hand[0].setState(0);
                        field[6].setExhausted(1);
                        cards.setVisible(false);
                        cards20.setIcon(getImageIcon(new File("images/PHP.png")));
                        cards20.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                } else if (gameState == 2) {
                    if (field[6].getState() == 0) {
                        field[6].setAtk(hand[1].getAtk());
                        field[6].setHp(hand[1].getHp());
                        field[6].setState(2);
                        boolean cssPlayed = false;
                        for (int i = 0; i < 6; i++) {
                            if (!cssPlayed && field[i].getState() == 0) {
                                cssPlayed = true;
                                field[i].setAtk(2);
                                field[i].setHp(2);
                                field[i].setState(2);
                                field[i].setExhausted(1);
                                if (i == 0) {
                                    cards14.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards14.setVisible(true);
                                } else if (i == 1) {
                                    cards15.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards15.setVisible(true);
                                } else if (i == 2) {
                                    cards16.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards16.setVisible(true);
                                } else if (i == 3) {
                                    cards17.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards17.setVisible(true);
                                } else if (i == 4) {
                                    cards18.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards18.setVisible(true);
                                } else if (i == 5) {
                                    cards19.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards19.setVisible(true);
                                } else if (i == 6) {
                                    cards20.setIcon(getImageIcon(new File("images/CSS.png")));
                                    cards20.setVisible(true);
                                }
                            }

                        }
                        userCMana -= hand[1].getCost();
                        hand[1].setState(0);
                        field[6].setExhausted(1);
                        cards1.setVisible(false);
                        cards20.setIcon(getImageIcon(new File("images/HTML.png")));
                        cards20.setVisible(true);
                        mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                        gameState = 100;
                    }
                }
                else if(gameState == 100){
                    if(field[6].getState()==2 && field[6].getExhausted() == 0){
                        gameState = 17;
                    }         
                }
            }

            //Enemy Playble from left to right
            if (x > 306 && x < 384 && y > 280 && y < 413) {
                if (mouseRead == true) {
                    clickPos = 21;
                }
            }
            if (x > 394 && x < 472 && y > 280 && y < 413) {
                if (mouseRead == true) {
                    clickPos = 22;
                }
            }
            if (x > 482 && x < 560 && y > 280 && y < 413) {
                if (mouseRead == true) {
                    clickPos = 23;
                }
            }
            if (x > 570 && x < 648 && y > 280 && y < 413) {
                if (mouseRead == true) {
                    clickPos = 24;
                }
            }
            if (x > 658 && x < 736 && y > 280 && y < 413) {
                if (mouseRead == true) {
                    clickPos = 25;
                }
            }
            if (x > 746 && x < 824 && y > 280 && y < 413) {
                if (mouseRead == true) {
                    clickPos = 26;
                }
            }
            if (x > 834 && x < 912 && y > 280 && y < 413) {
                if (mouseRead == true) {
                    clickPos = 27;
                }
            }

            //Heroes
            if (x > 575 && x < 660 && y > 160 && y < 240) {
                System.out.println("Face");
                if (mouseRead == true) {
                    clickPos = 31;
                }
                switch(gameState){
                    case 11:
                        enemyHealth-=field[0].getAtk();
                        field[0].setExhausted(1);
                        if(enemyHealth<=0){
                            gameState = 4;
                            enemyHealth = 0;
                        }
                        else
                            gameState = 100;
                        enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                        break;
                    case 12:
                        enemyHealth-=field[1].getAtk();
                        field[1].setExhausted(1);
                        if(enemyHealth<=0){
                            gameState = 4;
                            enemyHealth = 0;
                        }
                        else
                            gameState = 100;
                        enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                        break;
                    case 13:
                        enemyHealth-=field[2].getAtk();
                        field[2].setExhausted(1);
                        if(enemyHealth<=0){
                            gameState = 4;
                            enemyHealth = 0;
                        }
                        else
                            gameState = 100;
                        enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                        break;
                    case 14:
                        enemyHealth-=field[3].getAtk();
                        field[3].setExhausted(1);
                        if(enemyHealth<=0){
                            gameState = 4;
                            enemyHealth = 0;
                        }
                        else
                            gameState = 100;
                        enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                        break;
                    case 15:
                        enemyHealth-=field[4].getAtk();
                        field[4].setExhausted(1);
                        if(enemyHealth<=0){
                            gameState = 4;
                            enemyHealth = 0;
                        }
                        else
                            gameState = 100;
                        enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                        break;
                    case 16:
                        enemyHealth-=field[5].getAtk();
                        field[5].setExhausted(1);
                        if(enemyHealth<=0){
                            gameState = 4;
                            enemyHealth = 0;
                        }
                        else
                            gameState = 100;
                        enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                        break;
                    case 17:
                        enemyHealth-=field[6].getAtk();
                        field[6].setExhausted(1);
                        if(enemyHealth<=0){
                            gameState = 4;
                            enemyHealth = 0;
                        }
                        else
                            gameState = 100;
                        enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                        break;
                    default:
                        break;
                }
            }
            if (x > 570 && x < 660 && y > 630 && y < 715) {
                if (mouseRead == true) {
                    clickPos = 32;
                }
            }

            if (x > 1050 && x < 1200 && y > 500 && y < 775) {
                if (mouseRead == true) {
                    clickPos = 100;
                }
                if (gameState != 4) {
                    System.out.println("work");
                    for (int i = 0; i < 7; i++) {
                        field[i].setExhausted(0);
                    }
                    if (userMana < 10) {
                        userMana++;
                    }
                    userCMana = userMana;
                    mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                }
                    
            }
        }

        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();

            repaint();
        }

    }

    public ImageIcon getImageIcon(File f) {

        try {
            Image im = ImageIO.read(f);

            ii = new ImageIcon(im);

        } catch (IOException i) {

            i.printStackTrace();

        } finally {

            return ii;

        }

    }

}
