/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition;

import java.awt.*;
import javax.swing.ImageIcon;

/**
 *
 * @author HICT
 */
public class Speler extends GameObject {

    private int veldX, veldY;
    private Image SpelerPlaatje;
    private Veld veld = new Veld();

    ImageIcon img = new ImageIcon("C:\\Maze\\bird2.png");
    ImageIcon imgLeft = new ImageIcon("C:\\Maze\\bird2Left.png");
    ImageIcon imgRight = new ImageIcon("C:\\Maze\\bird2Right.png");
    ImageIcon imgUp = new ImageIcon("C:\\Maze\\bird2Up.png");

    //private Image img = new ImageIcon("../bird.png").getImage();
    public Speler() {

        SpelerPlaatje = img.getImage();

        veldX = 32;
        veldY = 32;

    }

    public Image getSpeler() {
        return SpelerPlaatje;
    }

    public void move(int paramVeldX, int paramVeldY) {

        veldX = veldX + paramVeldX * 32;
        veldY = veldY + paramVeldY * 32;

        //Move test
        //System.out.println("MovingX " + veldX + "MovingY " + veldY);
    }

    public int getVeldX() {
        return veldX;
    }

    public int getVeldY() {
        return veldY;
    }

    public Image getSpelerRechts() {
        SpelerPlaatje = imgRight.getImage();
        return SpelerPlaatje;
    }

    public Image getSpelerLinks() {
        SpelerPlaatje = imgLeft.getImage();
        return SpelerPlaatje;
    }

    public Image getSpelerOmhoog() {
        SpelerPlaatje = imgUp.getImage();
        return SpelerPlaatje;
    }

    public void checkAndMove(String direction) {
        switch (direction) {
            case "up":
                if (!veld.checkIfBlocked(getVeldX(), getVeldY() - 32)) {
                    move(0, -1);
                    changeImage("imgUp");
                    break;
                } else {
                    break;
                }
            case "down":
                if (!veld.checkIfBlocked(getVeldX(), getVeldY() + 32)) {
                    move(0, 1);
                    changeImage("imgDown");
                    break;
                } else {
                    break;
                }
            case "left":
                if (!veld.checkIfBlocked(getVeldX() - 32, getVeldY())) {
                    move(-1, 0);
                    changeImage("imgLeft");
                    break;
                } else {
                    break;
                }
            case "right":
                if (!veld.checkIfBlocked(getVeldX() + 32, getVeldY())) {
                    move(1, 0);
                    changeImage("imgRight");
                    break;
                } else {
                    break;
                }
        }
    }

    public void changeImage(String direction) {
        switch (direction) {
            case "imgLeft":
                SpelerPlaatje = imgLeft.getImage();
                break;
            case "imgRight":
                SpelerPlaatje = imgRight.getImage();
                break;
            case "imgUp":
                SpelerPlaatje = imgUp.getImage();
                break;
            case "imgDown":
                SpelerPlaatje = img.getImage();
                break;
        }
    }
}
