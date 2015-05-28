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

    private int LocatieVeldX, LocatieVeldY;
    private Image SpelerPlaatje;
    private Veld veld = new Veld();

    ImageIcon imgNormal = new ImageIcon("C:\\Maze\\bird2.png");
    ImageIcon imgLeft = new ImageIcon("C:\\Maze\\bird2Left.png");
    ImageIcon imgRight = new ImageIcon("C:\\Maze\\bird2Right.png");
    ImageIcon imgUp = new ImageIcon("C:\\Maze\\bird2Up.png");

    //private Image img = new ImageIcon("../bird.png").getImage();
    public Speler() {

        SpelerPlaatje = imgNormal.getImage();

        LocatieVeldX = Veld.VELDBREEDTE;
        LocatieVeldY = Veld.VELDHOOGTE;

    }

    @Override
    public Image getPlaatjeGameObject() {
        return SpelerPlaatje;
    }

    public void move(int paramVeldX, int paramVeldY) {

        LocatieVeldX = LocatieVeldX + paramVeldX * Veld.VELDBREEDTE;
        LocatieVeldY = LocatieVeldY + paramVeldY * Veld.VELDHOOGTE;

        //Move test
        //System.out.println("MovingX " + veldX + "MovingY " + veldY);
    }

    public int getVeldX() {
        return LocatieVeldX;
    }

    public int getVeldY() {
        return LocatieVeldY;
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
                if (!veld.checkIfBlocked(getVeldX(), getVeldY() - Veld.VELDHOOGTE)) {
                    move(0, -1);
                    changeImage("imgUp");
                    break;
                } else {
                    break;
                }
            case "down":
                if (!veld.checkIfBlocked(getVeldX(), getVeldY() + Veld.VELDHOOGTE)) {
                    move(0, 1);
                    changeImage("imgDown");
                    break;
                } else {
                    break;
                }
            case "left":
                if (!veld.checkIfBlocked(getVeldX() - Veld.VELDBREEDTE, getVeldY())) {
                    move(-1, 0);
                    changeImage("imgLeft");
                    break;
                } else {
                    break;
                }
            case "right":
                if (!veld.checkIfBlocked(getVeldX() + Veld.VELDBREEDTE, getVeldY())) {
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
                SpelerPlaatje = imgNormal.getImage();
                break;
        }
    }
}
