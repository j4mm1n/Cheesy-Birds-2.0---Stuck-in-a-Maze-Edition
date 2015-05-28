/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition;

//import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author HICT
 */
public class Veld {

    private String[] ArrayVelden = new String[15];
    private Scanner scanner;
    public static final int VELDHOOGTE = 32;
    public static final int VELDBREEDTE = 32;
    public int veldX;
    public int veldY;
    public boolean loopbaar;
    

    public Veld() {

        //openFile();       //deze methode gebruiken bij het maken van een map uit een .txt bestand.
        //readFile();       //deze methode gebruiken bij het maken van een map uit een .txt bestand.
        //closeFile();      //deze methode gebruiken bij het maken van een map uit een .txt bestand.
    }

    public String getVeld(int x, int y) {

        //String index = ArrayVelden[y].substring(x, x + 1);
        
        LevelMaker levelmaker = new LevelMaker();
        
        String index = levelmaker.ArrayStringMap[x][y];
        return index;
    }

    public Boolean checkIfBlocked(int x, int y) {
        try {
            LevelMaker levelmaker = new LevelMaker();
            int yLocation = y / VELDHOOGTE;
            int xLocation= x / VELDBREEDTE;

            //Deze return gebruiken bij het inlezen vanuit 2dArray met Objecten.
            //return levelmaker.map[yLocation][xLocation] instanceof Muur;
            
            //Deze return gebruiken bij het inlezen vanuit 2dArray met Strings.
            if(levelmaker.ArrayStringMap[yLocation][xLocation].equals("m"))
            {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error checkIfBlocked: " + e);
        }
        return false;
    }

    //Deze methode alleen gebruiken bij het inlezen van map uit een .txt bestand.
    private void openFile() {
        try {
            scanner = new Scanner(new File("C:\\Maze\\map.txt"));
        } catch (Exception E) {
            System.out.println("Error opening Map, change map location.");
        }

    }

    //Deze methode alleen gebruiken bij het inlezen van map uit een .txt bestand.
    private void readFile() {
        try {
            while (scanner.hasNext()) {
                for (int i = 0; i < 15; i++) {
                    ArrayVelden[i] = scanner.next();

                    System.out.println("Test: " + ArrayVelden[i]);
                }
            }
        } catch (Exception E) {
            System.out.println("Error reading map");
        }

    }

    //Deze methode alleen gebruiken bij het inlezen van map uit een .txt bestand.
    private void closeFile() {

    }

    public Image getPlaatjeVeld() {
        Gras g = new Gras();
        return g.getPlaatjeVeld();
    }

}
