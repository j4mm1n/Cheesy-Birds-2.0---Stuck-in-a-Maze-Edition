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
public class Vriend extends GameObject {

    private final Image geit;
    public boolean vriend = true;

    public Vriend() {
        ImageIcon img = new ImageIcon("C:\\Maze\\geit.png");
        geit = img.getImage();

        LocatieVeldX = 13;
        LocatieVeldY = 11;
    }

    @Override
    public Image getPlaatjeGameObject() {
        return geit;
    }

}
