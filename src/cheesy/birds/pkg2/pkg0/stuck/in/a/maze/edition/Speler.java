/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition;

import static cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition.Veld.VELDGROOTTE;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author HICT
 */
public class Speler extends GameObject {

    private Image SpelerPlaatje;
    private Veld veld = new Veld();

    ImageIcon imgNormal = new ImageIcon("C:\\Maze\\bird2.png");
    ImageIcon imgLeft = new ImageIcon("C:\\Maze\\bird2Left.png");
    ImageIcon imgRight = new ImageIcon("C:\\Maze\\bird2Right.png");
    ImageIcon imgUp = new ImageIcon("C:\\Maze\\bird2Up.png");

    public Speler() {

        SpelerPlaatje = imgNormal.getImage();

        LocatieVeldX = 1;
        LocatieVeldY = 1;

    }

    @Override
    public Image getPlaatjeGameObject() {
        return SpelerPlaatje;
    }

    public void move(int paramVeldX, int paramVeldY) {  //private maken

        LocatieVeldX = LocatieVeldX + paramVeldX;
        LocatieVeldY = LocatieVeldY + paramVeldY;
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
                if (!veld.checkIfBlocked(getVeldX(), getVeldY() - 1)) {
                    if (isAtEnd("up")) {
                        endMessage();
                    }
                    move(0, -1);
                    changeImage("imgUp");
                    break;
                } else {
                    break;
                }
            case "down":
                if (!veld.checkIfBlocked(getVeldX(), getVeldY() + 1)) {
                    if (isAtEnd("down")) {
                        endMessage();
                    }
                    move(0, 1);
                    changeImage("imgDown");
                    break;
                } else {
                    break;
                }
            case "left":
                if (!veld.checkIfBlocked(getVeldX() - 1, getVeldY())) {
                    if (isAtEnd("left")) {
                        endMessage();
                    }
                    move(-1, 0);
                    changeImage("imgLeft");
                    break;
                } else {
                    break;
                }
            case "right":
                if (!veld.checkIfBlocked(getVeldX() + 1, getVeldY())) {
                    if (isAtEnd("right")) {
                        endMessage();
                    }
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

    public boolean isAtEnd(String direction) {
        Vriend VriendTemp = new Vriend();

        switch (direction) {
            case "up":
                return this.LocatieVeldX == VriendTemp.LocatieVeldX && (this.LocatieVeldY - 1) == VriendTemp.LocatieVeldY;
            case "down":
                return this.LocatieVeldX == VriendTemp.LocatieVeldX && (this.LocatieVeldY + 1) == VriendTemp.LocatieVeldY;
            case "left":
                return this.LocatieVeldX == (VriendTemp.LocatieVeldX - 1)&& this.LocatieVeldY == VriendTemp.LocatieVeldY;
            case "right":
                return this.LocatieVeldX == (VriendTemp.LocatieVeldX + 1) && this.LocatieVeldY == VriendTemp.LocatieVeldY;
        }
        return false;
    }
    
    public void endMessage(){
        JOptionPane.showMessageDialog(null, "Het einde is bereikt");
    }
}
