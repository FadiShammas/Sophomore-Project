package langwars;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Random;

public class Board extends JFrame {
//playminion(hand, pos) method

    public static Boolean mouseRead = false;
    public static int clickPos = 0;
    public static Boolean endturn = false;
    public static int gameState = 1;
    public static Creature[] deck = new Creature[9];
    public static Creature[] hand = new Creature[7];
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
    public String playerHandCard1;
    public String playerHandCard2;
    public String playerHandCard3;
    public String playerHandCard4;
    public String playerHandCard5;
    public String playerHandCard6;
    public String playerHandCard7;
    public String enemyHandCard1;
    public String enemyHandCard2;
    public String enemyHandCard3;
    public String enemyHandCard4;
    public String enemyHandCard5;
    public String enemyHandCard6;
    public String enemyHandCard7;
    
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

                        if (gameState != 99) {
                            for (int i = 0; i < 7; i++) {
                                field[i].setExhausted(0);
                            }

                            gameState = 100;
                                                        
                            //Player Mana
                            if (userMana < 10) {
                                userMana++;
                            }
                            userCMana = userMana;
                            mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                            
                            //Player Card Draw                            
                            if (turnCount == 0) {
                                cards1.setVisible(true);}
                            else if (turnCount == 1) {
                                cards2.setVisible(true);}
                            else if (turnCount == 2) {
                                cards3.setVisible(true);}
                            else if (turnCount == 3) {
                                cards4.setVisible(true);}
                            else if (turnCount == 4) {
                                cards5.setVisible(true);}
                            else if (turnCount == 5) {
                                cards6.setVisible(true);}
                            
                            //Computer Mana
                            if (enemyMana < 10) {
                                enemyMana++;
                            }
                            enemyCMana = enemyMana;
                            enemyM.setText("Mana: " + String.valueOf(enemyCMana) + "/" + String.valueOf(enemyMana));
                            
                            if (cards7.isVisible()) {
                                if (enemyCMana > eHand[0].getCost()) {
                                    enemyPlayMinion(1, 1, eHand[0].getMechanic(), "images/" + eHand[0].getName() + "_" + eHand[0].getHp() + ".png");}
                            }

                            if (cards8.isVisible()) {
                                if (enemyCMana > eHand[1].getCost()) {
                                    enemyPlayMinion(2, 2, eHand[1].getMechanic(), "images/" + eHand[1].getName() + "_" + eHand[1].getHp() + ".png");}
                            }
                            
                            if (cards9.isVisible()) {
                                if (enemyCMana > eHand[2].getCost()) {
                                    enemyPlayMinion(3, 3, eHand[2].getMechanic(), "images/" + eHand[2].getName() + "_" + eHand[2].getHp() + ".png");}
                            }

                            if (cards10.isVisible()) {
                                if (enemyCMana > eHand[3].getCost()) {
                                    enemyPlayMinion(4, 4, eHand[3].getMechanic(), "images/" + eHand[3].getName() + "_" + eHand[3].getHp() + ".png");}
                            }

                            if (cards11.isVisible()) {
                                if (enemyCMana > eHand[4].getCost()) {
                                    enemyPlayMinion(5, 5, eHand[4].getMechanic(), "images/" + eHand[4].getName() + "_" + eHand[4].getHp() + ".png");}
                            }

                            if (cards12.isVisible()) {
                                if (enemyCMana > eHand[5].getCost()) {
                                    enemyPlayMinion(6, 6, eHand[5].getMechanic(), "images/" + eHand[5].getName() + "_" + eHand[5].getHp() + ".png");}
                            }

                            if (cards13.isVisible()) {
                                if (enemyCMana > eHand[6].getCost()) {
                                    enemyPlayMinion(7, 7, eHand[6].getMechanic(), "images/" + eHand[6].getName() + "_" + eHand[6].getHp() + ".png");}
                            }
                                                        
                            
                            //Computer Card Draw                                                        
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
                            
                        } else {

                            //Game End                            
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
                hp.setBounds(900, 685, 150, 50);
                hp.setFont(new Font("Courier New", Font.BOLD, 40));
                hp.setForeground(Color.green);
                frame.add(hp);

                //Enemy
                enemyHP.setText("HP: " + String.valueOf(enemyHealth));
                enemyHP.setBounds(900, 5, 150, 50);
                enemyHP.setFont(new Font("Courier New", Font.BOLD, 40));
                enemyHP.setForeground(Color.green);
                frame.add(enemyHP);

                //Mana
                //User
                mana.setText("Mana: " + String.valueOf(userCMana) + "/" + String.valueOf(userMana));
                mana.setBounds(875, 735, 300, 70);
                mana.setFont(new Font("Courier New", Font.BOLD, 40));
                mana.setForeground(Color.blue);
                frame.add(mana);

                //Enemy
                //JLabel enemyM = new JLabel();
                enemyM.setText("Mana: " + String.valueOf(enemyMana) + "/" + String.valueOf(enemyCMana));
                enemyM.setBounds(875, 40, 300, 70);
                enemyM.setFont(new Font("Courier New", Font.BOLD, 40));
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

                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                runGame();

            }

