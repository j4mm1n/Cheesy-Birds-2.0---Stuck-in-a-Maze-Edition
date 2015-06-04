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
    private Vriend vriend;
    private Helper helper;
    private Muur muur;
    private Gras gras;
    private int muurCounter = 0;
    private int grasCounter = 0;

    public String[][] ArrayStringMap = {
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m",},
        {"m", "g", "m", "g", "g", "g", "g", "m", "g", "g", "g", "g", "m", "g", "m",},
        {"m", "g", "m", "m", "g", "m", "g", "m", "m", "g", "m", "g", "m", "g", "m",},
        {"m", "g", "m", "m", "g", "m", "g", "m", "m", "g", "m", "g", "g", "g", "m",},
        {"m", "g", "g", "g", "g", "m", "g", "g", "g", "g", "g", "g", "g", "g", "m",},
        {"m", "g", "m", "m", "g", "m", "g", "m", "m", "m", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "m", "g", "m", "g", "m", "m", "m", "m", "m", "m", "g", "m",},
        {"m", "g", "g", "g", "g", "g", "g", "g", "m", "g", "g", "g", "g", "g", "m",},
        {"m", "g", "m", "m", "m", "m", "g", "m", "m", "g", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "g", "m", "m", "g", "m", "m", "g", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "g", "g", "g", "g", "m", "m", "g", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "g", "m", "m", "m", "m", "m", "g", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "g", "m", "m", "m", "m", "m", "g", "m", "m", "m", "g", "m",},
        {"m", "g", "m", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "m",},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "v", "m",}};

    public Veld[][] ArrayVeldMap = new Veld[15][15];

    public LevelMaker() {
        //veld = new Veld();            //oud
        maakMuurEnGras();
        speler = new Speler();
        vriend = new Vriend();
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
                Veld tempVeld = ArrayVeldMap[y][x];
                g.drawImage(tempVeld.getPlaatjeVeld(), x * Veld.VELDGROOTTE, y * Veld.VELDGROOTTE, null);
            }
        }
        
        //Draw helper               fout als hij helper wil tekenen ?
        g.drawImage(helper.getPlaatjeGameObject(), 64, 64, null);
    

        //Draw vriend
        g.drawImage(vriend.getPlaatjeGameObject(), vriend.getVeldX()* Veld.VELDGROOTTE, vriend.getVeldY()* Veld.VELDGROOTTE, null);

        //Draw speler
        int x = speler.getVeldX();
        int y = speler.getVeldY();
        g.drawImage(speler.getPlaatjeGameObject(), speler.getVeldX() * Veld.VELDGROOTTE, speler.getVeldY() * Veld.VELDGROOTTE, null);
        
        }

    private void maakMuurEnGras() {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (ArrayStringMap[x][y].equals("m")) {     //muur
                    muurCounter++;
                    Muur muurNaamCounter = new Muur();
                    muurNaamCounter.veldX = x;
                    muurNaamCounter.veldY = y;
                    ArrayVeldMap[x][y] = muurNaamCounter;
                }
                if (ArrayStringMap[x][y].equals("g")) {     //gras
                    grasCounter++;
                    Gras grasNaamCounter = new Gras();
                    grasNaamCounter.veldX = x;
                    grasNaamCounter.veldY = y;
                    ArrayVeldMap[x][y] = grasNaamCounter;
                }
                 if (ArrayStringMap[x][y].equals("v")) {     //gras + vriend
                    grasCounter++;
                    Gras grasNaamCounter = new Gras();
                    grasNaamCounter.veldX = x;
                    grasNaamCounter.veldY = y;
                    grasNaamCounter.bevatItem = "vriend";
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
