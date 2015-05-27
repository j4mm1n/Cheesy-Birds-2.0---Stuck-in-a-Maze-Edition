/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author HICT
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
        JFrame f = new JFrame();
        //JPanel PanelMenu = new JPanel();
        JPanel PanelMaze = new JPanel();
        
       //PanelMenu.setLayout(new FlowLayout (FlowLayout.CENTER,0,0));
       PanelMaze.setLayout(new FlowLayout (FlowLayout.RIGHT,0,0)); 
       
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
        f.setSize(550,550 );
        f.setLocationRelativeTo(null);
        
        f.add(new LevelMaker());
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
