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

    public static final int VELDHOOGTE = 32;
    public static final int VELDBREEDTE = 32;
    public int veldX;
    public int veldY;
    public boolean loopbaar;
    public final Image plaatje;

    public Veld() {
        ImageIcon img = new ImageIcon("C:\\Maze\\plaatje.jpg");
        plaatje = img.getImage();

    }

    public Boolean checkIfBlocked(int x, int y) {
        try {
            LevelMaker levelmaker = new LevelMaker();
            int yLocation = y / VELDHOOGTE;
            int xLocation = x / VELDBREEDTE;

            if (levelmaker.ArrayStringMap[yLocation][xLocation].equals("m")) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error checkIfBlocked: " + e);
        }
        return false;
    }

    public Image getPlaatjeVeld() {
        return plaatje;
    }

}