            public void runGame() {

                //Game State Definions
                //100 = Beginning of Turn
                //Card # = Card Selected
                //0 = End of Turn
                //99 = End of Game
                
                gameState = 100;
                
                //Deck
                //String name, int state, int mechanic, int cost, int atk, int hp
                deck[0] = new Creature("c#", 1, 0, 7, 3, 3); 
                deck[1] = new Creature("c++", 1, 0, 6, 4, 8);
                deck[2] = new Creature("html", 1, 0, 6, 3, 4);
                deck[3] = new Creature("swift", 1, 0, 5, 4, 4);
                deck[4] = new Creature("java", 1, 0, 7, 10, 2);
                deck[5] = new Creature("php", 1, 0, 4, 4, 5);
                deck[6] = new Creature("python", 1, 0, 7, 3, 4);
                deck[7] = new Creature("ruby", 1, 0, 4, 3, 4);
                deck[8] = new Creature("sql", 1, 0, 6, 6, 4);

                Creature css = new Creature("CSS", 2, 0, 6, 2, 2);
                
                //Player Hand
                for (int i = 0; i < 7; i++) {
                    field[i] = new Creature("blank", 0, 0, 0, 0, 0);
                }
//                hand[0] = new Creature("PHP", 1, 0, 4, 4, 5);
//                hand[1] = new Creature("HTML", 1, 1, 6, 3, 4);

                Random generator = new Random();
                hand[0] = (deck[new Random().nextInt(deck.length)]);
                hand[1] = (deck[new Random().nextInt(deck.length)]);
                hand[2] = (deck[new Random().nextInt(deck.length)]);
                hand[3] = (deck[new Random().nextInt(deck.length)]);
                hand[4] = (deck[new Random().nextInt(deck.length)]);
                hand[5] = (deck[new Random().nextInt(deck.length)]);
                hand[6] = (deck[new Random().nextInt(deck.length)]);
           
                playerHandCard1 = ("images/" + hand[0].getName() + "_" + hand[0].getHp() + ".png");
                playerHandCard2 = ("images/" + hand[1].getName() + "_" + hand[1].getHp() + ".png");
                playerHandCard3 = ("images/" + hand[2].getName() + "_" + hand[2].getHp() + ".png");
                playerHandCard4 = ("images/" + hand[3].getName() + "_" + hand[3].getHp() + ".png");
                playerHandCard5 = ("images/" + hand[4].getName() + "_" + hand[4].getHp() + ".png");
                playerHandCard6 = ("images/" + hand[5].getName() + "_" + hand[5].getHp() + ".png");
                playerHandCard7 = ("images/" + hand[6].getName() + "_" + hand[6].getHp() + ".png");

                cards.setIcon(getImageIcon(new File(playerHandCard1)));
                cards.setVisible(true);
                cards1.setIcon(getImageIcon(new File(playerHandCard2)));
                cards1.setVisible(false);
                cards2.setIcon(getImageIcon(new File(playerHandCard3)));
                cards2.setVisible(false);
                cards3.setIcon(getImageIcon(new File(playerHandCard4)));
                cards3.setVisible(false);
                cards4.setIcon(getImageIcon(new File(playerHandCard5)));
                cards4.setVisible(false);
                cards5.setIcon(getImageIcon(new File(playerHandCard6)));
                cards5.setVisible(false);
                cards6.setIcon(getImageIcon(new File(playerHandCard7)));
                cards6.setVisible(false);

//                cards1.setIcon(getImageIcon(new File("images/html_4.png")));
//                cards1.setVisible(true);

                //Enemy Hand                
                for (int i = 0; i < 7; i++) {
                    eField[i] = new Creature("blank", 0, 0, 0, 0, 0);
                }                
                
                eHand[0] = (deck[new Random().nextInt(deck.length)]);
                eHand[1] = (deck[new Random().nextInt(deck.length)]);
                eHand[2] = (deck[new Random().nextInt(deck.length)]);
                eHand[3] = (deck[new Random().nextInt(deck.length)]);
                eHand[4] = (deck[new Random().nextInt(deck.length)]);
                eHand[5] = (deck[new Random().nextInt(deck.length)]);
                eHand[6] = (deck[new Random().nextInt(deck.length)]);
           
                enemyHandCard1 = ("images/" + eHand[0].getName() + "_" + eHand[0].getHp() + ".png");
                enemyHandCard2 = ("images/" + eHand[1].getName() + "_" + eHand[1].getHp() + ".png");
                enemyHandCard3 = ("images/" + eHand[2].getName() + "_" + eHand[2].getHp() + ".png");
                enemyHandCard4 = ("images/" + eHand[3].getName() + "_" + eHand[3].getHp() + ".png");
                enemyHandCard5 = ("images/" + eHand[4].getName() + "_" + eHand[4].getHp() + ".png");
                enemyHandCard6 = ("images/" + eHand[5].getName() + "_" + eHand[5].getHp() + ".png");
                enemyHandCard7 = ("images/" + eHand[6].getName() + "_" + eHand[6].getHp() + ".png");

                cards7.setIcon(getImageIcon(new File(enemyHandCard1)));
                cards7.setVisible(false);
                cards8.setIcon(getImageIcon(new File(enemyHandCard2)));
                cards8.setVisible(false);
                cards9.setIcon(getImageIcon(new File(enemyHandCard3)));
                cards9.setVisible(false);
                cards10.setIcon(getImageIcon(new File(enemyHandCard4)));
                cards10.setVisible(false);
                cards11.setIcon(getImageIcon(new File(enemyHandCard5)));
                cards11.setVisible(false);
                cards12.setIcon(getImageIcon(new File(enemyHandCard6)));
                cards12.setVisible(false);
                cards13.setIcon(getImageIcon(new File(enemyHandCard7)));
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
                eField[boardpos - 1].setName(eHand[handpos -1].getName());
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
                userCMana -= hand[handpos -1].getCost();
                hand[handpos - 1].setState(0);
                field[boardpos - 1].setExhausted(1);
                field[boardpos - 1].setName(hand[handpos -1].getName());
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
                eField[boardpos - 1].setName(eHand[handpos -1].getName());
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
//            System.out.println("\nGame State: " + gameState);
            
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
                    if (cards.isVisible() && userCMana >= hand[0].getCost()) {
                        gameState = 1;
                        System.out.println("\nGame State: " + gameState);
                    }
                }

            }
            if (x > 223 && x < 301 && y > 720 && y < 853) { //hand 2
                if (mouseRead == true) {
                    clickPos = 2;
                }
                if (gameState == 100) {
                    if (cards1.isVisible() && userCMana >= hand[1].getCost()) {
                        gameState = 2;
                        System.out.println("\nGame State: " + gameState);
                    }
                }

            }
            if (x > 311 && x < 389 && y > 720 && y < 853) { //hand 3
                if (mouseRead == true) {
                    clickPos = 3;
                }
                if (gameState == 100) {
                    if (cards2.isVisible() && userCMana >= hand[2].getCost()) {
                        gameState = 3;
                        System.out.println("\nGame State: " + gameState);
                    }
                }
            }
            if (x > 399 && x < 477 && y > 720 && y < 853) { //hand 4
                if (mouseRead == true) {
                    clickPos = 4;
                }
                if (gameState == 100) {
                    if (cards3.isVisible() && userCMana >= hand[3].getCost()) {
                        gameState = 4;
                        System.out.println("\nGame State: " + gameState);
                    }
                }    
            }
            if (x > 487 && x < 565 && y > 720 && y < 853) { //hand 5
                if (mouseRead == true) {
                    clickPos = 5;
                }
                if (gameState == 100) {
                    if (cards4.isVisible() && userCMana >= hand[4].getCost()) {
                        gameState = 5;
                        System.out.println("\nGame State: " + gameState);
                    }
                }    
            }
            if (x > 575 && x < 653 && y > 720 && y < 853) { //hand 6
                if (mouseRead == true) {
                    clickPos = 6;
                }
                if (gameState == 100) {
                    if (cards5.isVisible() && userCMana >= hand[5].getCost()) {
                        gameState = 6;
                        System.out.println("\nGame State: " + gameState);
                    }
                }
            }
            if (x > 663 && x < 741 && y > 720 && y < 853) { //hand 7
                if (mouseRead == true) {
                    clickPos = 7;
                }
                if (gameState == 100) {
                    if (cards6.isVisible() && userCMana >= hand[6].getCost()) {
                        gameState = 7;
                        System.out.println("\nGame State: " + gameState);
                    }
                }    
            }
            
            //User Playables from left to right
