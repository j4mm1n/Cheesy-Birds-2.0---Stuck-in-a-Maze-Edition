/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;


/**
 *
 * @author Sunny en Dennis
 */
public class CheesyBirds20StuckInAMazeEdition {

    private JPanel PanelMenu, PanelMaze;
    private JButton buttonStart, buttonReset, buttonExit;
    private JLabel labelTitle;
    private JTextArea textArea;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final JFrame introFrame = new JFrame();     //nieuwe JFrame als introscherm

        JPanel intro = new JPanel();                //de jpanel op de nieuwe jframe
        JButton startButton = new JButton("START GAME");   //startknop op de jpanel om het spel mee te starten
        Icon icon = new ImageIcon("C:\\Maze\\introscherm.png");
        JLabel introLabel = new JLabel("", icon, JLabel.CENTER);

        introFrame.add(intro);                      //hier zetten we de intro JPanel in de JFrame
        intro.add(startButton);                     //hier zetten we de startknop in de JPanel  
        intro.add(introLabel);                      //hier zetten we de JLabel met de achtergrond-plaatje op onze introscherm
        introFrame.setSize(717, 660);               //hier geven we de size van onze JFrame
        introFrame.setLocationRelativeTo(null);     // hiermee zet je de introFrame JFrame naar een centerpositie van je beeldscherm
        introFrame.setVisible(true);                //hier maken we de JFrame zichtbaar op beeld

        startButton.addActionListener(new ActionListener() {    //hier wordt de code achtger de startknop uitgevoerd
            public void actionPerformed(ActionEvent e) {
                introFrame.dispatchEvent(new WindowEvent(introFrame, WindowEvent.WINDOW_CLOSING));
                startGame();
            }
        });
    }

    public static void startGame() {
        JFrame f = new JFrame();
        //JPanel PanelMenu = new JPanel();
        JPanel PanelMaze = new JPanel();

        //PanelMenu.setLayout(new FlowLayout (FlowLayout.CENTER,0,0));
        PanelMaze.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        JButton buttonStart = new JButton("Start");
        buttonStart.setFont(new Font("Dialog", Font.BOLD, 18));
        JButton buttonReset = new JButton("Reset");
        buttonReset.setFont(new Font("Dialog", Font.BOLD, 18));
        JButton buttonExit = new JButton("Exit");
        buttonExit.setFont(new Font("Dialog", Font.BOLD, 18));

        //PanelMenu.add(buttonStart);
        //PanelMenu.add(buttonReset);
        //PanelMenu.add(buttonExit);
        //f.add(PanelMenu);
        f.add(PanelMaze);

        f.setTitle("Cheesy Birds 2.0: \"Stuck in a Maze Edition.\"");
        f.setSize(550, 550);
        f.setLocationRelativeTo(null);

        f.add(new LevelMaker());
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

 
}
