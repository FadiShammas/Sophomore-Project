package langwars;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Board {

    public static void main(String[] args) {
        new Board();
    }

    public Board() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    // Load the background image
                    Image img = ImageIO.read(getClass().getResource("Resources\\Images\\Board\\board.png"));

                    // Create the frame...
                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    // Set the frames content pane to use a JLabel
                    // whose icon property has been set to use the image
                    // we just loaded                        
                    frame.setContentPane(new JLabel(new ImageIcon(img)));

                    // Supply a layout manager for the body of the content
                    frame.setLayout(null);
                    // Add stuff...
                    JButton addButton = new JButton("End Turn");
                    addButton.addMouseListener(new MouseHandler());
                    addButton.setBounds(100,700,150,50);
                    frame.add(addButton);

                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setSize(1200, 800);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }
    
    public class MouseHandler extends MouseAdapter{
        
        public void mouseEntered(MouseEvent e){
            
            
        }
    }
}