//            if (x > 306 && x < 384 && y > 500 && y < 633) { //space 1
           if (x > 215 && x < 300 && y > 465 && y < 600) { //space 1
               System.out.println("Space 1");
                
                if (mouseRead == true) {
                    clickPos = 11;
                }
                if (gameState == 1) {
                    playMinion(1, 1, hand[0].getMechanic(), "images/" + hand[0].getName() + "_" + hand[0].getHp() + ".png");
                } else if (gameState == 2) {
                    playMinion(2, 1, hand[1].getMechanic(), "images/" + hand[1].getName() + "_" + hand[1].getHp() + ".png");
                } else if (gameState == 3) {
                    playMinion(3, 1, hand[2].getMechanic(), "images/" + hand[2].getName() + "_" + hand[2].getHp() + ".png");
                } else if (gameState == 4) {
                    playMinion(4, 1, hand[3].getMechanic(), "images/" + hand[3].getName() + "_" + hand[3].getHp() + ".png");
                } else if (gameState == 5) {
                    playMinion(5, 1, hand[4].getMechanic(), "images/" + hand[4].getName() + "_" + hand[4].getHp() + ".png");
                } else if (gameState == 6) {
                    playMinion(6, 1, hand[5].getMechanic(), "images/" + hand[5].getName() + "_" + hand[5].getHp() + ".png");
                } else if (gameState == 7) {
                    playMinion(7, 1, hand[6].getMechanic(), "images/" + hand[6].getName() + "_" + hand[6].getHp() + ".png");
                } else if (gameState == 100) {
                    if (field[0].getState() == 2 && field[0].getExhausted() == 0) {
                        gameState = 11;
                    }
                }
            }
            
