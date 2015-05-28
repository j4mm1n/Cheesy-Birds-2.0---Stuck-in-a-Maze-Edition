/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheesy.birds.pkg2.pkg0.stuck.in.a.maze.edition;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author HICT
 */
public class GameObject {

    public static final int VELDHOOGTE = 32;
    public static final int VELDBREEDTE = 32;
    public final Image plaatje;
    public int LocatieVeldX, LocatieVeldY;

    public GameObject() {

        //Inladen van het default plaatje.
        ImageIcon img = new ImageIcon("C:\\Maze\\plaatje.jpg");
        plaatje = img.getImage();

    }

    public Image getPlaatjeGameObject() {
        return plaatje;
    }

    public int getVeldX() {
        return LocatieVeldX;
    }

    public int getVeldY() {
        return LocatieVeldY;
    }

}
