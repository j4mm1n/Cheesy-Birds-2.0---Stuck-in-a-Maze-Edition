/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import static sun.org.mozilla.javascript.internal.ScriptRuntime.instanceOf;

/**
 *
 * @author HICT
 */
class LevelMaker extends JPanel implements ActionListener {

    private Timer timer;
    private Veld veld;
    private Speler speler;
    //private Muur muur = new Muur();
    //private Gras gras = new Gras();
    private int muurCounter = 0;
    private int grasCounter = 0;
    
    /*
    public Veld[][] map = {
        {muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur,},
        {muur, gras, gras, gras, gras, gras, gras, gras, gras, gras, gras, gras, gras, gras, muur,},
        {muur, gras, muur, muur, muur, muur, muur, muur, muur, muur, muur, gras, muur, muur, muur,},
        {muur, gras, muur, gras, gras, gras, gras, gras, gras, gras, gras, gras, muur, gras, muur,},
        {muur, gras, muur, gras, muur, muur, muur, muur, muur, muur, muur, gras, muur, gras, muur,},
        {muur, gras, muur, gras, muur, gras, gras, gras, muur, gras, muur, gras, gras, gras, muur,},
        {muur, gras, muur, gras, muur, gras, gras, gras, muur, gras, muur, gras, muur, gras, muur,},
        {muur, gras, muur, gras, muur, gras, gras, gras, muur, gras, gras, gras, muur, gras, muur,},
        {muur, gras, muur, gras, muur, gras, gras, gras, muur, muur, muur, gras, muur, gras, muur,},
        {muur, gras, gras, gras, muur, gras, gras, gras, gras, gras, gras, gras, muur, gras, muur,},
        {muur, gras, muur, gras, muur, gras, gras, gras, gras, gras, gras, gras, muur, gras, muur,},
        {muur, gras, muur, gras, muur, gras, gras, gras, gras, gras, gras, gras, muur, gras, muur,},
        {muur, gras, muur, gras, muur, muur, muur, muur, muur, muur, muur, muur, muur, gras, muur,},
        {muur, gras, muur, gras, gras, gras, gras, gras, gras, gras, gras, gras, gras, gras, muur,},
        {muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur, muur,}};
    */
    
    public String[][] ArrayStringMap = {
        {"m","m","m","m","m","m","m","m","m","m","m","m","m","m","m",},
        {"m","g","g","g","g","g","g","g","g","g","g","g","g","g","m",},
        {"m","g","m","m","m","m","m","m","m","m","m","m","m","g","m",},
        {"m","g","m","m","m","m","m","m","m","m","m","m","m","g","m",},
        {"m","g","g","g","g","g","g","g","g","g","g","g","g","g","m",},
        {"m","g","m","m","m","m","m","m","m","m","m","m","m","g","m",},
        {"m","g","m","m","m","m","m","m","m","m","m","m","m","g","m",},
        {"m","g","g","g","g","g","g","g","g","g","g","g","g","g","m",},
        {"m","g","m","m","m","m","m","m","m","m","m","m","m","g","m",},
        {"m","g","m","m","m","m","m","m","m","m","m","m","m","g","m",},
        {"m","g","m","m","m","m","m","m","m","m","m","m","m","g","m",},
        {"m","g","m","m","m","m","m","m","m","m","m","m","m","g","m",},
        {"m","g","m","m","m","m","m","m","m","m","m","m","m","g","m",},
        {"m","g","g","g","g","g","g","g","g","g","g","g","g","g","m",},
        {"m","m","m","m","m","m","m","m","m","m","m","m","m","m","m",}};
    

    public LevelMaker() {
        veld = new Veld();
        speler = new Speler();
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

        //Inlezen vanuit de 2dArray met objecten.
        /*
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                if (map[y][x].equals(muur)) {
                    g.drawImage(muur.getPlaatjeVeld(), x * VELDGROOTTE, y * VELDGROOTTE, null);
                }
                if (map[y][x].equals(gras)) {
                    g.drawImage(gras.getPlaatjeVeld(), x * VELDGROOTTE, y * VELDGROOTTE, null);
                }
            }

        }
        */
        
        
        //Deze loop gebruiken bij het inlezen vanuit een String[][].
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                if(ArrayStringMap[y][x].equals("m")) {
                    muurCounter++;
                    Muur muurCounter = new Muur();
                    //Muur.naam = "muur" + muurCounter;
                    muurCounter.veldX = x;
                    muurCounter.veldY = y;
                    g.drawImage(muurCounter.getPlaatjeVeld(), x * muurCounter.VELDBREEDTE, y * muurCounter.VELDHOOGTE, null);
                    System.out.println("Muurnaam loopX : " + x + "loopY" + y);
                }
                if(ArrayStringMap[y][x].equals("g")) {
                    grasCounter++;
                    Gras grasCounter = new Gras();
                    //Gras.naam = "gras" + grasCounter;
                    grasCounter.veldX = x;
                    grasCounter.veldY = y;
                    g.drawImage(grasCounter.getPlaatjeVeld(), x * grasCounter.VELDBREEDTE, y * grasCounter.VELDBREEDTE, null);
                    System.out.println("Grascounter: " + x + "loopY" + y);
                }
            }
            muurCounter = 0;
            grasCounter = 0;
        }

        //Deze loop gebruiken bij het inlezen van map uit een .txt bestand.
        /*
         for (int y = 0; y < 15; y++) {        
         for (int x = 0; x < 15; x++) {
         if (M.getVeld(x, y).equals("W")) {
         g.drawImage(M.getWall(), x * 32, y * 32, null);
         }
         if (M.getVeld(x, y).equals("G")) {
         g.drawImage(M.getGras(), x * 32, y * 32, null);
         }

         }
         }
         */
        
        
        //Draw speler
        g.drawImage(speler.getPlaatjeGameObject(), speler.getVeldX(), speler.getVeldY(), null);
    }

    public class ActionListener extends KeyAdapter {

        //Beweging voor de speler
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
