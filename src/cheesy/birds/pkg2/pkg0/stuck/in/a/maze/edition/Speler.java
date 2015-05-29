/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition;

import static cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition.Veld.VELDGROOTTE;
import java.awt.*;
import javax.swing.ImageIcon;

/**
 *
 * @author HICT
 */
public class Speler extends GameObject {

    private Image SpelerPlaatje;
    private Veld veld;

    ImageIcon imgNormal = new ImageIcon("C:\\Maze\\bird2.png");
    ImageIcon imgLeft = new ImageIcon("C:\\Maze\\bird2Left.png");
    ImageIcon imgRight = new ImageIcon("C:\\Maze\\bird2Right.png");
    ImageIcon imgUp = new ImageIcon("C:\\Maze\\bird2Up.png");

    public Speler() {

        SpelerPlaatje = imgNormal.getImage();

        LocatieVeldX = Veld.VELDGROOTTE;
        LocatieVeldY = Veld.VELDGROOTTE;

    }

    @Override
    public Image getPlaatjeGameObject() {
        return SpelerPlaatje;
    }

    public void move(int paramVeldX, int paramVeldY) {  //private maken

        LocatieVeldX = LocatieVeldX + paramVeldX * Veld.VELDGROOTTE;
        LocatieVeldY = LocatieVeldY + paramVeldY * Veld.VELDGROOTTE;
    }

    public int getVeldX() {
        return LocatieVeldX;
    }

    public int getVeldY() {
        return LocatieVeldY;
    }

    public void checkAndMove(String direction) {
        switch (direction) {
            case "up":
                if (!veld.checkIfBlocked(getVeldX(), getVeldY() - Veld.VELDGROOTTE)) {
                    move(0, -1);
                    changeImage("imgUp");
                    break;
                } else {
                    break;
                }
            case "down":
                if (!veld.checkIfBlocked(getVeldX(), getVeldY() + Veld.VELDGROOTTE)) {
                    move(0, 1);
                    changeImage("imgDown");
                    break;
                } else {
                    break;
                }
            case "left":
                if (!veld.checkIfBlocked(getVeldX() - Veld.VELDGROOTTE, getVeldY())) {
                    move(-1, 0);
                    changeImage("imgLeft");
                    break;
                } else {
                    break;
                }
            case "right":
                if (!veld.checkIfBlocked(getVeldX() + Veld.VELDGROOTTE, getVeldY())) {
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