//            if (x > 394 && x < 472 && y > 500 && y < 633) { //space 2
            if (x > 335 && x < 420 && y > 465 && y < 600) { //space 2
                System.out.println("Space 2");
                if (mouseRead == true) {
                    clickPos = 12;
                }
                if (gameState == 1) {
                    playMinion(1, 2, hand[0].getMechanic(), "images/" + hand[0].getName() + "_" + hand[0].getHp() + ".png");
                } else if (gameState == 2) {
                    playMinion(2, 2, hand[1].getMechanic(), "images/" + hand[1].getName() + "_" + hand[1].getHp() + ".png");
                } else if (gameState == 3) {
                    playMinion(3, 2, hand[2].getMechanic(), "images/" + hand[2].getName() + "_" + hand[2].getHp() + ".png");
                } else if (gameState == 4) {
                    playMinion(4, 2, hand[3].getMechanic(), "images/" + hand[3].getName() + "_" + hand[3].getHp() + ".png");
                } else if (gameState == 5) {
                    playMinion(5, 2, hand[4].getMechanic(), "images/" + hand[4].getName() + "_" + hand[4].getHp() + ".png");
                } else if (gameState == 6) {
                    playMinion(6, 2, hand[5].getMechanic(), "images/" + hand[5].getName() + "_" + hand[5].getHp() + ".png");
                } else if (gameState == 7) {
                    playMinion(7, 2, hand[6].getMechanic(), "images/" + hand[6].getName() + "_" + hand[6].getHp() + ".png");
                } else if (gameState == 100) {
                    if (field[0].getState() == 2 && field[0].getExhausted() == 0) {
                        gameState = 12;
                    }
                }
            }
//            if (x > 482 && x < 560 && y > 500 && y < 633) { //space 3
            if (x >= 455 && x <= 540 && y >= 465 && y <= 600) { //space 3
                System.out.println("Space 3");
                if (mouseRead == true) {
                    clickPos = 13;
                }
                if (gameState == 1) {
                    playMinion(1, 3, hand[0].getMechanic(), "images/" + hand[0].getName() + "_" + hand[0].getHp() + ".png");
                } else if (gameState == 2) {
                    playMinion(2, 3, hand[1].getMechanic(), "images/" + hand[1].getName() + "_" + hand[1].getHp() + ".png");
                } else if (gameState == 3) {
                    playMinion(3, 3, hand[2].getMechanic(), "images/" + hand[2].getName() + "_" + hand[2].getHp() + ".png");
                } else if (gameState == 4) {
                    playMinion(4, 3, hand[3].getMechanic(), "images/" + hand[3].getName() + "_" + hand[3].getHp() + ".png");
                } else if (gameState == 5) {
                    playMinion(5, 3, hand[4].getMechanic(), "images/" + hand[4].getName() + "_" + hand[4].getHp() + ".png");
                } else if (gameState == 6) {
                    playMinion(6, 3, hand[5].getMechanic(), "images/" + hand[5].getName() + "_" + hand[5].getHp() + ".png");
                } else if (gameState == 7) {
                    playMinion(7, 3, hand[6].getMechanic(), "images/" + hand[6].getName() + "_" + hand[6].getHp() + ".png");
                } else if (gameState == 100) {
                    if (field[0].getState() == 2 && field[0].getExhausted() == 0) {
                        gameState = 13;
                    }
                }
            }
