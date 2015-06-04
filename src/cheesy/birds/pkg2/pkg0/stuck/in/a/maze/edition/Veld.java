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

    public static final int VELDGROOTTE = 32;
    public int veldX;
    public int veldY;
    public boolean loopbaar;
    public String bevatItem;
    public Image plaatje;

    public Veld() {

        ImageIcon img = new ImageIcon("C:\\Maze\\plaatje.jpg");
        plaatje = img.getImage();

    }

    public Boolean checkIfBlocked(int x, int y) {
        try {
            LevelMaker levelmaker = new LevelMaker();
            int yLocation = y;
            int xLocation = x;

            if (!levelmaker.ArrayVeldMap[yLocation][xLocation].loopbaar) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error checkIfBlocked: " + e);
        }
        return false;
    }
    
    public Boolean checkIfItem(int x, int y){
        try {
            LevelMaker levelmaker = new LevelMaker();
            int yLocation = y;
            int xLocation = x;

            if (!levelmaker.ArrayVeldMap[yLocation][xLocation].bevatItem.equals("vriend")) {
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
