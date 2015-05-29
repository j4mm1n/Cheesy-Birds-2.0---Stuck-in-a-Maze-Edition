/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition;

import static cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition.Veld.VELDGROOTTE;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author HICT
 */
class LevelMaker extends JPanel implements ActionListener {

    private Veld veld;
    private Speler speler;
    private Geit geit;
    private Muur muur;
    private Gras gras;
    private int muurCounter = 0;
    private int grasCounter = 0;

    public String[][] ArrayStringMap = {
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m",},
        {"m", "g", "g", "g", "g", "g", "g", "m", "g", "g", "g", "g", "g", "g", "m",},
        {"m", "g", "m", "m", "g", "m", "m", "m", "m", "m", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "m", "g", "m", "m", "m", "m", "m", "m", "m", "m", "g", "m",},
        {"m", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "m",},
        {"m", "g", "m", "m", "g", "m", "m", "m", "m", "m", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "m", "g", "m", "m", "m", "m", "m", "m", "m", "m", "g", "m",},
        {"m", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "m",},
        {"m", "g", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "m", "m", "m", "m", "m", "m", "g", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "m", "m", "m", "m", "m", "m", "g", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "m", "m", "m", "m", "m", "m", "g", "m", "m", "m", "g", "m",},
        {"m", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "m",},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m",}};
    
    public Veld[][] ArrayVeldMap = new Veld[15][15];

    public LevelMaker() {
        //veld = new Veld();            //oud
        maakMuurEnGras();
        speler = new Speler();
        geit = new Geit();
        addKeyListener(new ActionListener());
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //Draw gras and muur.
        //Deze loop gebruiken bij het inlezen vanuit een String[][].
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                Veld tempVeld= ArrayVeldMap[x][y];
                g.drawImage(tempVeld.getPlaatjeVeld(), x * Veld.VELDGROOTTE, y * Veld.VELDGROOTTE, null);
                /*
                if (ArrayVeldMap[x][y].equals(muur)) {
                    g.drawImage(muur.getPlaatjeVeld(), x * Veld.VELDGROOTTE, y * Veld.VELDGROOTTE, null);
                }
                if (ArrayVeldMap[x][y].equals(gras)) {
                    g.drawImage(gras.getPlaatjeVeld(), x * Veld.VELDGROOTTE, y * Veld.VELDGROOTTE, null);
                }*/
            }
        }

        //Draw geit
        g.drawImage(geit.getPlaatjeGameObject(), geit.getVeldX(), geit.getVeldY(), null);

        //Draw speler
        g.drawImage(speler.getPlaatjeGameObject(), speler.getVeldX(), speler.getVeldY(), null);
    }

    private void maakMuurEnGras() {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (ArrayStringMap[x][y].equals("m")) {
                    muurCounter++;                          
                    Muur muurNaamCounter = new Muur();
                    muurNaamCounter.veldX = x;
                    muurNaamCounter.veldY = y;
                    ArrayVeldMap[x][y] = muurNaamCounter;
                    
                    //System.out.println("Veld Array: " + ArrayVeldMap[x][y]);
                    
                }
                if (ArrayStringMap[x][y].equals("g")) {
                    grasCounter++;
                    Gras grasNaamCounter = new Gras();
                    grasNaamCounter.veldX = x;
                    grasNaamCounter.veldY = y;
                    ArrayVeldMap[x][y] = grasNaamCounter;
                }
            }
            muurCounter = 0;
            grasCounter = 0;
        }

    }

    public class ActionListener extends KeyAdapter {

        //Toetsen afvangen voor beweging speler
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_W) {         //Speler beweegt omhoog.
                speler.checkAndMove("up");
                repaint();
            }

            if (keyCode == KeyEvent.VK_S) {         //Speler beweegt omlaag.
                speler.checkAndMove("down");
                repaint();
            }

            if (keyCode == KeyEvent.VK_A) {         //Speler beweegt naar links.
                speler.checkAndMove("left");
                repaint();
            }

            if (keyCode == KeyEvent.VK_D) {         //Speler beweegt naar rechts.
                speler.checkAndMove("right");
                repaint();
            }

        }

        public void keyReleased(KeyEvent e) {

        }

        public void keyTyped(KeyEvent e) {

        }

    }
}