//            if (x > 570 && x < 648 && y > 500 && y < 633) { //space 4
            if (x >= 573 && x <= 660 && y >= 465 && y <= 600) { //space 4
                System.out.println("Space 4");
                if (mouseRead == true) {
                    clickPos = 14;
                }
                 if (gameState == 1) {
                    playMinion(1, 4, hand[0].getMechanic(), "images/" + hand[0].getName() + "_" + hand[0].getHp() + ".png");
                } else if (gameState == 2) {
                    playMinion(2, 4, hand[1].getMechanic(), "images/" + hand[1].getName() + "_" + hand[1].getHp() + ".png");
                } else if (gameState == 3) {
                    playMinion(3, 4, hand[2].getMechanic(), "images/" + hand[2].getName() + "_" + hand[2].getHp() + ".png");
                } else if (gameState == 4) {
                    playMinion(4, 4, hand[3].getMechanic(), "images/" + hand[3].getName() + "_" + hand[3].getHp() + ".png");
                } else if (gameState == 5) {
                    playMinion(5, 4, hand[4].getMechanic(), "images/" + hand[4].getName() + "_" + hand[4].getHp() + ".png");
                } else if (gameState == 6) {
                    playMinion(6, 4, hand[5].getMechanic(), "images/" + hand[5].getName() + "_" + hand[5].getHp() + ".png");
                } else if (gameState == 7) {
                    playMinion(7, 4, hand[6].getMechanic(), "images/" + hand[6].getName() + "_" + hand[6].getHp() + ".png");
                } else if (gameState == 100) {
                    if (field[0].getState() == 2 && field[0].getExhausted() == 0) {
                        gameState = 14;
                    }
                }
            }

//            if (x > 658 && x < 736 && y > 500 && y < 633) { //space 5
            if (x > 693 && x < 779 && y > 465 && y < 600) { //space 5
                System.out.println("Space 5");
                if (mouseRead == true) {
                    clickPos = 15;
                }
                 if (gameState == 1) {
                    playMinion(1, 5, hand[0].getMechanic(), "images/" + hand[0].getName() + "_" + hand[0].getHp() + ".png");
                } else if (gameState == 2) {
                    playMinion(2, 5, hand[1].getMechanic(), "images/" + hand[1].getName() + "_" + hand[1].getHp() + ".png");
                } else if (gameState == 3) {
                    playMinion(3, 5, hand[2].getMechanic(), "images/" + hand[2].getName() + "_" + hand[2].getHp() + ".png");
                } else if (gameState == 4) {
                    playMinion(4, 5, hand[3].getMechanic(), "images/" + hand[3].getName() + "_" + hand[3].getHp() + ".png");
                } else if (gameState == 5) {
                    playMinion(5, 5, hand[4].getMechanic(), "images/" + hand[4].getName() + "_" + hand[4].getHp() + ".png");
                } else if (gameState == 6) {
                    playMinion(6, 5, hand[5].getMechanic(), "images/" + hand[5].getName() + "_" + hand[5].getHp() + ".png");
                } else if (gameState == 7) {
                    playMinion(7, 5, hand[6].getMechanic(), "images/" + hand[6].getName() + "_" + hand[6].getHp() + ".png");
                } else if (gameState == 100) {
                    if (field[0].getState() == 2 && field[0].getExhausted() == 0) {
                        gameState = 15;
                    }
                }
            }

//            if (x > 746 && x < 824 && y > 500 && y < 633) { //space 6
            if (x > 812 && x < 899 && y > 465 && y < 600) { //space 6
                System.out.println("Space 6");
                if (mouseRead == true) {
                    clickPos = 16;
                }
                 if (gameState == 1) {
                    playMinion(1, 6, hand[0].getMechanic(), "images/" + hand[0].getName() + "_" + hand[0].getHp() + ".png");
                } else if (gameState == 2) {
                    playMinion(2, 6, hand[1].getMechanic(), "images/" + hand[1].getName() + "_" + hand[1].getHp() + ".png");
                } else if (gameState == 3) {
                    playMinion(3, 6, hand[2].getMechanic(), "images/" + hand[2].getName() + "_" + hand[2].getHp() + ".png");
                } else if (gameState == 4) {
                    playMinion(4, 6, hand[3].getMechanic(), "images/" + hand[3].getName() + "_" + hand[3].getHp() + ".png");
                } else if (gameState == 5) {
                    playMinion(5, 6, hand[4].getMechanic(), "images/" + hand[4].getName() + "_" + hand[4].getHp() + ".png");
                } else if (gameState == 6) {
                    playMinion(6, 6, hand[5].getMechanic(), "images/" + hand[5].getName() + "_" + hand[5].getHp() + ".png");
                } else if (gameState == 7) {
                    playMinion(7, 6, hand[6].getMechanic(), "images/" + hand[6].getName() + "_" + hand[6].getHp() + ".png");
                } else if (gameState == 100) {
                    if (field[0].getState() == 2 && field[0].getExhausted() == 0) {
                        gameState = 16;
                    }
                }
            }
            
