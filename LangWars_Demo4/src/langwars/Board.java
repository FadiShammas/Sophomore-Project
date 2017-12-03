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
//playminion(hand, pos) method

    public static Boolean mouseRead = false;
    public static int clickPos = 0;
    public static Boolean endturn = false;
    public static int gameState = 1;
    public static Creature[] hand = new Creature[2];
    public static Creature[] field = new Creature[7];
    public static Creature css = new Creature("CSS", 2, 0, 6, 2, 2);
    public static Creature[] eHand = new Creature[7];
    public static Creature[] eField = new Creature[7];
    public int health = 10;
    public int enemyHealth = 10;
    public int userMana = 0;
    public int userCMana = 0;
    public int enemyMana = 0;
    public int enemyCMana = 0;
    public int turnCount = 0;
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

    public static void main(String[] args) 
    {

        try 
        {
            Thread.sleep(4500);
        } 
        
        catch (Exception e) 
        {
        }

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

                        System.out.println("User Clicked on End Turn Button");

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
                            enemyM.setText("Mana: " + String.valueOf(enemyCMana) + "/" + String.valueOf(enemyMana));

                            //Computer Logic Goes Here
                                                        
                            if (turnCount == 0) {
                                cards7.setVisible(true);}
                            else if (turnCount == 1) {
                                cards8.setVisible(true);}
                            else if (turnCount == 2) {
                                cards9.setVisible(true);}
                            else if (turnCount == 3) {
                                cards10.setVisible(true);}
                            else if (turnCount == 4) {
                                cards11.setVisible(true);}
                            else if (turnCount == 5) {
                                cards12.setVisible(true);}
                            else if (turnCount == 6) {
                                cards13.setVisible(true);}
                            
                            turnCount++;
                            
                            //enemyPlayMinion(int handpos, int boardpos, int mechanic, String file                            

                            if (cards7.isVisible()) {
                                if (enemyCMana > 7) {
                                    enemyPlayMinion(1, 1, eHand[0].getMechanic(), "images/java_2.png");}
                            }

                            if (cards8.isVisible()) {
                                if (enemyCMana > 7) {
                                    enemyPlayMinion(2, 2, eHand[1].getMechanic(), "images/python_4.png");}
                            }
                            
                            if (cards9.isVisible()) {
                                if (enemyCMana > 4) {
                                    enemyPlayMinion(3, 3, eHand[2].getMechanic(), "images/ruby_4.png");}
                            }

                            if (cards10.isVisible()) {
                                if (enemyCMana > 6) {
                                    enemyPlayMinion(4, 4, eHand[3].getMechanic(), "images/sql_4.png");}
                            }

                            if (cards11.isVisible()) {
                                if (enemyCMana > 4) {
                                    enemyPlayMinion(5, 5, eHand[4].getMechanic(), "images/php_5.png");}
                            }

                            if (cards12.isVisible()) {
                                if (enemyCMana > 5) {
                                    enemyPlayMinion(6, 6, eHand[5].getMechanic(), "images/swift_4.png");}
                            }

                            if (cards13.isVisible()) {
                                if (enemyCMana > 7) {
                                    enemyPlayMinion(7, 7, eHand[6].getMechanic(), "images/c++_4.png");}
                            }
                                                                                   
                        } else {
                            frame.dispose();
                        }
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
                    field[i] = new Creature("blank", 0, 0, 0, 0, 0);
                }
                hand[0] = new Creature("PHP", 1, 0, 4, 4, 5);
                hand[1] = new Creature("HTML", 1, 1, 6, 3, 4);
                Creature css = new Creature("CSS", 2, 0, 6, 2, 2);
                cards.setIcon(getImageIcon(new File("images/php_5.png")));
                cards.setVisible(true);
                cards1.setIcon(getImageIcon(new File("images/html_4.png")));
                cards1.setVisible(true);
                
                for (int i = 0; i < 7; i++) {
                    eField[i] = new Creature("blank", 0, 0, 0, 0, 0);
                }                
                
                //(String name, int state, int mechanic, int cost, int atk, int hp)
                eHand[0] = new Creature("Java", 1, 0, 7, 10, 2);
                eHand[1] = new Creature("Python", 1, 0, 7, 3, 4);
                eHand[2] = new Creature("Ruby", 1, 0, 4, 3, 4);
                eHand[3] = new Creature("SQL", 1, 0, 6, 6, 4);
                eHand[4] = new Creature("PHP", 1, 0, 4, 4, 5);
                eHand[5] = new Creature("Swift", 1, 0, 5, 4, 4);
                eHand[6] = new Creature("C++", 1, 0, 7, 4, 4);
                cards7.setIcon(getImageIcon(new File("images/java_2.png")));
                cards7.setVisible(false);
                cards8.setIcon(getImageIcon(new File("images/python_4.png")));
                cards8.setVisible(false);
                cards9.setIcon(getImageIcon(new File("images/ruby_4.png")));
                cards9.setVisible(false);
                cards10.setIcon(getImageIcon(new File("images/sql_4.png")));
                cards10.setVisible(false);
                cards11.setIcon(getImageIcon(new File("images/php_5.png")));
                cards11.setVisible(false);
                cards12.setIcon(getImageIcon(new File("images/swift_4.png")));
                cards12.setVisible(false);
                cards13.setIcon(getImageIcon(new File("images/c++_4.png")));
                cards13.setVisible(false);
            }
            
            public void loadBoard() {
                JPanel board = new JPanel();
                JLabel bLabel = new JLabel();
                bLabel.setIcon(getImageIcon(new File("images/board.jpg")));
                board.setBounds(0, 0, 1200, 840);
                board.add(bLabel);
                frame.add(board);
            }

            public void enemyPlayMinion(int handpos, int boardpos, int mechanic, String file) {
            if (eField[boardpos - 1].getState() == 0) {
                eField[boardpos - 1].setAtk(eHand[handpos - 1].getAtk());
                eField[boardpos - 1].setHp(eHand[handpos - 1].getHp());
                eField[boardpos - 1].setState(2);
                enemyCMana -= eHand[handpos -1].getCost();
                eHand[handpos - 1].setState(0);
                eField[boardpos - 1].setExhausted(1);
                switch (handpos) {
                    case 1:
                        cards7.setVisible(false);
                        break;
                    case 2:
                        cards8.setVisible(false);
                        break;
                    case 3:
                        cards9.setVisible(false);
                        break;
                    case 4:
                        cards10.setVisible(false);
                        break;
                    case 5:
                        cards11.setVisible(false);
                        break;
                    case 6:
                        cards12.setVisible(false);
                        break;
                    case 7:
                        cards13.setVisible(false);
                        
                }
                
                switch (boardpos) {
                    case 1:
                        cards21.setVisible(true);
                        cards21.setIcon(getImageIcon(new File(file)));
                        break;
                    case 2:
                        cards22.setVisible(true);
                        cards22.setIcon(getImageIcon(new File(file)));
                        break;
                    case 3:
                        cards23.setVisible(true);
                        cards23.setIcon(getImageIcon(new File(file)));
                        break;
                    case 4:
                        cards24.setVisible(true);
                        cards24.setIcon(getImageIcon(new File(file)));
                        break;
                    case 5:
                        cards25.setVisible(true);
                        cards25.setIcon(getImageIcon(new File(file)));
                        break;
                    case 6:
                        cards26.setVisible(true);
                        cards26.setIcon(getImageIcon(new File(file)));
                        break;
                    case 7:
                        cards27.setVisible(true);
                        cards27.setIcon(getImageIcon(new File(file)));
                }

                enemyM.setText("Mana: " + String.valueOf(enemyCMana) + "/" + String.valueOf(enemyMana));
                gameState = 100;
            }
        }
            
        });
    }

    public class MouseHandler extends MouseAdapter implements MouseListener {

        public void init() {
            addMouseListener(this);
        }
        
        public void attack(int minion, int target){
            if(target==31){
                enemyHealth -= field[minion-1].getAtk();
                        field[minion-1].setExhausted(1);
                        if (enemyHealth <= 0) {
                            gameState = 4;
                            enemyHealth = 0;
                        } else {
                            gameState = 100;
                        }
                        enemyHP.setText("HP: " + String.valueOf(enemyHealth));
            }
            
        }

        public void playMinion(int handpos, int boardpos, int mechanic, String file) {
            if (field[boardpos - 1].getState() == 0) {
                field[boardpos - 1].setAtk(hand[handpos - 1].getAtk());
                field[boardpos - 1].setHp(hand[handpos - 1].getHp());
                field[boardpos - 1].setState(2);
                enemyCMana -= hand[0].getCost();
                hand[handpos - 1].setState(0);
                field[boardpos - 1].setExhausted(1);
                switch (handpos) {
                    case 1:
                        cards.setVisible(false);
                        break;
                    case 2:
                        cards1.setVisible(false);
                        break;
                    case 3:
                        cards2.setVisible(false);
                        break;
                    case 4:
                        cards3.setVisible(false);
                        break;
                    case 5:
                        cards4.setVisible(false);
                        break;
                    case 6:
                        cards5.setVisible(false);
                        break;
                    case 7:
                        cards6.setVisible(false);
                        
                }
                switch (boardpos) {
                    case 1:
                        cards14.setVisible(true);
                        cards14.setIcon(getImageIcon(new File(file)));
                        break;
                    case 2:
                        cards15.setVisible(true);
                        cards15.setIcon(getImageIcon(new File(file)));
                        break;
                    case 3:
                        cards16.setVisible(true);
                        cards16.setIcon(getImageIcon(new File(file)));
                        break;
                    case 4:
                        cards17.setVisible(true);
                        cards17.setIcon(getImageIcon(new File(file)));
                        break;
                    case 5:
                        cards18.setVisible(true);
                        cards18.setIcon(getImageIcon(new File(file)));
                        break;
                    case 6:
                        cards19.setVisible(true);
                        cards19.setIcon(getImageIcon(new File(file)));
                        break;
                    case 7:
                        cards20.setVisible(true);
                        cards20.setIcon(getImageIcon(new File(file)));
                }
                if(mechanic==1){
                    boolean cssPlayed = false;
                        for (int i = 0; i < 6; i++) {
                            if (!cssPlayed && field[i].getState() == 0) {
                                cssPlayed = true;
                                field[i].setAtk(2);
                                field[i].setHp(2);
                                field[i].setState(2);
                                field[i].setExhausted(1);
                                if (i == 0) {
                                    cards14.setIcon(getImageIcon(new File("images/css_2.png")));
                                    cards14.setVisible(true);
                                } else if (i == 1) {
                                    cards15.setIcon(getImageIcon(new File("images/css_2.png")));
                                    cards15.setVisible(true);
                                } else if (i == 2) {
                                    cards16.setIcon(getImageIcon(new File("images/css_2.png")));
                                    cards16.setVisible(true);
                                } else if (i == 3) {
                                    cards17.setIcon(getImageIcon(new File("images/css_2.png")));
                                    cards17.setVisible(true);
                                } else if (i == 4) {
                                    cards18.setIcon(getImageIcon(new File("images/css_2.png")));
                                    cards18.setVisible(true);
                                } else if (i == 5) {
                                    cards19.setIcon(getImageIcon(new File("images/css_2.png")));
                                    cards19.setVisible(true);
                                } else if (i == 6) {
                                    cards20.setIcon(getImageIcon(new File("images/css_2.png")));
                                    cards20.setVisible(true);
                                }
                            }

                        }
                }
                mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                gameState = 100;
            }
        }

        public void enemyPlayMinion(int handpos, int boardpos, int mechanic, String file) {
            if (eField[boardpos - 1].getState() == 0) {
                eField[boardpos - 1].setAtk(eHand[handpos - 1].getAtk());
                eField[boardpos - 1].setHp(eHand[handpos - 1].getHp());
                eField[boardpos - 1].setState(2);
                enemyCMana -= eHand[0].getCost();
                eHand[handpos - 1].setState(0);
                eField[boardpos - 1].setExhausted(1);
                switch (handpos) {
                    case 1:
                        cards7.setVisible(false);
                        break;
                    case 2:
                        cards8.setVisible(false);
                        break;
                    case 3:
                        cards9.setVisible(false);
                        break;
                    case 4:
                        cards10.setVisible(false);
                        break;
                    case 5:
                        cards11.setVisible(false);
                        break;
                    case 6:
                        cards12.setVisible(false);
                        break;
                    case 7:
                        cards13.setVisible(false);
                        
                }
                
                switch (boardpos) {
                    case 1:
                        cards21.setVisible(true);
                        cards21.setIcon(getImageIcon(new File(file)));
                        break;
                    case 2:
                        cards22.setVisible(true);
                        cards22.setIcon(getImageIcon(new File(file)));
                        break;
                    case 3:
                        cards23.setVisible(true);
                        cards23.setIcon(getImageIcon(new File(file)));
                        break;
                    case 4:
                        cards24.setVisible(true);
                        cards24.setIcon(getImageIcon(new File(file)));
                        break;
                    case 5:
                        cards25.setVisible(true);
                        cards25.setIcon(getImageIcon(new File(file)));
                        break;
                    case 6:
                        cards26.setVisible(true);
                        cards26.setIcon(getImageIcon(new File(file)));
                        break;
                    case 7:
                        cards27.setVisible(true);
                        cards27.setIcon(getImageIcon(new File(file)));
                }

                enemyM.setText("Mana: " + String.valueOf(enemyCMana) + "/" + String.valueOf(enemyMana));
                gameState = 100;
            }
        }
        
        public void mouseClicked(MouseEvent e) {
            System.out.println("\nGame State: " + gameState);
            
            //Enemy Cards from left to right
            if (x > 1 && x < 78 && y > 0 && y < 180) {
                //enemy deck
                System.out.println("User Clicked on Enemy Deck");
                if (mouseRead == true) {
                    clickPos = 80;
                }

                if (gameState == 100) {
                    if (eHand[0].getState() == 1 && userCMana >= eHand[0].getCost()) {
                        gameState = 1;
                    }
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
                if (mouseRead == true) {
                    clickPos = 1;
                }
                if (gameState == 100) {
                    if (hand[0].getState() == 1 && userCMana >= hand[0].getCost()) {
                        gameState = 1;
                    }
                }

            }
            if (x > 223 && x < 301 && y > 720 && y < 853) { //hand 2
                if (mouseRead == true) {
                    clickPos = 2;
                }
                if (gameState == 100) {
                    if (hand[1].getState() == 1 && userCMana >= hand[1].getCost()) {
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
                    playMinion(1, 1, hand[0].getMechanic(), "images/php_5.png");
                } else if (gameState == 2) {
                    playMinion(2, 1, hand[1].getMechanic(), "images/html_4.png");
                } else if (gameState == 100) {
                    if (field[0].getState() == 2 && field[0].getExhausted() == 0) {
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
                    playMinion(1, 2, hand[0].getMechanic(), "images/php_5.png");
                } else if (gameState == 2) {
                    playMinion(2, 2, hand[1].getMechanic(), "images/html_4.png");
                } else if (gameState == 100) {
                    if (field[1].getState() == 2 && field[1].getExhausted() == 0) {
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
                    playMinion(1, 3, hand[0].getMechanic(), "images/php_5.png");
                } else if (gameState == 2) {
                    playMinion(2, 3, hand[1].getMechanic(), "images/html_4.png");
                } else if (gameState == 100) {
                    if (field[2].getState() == 2 && field[2].getExhausted() == 0) {
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
                    playMinion(1, 4, hand[0].getMechanic(), "images/php_5.png");
                } else if (gameState == 2) {
                    playMinion(2, 4, hand[1].getMechanic(), "images/html_4.png");
                } else if (gameState == 100) {
                    System.out.println(field[3].getState());
                    if (field[3].getState() == 2 && field[3].getExhausted() == 0) {
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
                    playMinion(1, 5, hand[0].getMechanic(), "images/php_5.png");
                } else if (gameState == 2) {
                    playMinion(2, 5, hand[1].getMechanic(), "images/html_4.png");
                } else if (gameState == 100) {
                    if (field[4].getState() == 2 && field[4].getExhausted() == 0) {
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
                    playMinion(1, 6, hand[0].getMechanic(), "images/php_5.png");
                } else if (gameState == 2) {
                    playMinion(2, 1, hand[1].getMechanic(), "images/html_4.png");
                } else if (gameState == 100) {
                    if (field[5].getState() == 2 && field[5].getExhausted() == 0) {
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
                    playMinion(1, 7, hand[0].getMechanic(), "images/php_5.png");
                } else if (gameState == 2) {
                    playMinion(2, 7, hand[1].getMechanic(), "images/html_4.png");
                } else if (gameState == 100) {
                    if (field[6].getState() == 2 && field[6].getExhausted() == 0) {
                        gameState = 17;
                    }
                }
            }

            //Enemy Playble from left to right
            if (x > 306 && x < 384 && y > 280 && y < 413) {
                System.out.println("User Clicked on Enemy Playable 1");
                if (mouseRead == true) {
                    clickPos = 21;
                }
            }
            if (x > 394 && x < 472 && y > 280 && y < 413) {
                System.out.println("User Clicked on Enemy Playable 2");
                if (mouseRead == true) {
                    clickPos = 22;
                }
            }
            if (x > 482 && x < 560 && y > 280 && y < 413) {
                System.out.println("User Clicked on Enemy Playable 3");
                if (mouseRead == true) {
                    clickPos = 23;
                }
            }
            if (x > 570 && x < 648 && y > 280 && y < 413) {
                System.out.println("User Clicked on Enemy Playable 4");
                if (mouseRead == true) {
                    clickPos = 24;
                }
            }
            if (x > 658 && x < 736 && y > 280 && y < 413) {
                System.out.println("User Clicked on Enemy Playable 5");
                if (mouseRead == true) {
                    clickPos = 25;
                }
            }
            if (x > 746 && x < 824 && y > 280 && y < 413) {
                System.out.println("User Clicked on Enemy Playable 6");
                if (mouseRead == true) {
                    clickPos = 26;
                }
            }
            if (x > 834 && x < 912 && y > 280 && y < 413) {
                System.out.println("User Clicked on Enemy Playable 7");
                if (mouseRead == true) {
                    clickPos = 27;
                }
            }

            //Heroes
            if (x > 575 && x < 660 && y > 160 && y < 240) {
                System.out.println("User Clicked on Enemy Face");
                if (mouseRead == true) {
                    clickPos = 31;
                }
                if(gameState>10 && gameState<18)
                    attack(gameState-10, 31);
            }
            if (x > 570 && x < 660 && y > 630 && y < 715) {
                System.out.println("User Clicked on User Face");
                if (mouseRead == true) {
                    clickPos = 32;
                }
            }

            if (x > 1050 && x < 1200 && y > 500 && y < 775) {
                if (mouseRead == true) {
                    clickPos = 100;
                }
            }
            
            //Right Click Magnify
            if (e.getModifiers() == MouseEvent.BUTTON3_MASK)
            {
                if(x>135 && x<213 && y>720 && y<853){
                    cards.setBounds(500,400,233,359);  
                    card.setIcon(getImageIcon(new File("images/c#_big.png")));
                }
                else
                {
                    cards.setBounds(135,685,78,120);
                    card.setIcon(getImageIcon(new File("images/c#_3.png")));
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