//            if (x > 834 && x < 912 && y > 500 && y < 633) { //space 7
            if (x > 931 && x < 1017 && y > 465 && y < 600) { //space 7
                System.out.println("Space 7");
                if (mouseRead == true) {
                    clickPos = 17;
                }
                 if (gameState == 1) {
                    playMinion(1, 7, hand[0].getMechanic(), "images/" + hand[0].getName() + "_" + hand[0].getHp() + ".png");
                } else if (gameState == 2) {
                    playMinion(2, 7, hand[1].getMechanic(), "images/" + hand[1].getName() + "_" + hand[1].getHp() + ".png");
                } else if (gameState == 3) {
                    playMinion(3, 7, hand[2].getMechanic(), "images/" + hand[2].getName() + "_" + hand[2].getHp() + ".png");
                } else if (gameState == 4) {
                    playMinion(4, 7, hand[3].getMechanic(), "images/" + hand[3].getName() + "_" + hand[3].getHp() + ".png");
                } else if (gameState == 5) {
                    playMinion(5, 7, hand[4].getMechanic(), "images/" + hand[4].getName() + "_" + hand[4].getHp() + ".png");
                } else if (gameState == 6) {
                    playMinion(6, 7, hand[5].getMechanic(), "images/" + hand[5].getName() + "_" + hand[5].getHp() + ".png");
                } else if (gameState == 7) {
                    playMinion(7, 7, hand[6].getMechanic(), "images/" + hand[6].getName() + "_" + hand[6].getHp() + ".png");
                } else if (gameState == 100) {
                    if (field[0].getState() == 2 && field[0].getExhausted() == 0) {
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

                //User Cards from left to right
 
                //player deck 
                if (x > 1 && x < 78 && y > 720 && y < 853) {
                }
  
                if(x>135 && x<213 && y>720 && y<853){
                    cards.setBounds(500,225,233,359);  
                    cards.setIcon(getImageIcon(new File("images/" + hand[0].getName() + "_" + hand[0].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards.setBounds(135,685,78,120);
                    cards.setIcon(getImageIcon(new File("images/" + hand[0].getName() + "_" + hand[0].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 223 && x < 301 && y > 720 && y < 853) { //hand 2
                    cards1.setBounds(500,225,233,359);  
                    cards1.setIcon(getImageIcon(new File("images/" + hand[1].getName() + "_" + hand[1].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards1.setBounds(223,685,78,120);
                    cards1.setIcon(getImageIcon(new File("images/" + hand[1].getName() + "_" + hand[1].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 311 && x < 389 && y > 720 && y < 853) { //hand 3
                    cards2.setBounds(500,225,233,359);  
                    cards2.setIcon(getImageIcon(new File("images/" + hand[2].getName() + "_" + hand[2].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards2.setBounds(311,685,78,120);
                    cards2.setIcon(getImageIcon(new File("images/" + hand[2].getName() + "_" + hand[2].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 399 && x < 477 && y > 720 && y < 853) { //hand 4
                    cards3.setBounds(500,225,233,359);  
                    cards3.setIcon(getImageIcon(new File("images/" + hand[3].getName() + "_" + hand[3].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards3.setBounds(399,685,78,120);
                    cards3.setIcon(getImageIcon(new File("images/" + hand[3].getName() + "_" + hand[3].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 487 && x < 565 && y > 720 && y < 853) { //hand 5
                    cards4.setBounds(500,225,233,359);  
                    cards4.setIcon(getImageIcon(new File("images/" + hand[4].getName() + "_" + hand[4].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards4.setBounds(487,685,78,120);
                    cards4.setIcon(getImageIcon(new File("images/" + hand[4].getName() + "_" + hand[4].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 575 && x < 653 && y > 720 && y < 853) { //hand 6
                    cards5.setBounds(500,225,233,359);  
                    cards5.setIcon(getImageIcon(new File("images/" + hand[5].getName() + "_" + hand[5].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards5.setBounds(575,685,78,120);
                    cards5.setIcon(getImageIcon(new File("images/" + hand[5].getName() + "_" + hand[5].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 663 && x < 741 && y > 720 && y < 853) { //hand 7
                    cards6.setBounds(500,225,233,359);  
                    cards6.setIcon(getImageIcon(new File("images/" + hand[6].getName() + "_" + hand[6].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards6.setBounds(663,685,78,120);
                    cards6.setIcon(getImageIcon(new File("images/" + hand[6].getName() + "_" + hand[6].getHp() + ".png")));
                    gameState = 100;
                }
            
                
                //Enemy Hand from Left to Right
                //enemy deck
                if (x > 1 && x < 78 && y > 0 && y < 180) 
                {
                }


                //enemy card 1
                if (x > 135 && x < 213 && y > 0 && y < 180) 
                {
                    cards7.setBounds(500,225,233,359);  
                    cards7.setIcon(getImageIcon(new File("images/" + eHand[0].getName() + "_" + eHand[0].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards7.setBounds(135,5,78,120);
                    cards7.setIcon(getImageIcon(new File("images/" + eHand[0].getName() + "_" + eHand[0].getHp() + ".png")));
                    gameState = 100;
                }

                //enemy card 2
                if (x > 223 && x < 301 && y > 0 && y < 180) 
                {
                    cards8.setBounds(500,225,233,359);  
                    cards8.setIcon(getImageIcon(new File("images/" + eHand[1].getName() + "_" + eHand[1].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards8.setBounds(223,5,78,120);
                    cards8.setIcon(getImageIcon(new File("images/" + eHand[1].getName() + "_" + eHand[1].getHp() + ".png")));
                    gameState = 100;
                }

                //enemy card 3
                if (x > 311 && x < 389 && y > 0 && y < 180) 
                {
                    cards9.setBounds(500,225,233,359);  
                    cards9.setIcon(getImageIcon(new File("images/" + eHand[2].getName() + "_" + eHand[2].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards9.setBounds(311,5,78,120);
                    cards9.setIcon(getImageIcon(new File("images/" + eHand[2].getName() + "_" + eHand[2].getHp() + ".png")));
                    gameState = 100;
                }

                //enemy card 4
                if (x > 399 && x < 477 && y > 0 && y < 180) 
                {
                    cards10.setBounds(500,225,233,359);  
                    cards10.setIcon(getImageIcon(new File("images/" + eHand[3].getName() + "_" + eHand[3].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards10.setBounds(399,5,78,120);
                    cards10.setIcon(getImageIcon(new File("images/" + eHand[3].getName() + "_" + eHand[3].getHp() + ".png")));
                    gameState = 100;
                }
            
                //enemy card 5
                if (x > 487 && x < 565 && y > 0 && y < 180) 
                {
                    cards11.setBounds(500,225,233,359);  
                    cards11.setIcon(getImageIcon(new File("images/" + eHand[4].getName() + "_" + eHand[4].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards11.setBounds(487,5,78,120);
                    cards11.setIcon(getImageIcon(new File("images/" + eHand[4].getName() + "_" + eHand[4].getHp() + ".png")));
                    gameState = 100;
                }

                //enemy card 6                
                if (x > 575 && x < 653 && y > 0 && y < 180) 
                {
                    cards12.setBounds(500,225,233,359);  
                    cards12.setIcon(getImageIcon(new File("images/" + eHand[5].getName() + "_" + eHand[5].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards12.setBounds(575,5,78,120);
                    cards12.setIcon(getImageIcon(new File("images/" + eHand[5].getName() + "_" + eHand[5].getHp() + ".png")));
                    gameState = 100;
                }

                //enemy card 7
                if (x > 663 && x < 741 && y > 0 && y < 180) 
                {
                    cards13.setBounds(500,225,233,359);  
                    cards13.setIcon(getImageIcon(new File("images/" + eHand[6].getName() + "_" + eHand[6].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards13.setBounds(663,5,78,120);
                    cards13.setIcon(getImageIcon(new File("images/" + eHand[6].getName() + "_" + eHand[6].getHp() + ".png")));
                    gameState = 100;
                }

                
                //User Playables from left to right
                if (x > 215 && x < 300 && y > 465 && y < 600) { //space 1
                    cards14.setBounds(500,225,233,359);  
                    cards14.setIcon(getImageIcon(new File("images/" + field[0].getName() + "_" + field[0].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards14.setBounds(215,470,78,120);
                    cards14.setIcon(getImageIcon(new File("images/" + field[0].getName() + "_" + field[0].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 335 && x < 420 && y > 465 && y < 600) { //space 2
                    cards15.setBounds(500,225,233,359);  
                    cards15.setIcon(getImageIcon(new File("images/" + field[1].getName() + "_" + field[1].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards15.setBounds(335,470,78,120);
                    cards15.setIcon(getImageIcon(new File("images/" + field[1].getName() + "_" + field[1].getHp() + ".png")));
                    gameState = 100;
                }

                if (x >= 455 && x <= 540 && y >= 465 && y <= 600) { //space 3
                    cards16.setBounds(500,225,233,359);  
                    cards16.setIcon(getImageIcon(new File("images/" + field[2].getName() + "_" + field[2].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards16.setBounds(455,470,78,120);
                    cards16.setIcon(getImageIcon(new File("images/" + field[2].getName() + "_" + field[2].getHp() + ".png")));
                    gameState = 100;
                }

                if (x >= 573 && x <= 660 && y >= 465 && y <= 600) { //space 4
                    cards17.setBounds(500,225,233,359);  
                    cards17.setIcon(getImageIcon(new File("images/" + field[3].getName() + "_" + field[3].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards17.setBounds(573,470,78,120);
                    cards17.setIcon(getImageIcon(new File("images/" + field[3].getName() + "_" + field[3].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 693 && x < 779 && y > 465 && y < 600) { //space 5
                    cards18.setBounds(500,225,233,359);  
                    cards18.setIcon(getImageIcon(new File("images/" + field[4].getName() + "_" + field[4].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards18.setBounds(693,470,78,120);
                    cards18.setIcon(getImageIcon(new File("images/" + field[4].getName() + "_" + field[4].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 812 && x < 899 && y > 465 && y < 600) { //space 6
                    cards19.setBounds(500,225,233,359);  
                    cards19.setIcon(getImageIcon(new File("images/" + field[5].getName() + "_" + field[5].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards19.setBounds(812,470,78,120);
                    cards19.setIcon(getImageIcon(new File("images/" + field[5].getName() + "_" + field[5].getHp() + ".png")));
                    gameState = 100;
                }

                if (x > 931 && x < 1017 && y > 465 && y < 600) { //space 7
                    cards20.setBounds(500,225,233,359);  
                    cards20.setIcon(getImageIcon(new File("images/" + field[6].getName() + "_" + field[6].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards20.setBounds(931,470,78,120);
                    cards20.setIcon(getImageIcon(new File("images/" + field[6].getName() + "_" + field[6].getHp() + ".png")));
                    gameState = 100;
                }
                
            //Enemy Playble from left to right
            
                if (x > 306 && x < 384 && y > 280 && y < 413) {
                    cards21.setBounds(500,225,233,359);  
                    cards21.setIcon(getImageIcon(new File("images/" + eField[0].getName() + "_" + eField[0].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards21.setBounds(306,230,78,120);
                    cards21.setIcon(getImageIcon(new File("images/" + eField[0].getName() + "_" + eField[0].getHp() + ".png")));
                    gameState = 100;
                }
                
                if (x > 394 && x < 472 && y > 280 && y < 413) {
                    cards22.setBounds(500,225,233,359);  
                    cards22.setIcon(getImageIcon(new File("images/" + eField[1].getName() + "_" + eField[1].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards22.setBounds(394,230,78,120);
                    cards22.setIcon(getImageIcon(new File("images/" + eField[1].getName() + "_" + eField[1].getHp() + ".png")));
                    gameState = 100;
                }
                
                if (x > 482 && x < 560 && y > 280 && y < 413) {
                    cards23.setBounds(500,225,233,359);  
                    cards23.setIcon(getImageIcon(new File("images/" + eField[2].getName() + "_" + eField[2].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards23.setBounds(482,230,78,120);
                    cards23.setIcon(getImageIcon(new File("images/" + eField[2].getName() + "_" + eField[2].getHp() + ".png")));
                    gameState = 100;
                }
                
                if (x > 570 && x < 648 && y > 280 && y < 413) {
                    cards24.setBounds(500,225,233,359);  
                    cards24.setIcon(getImageIcon(new File("images/" + eField[3].getName() + "_" + eField[3].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards24.setBounds(570,230,78,120);
                    cards24.setIcon(getImageIcon(new File("images/" + eField[3].getName() + "_" + eField[3].getHp() + ".png")));
                    gameState = 100;
                }
                
                if (x > 658 && x < 736 && y > 280 && y < 413) {
                    cards25.setBounds(500,225,233,359);  
                    cards25.setIcon(getImageIcon(new File("images/" + eField[4].getName() + "_" + eField[4].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards25.setBounds(658,230,78,120);
                    cards25.setIcon(getImageIcon(new File("images/" + eField[4].getName() + "_" + eField[4].getHp() + ".png")));
                    gameState = 100;
                }
                
                if (x > 746 && x < 824 && y > 280 && y < 413) {
                    cards26.setBounds(500,225,233,359);  
                    cards26.setIcon(getImageIcon(new File("images/" + eField[5].getName() + "_" + eField[5].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards26.setBounds(746,230,78,120);
                    cards26.setIcon(getImageIcon(new File("images/" + eField[5].getName() + "_" + eField[5].getHp() + ".png")));
                    gameState = 100;
                }
                
                if (x > 834 && x < 912 && y > 280 && y < 413) {
                    cards27.setBounds(500,225,233,359);  
                    cards27.setIcon(getImageIcon(new File("images/" + eField[6].getName() + "_" + eField[6].getHp() + "_big.png")));
                    gameState = 100;
                }
                else
                {
                    cards27.setBounds(834,230,78,120);
                    cards27.setIcon(getImageIcon(new File("images/" + eField[6].getName() + "_" + eField[6].getHp() + ".png")));
                    gameState = 100;
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
