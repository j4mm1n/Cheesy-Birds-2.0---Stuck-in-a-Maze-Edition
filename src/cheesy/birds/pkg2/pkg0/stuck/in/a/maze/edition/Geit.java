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
public class Geit extends GameObject {

    private final Image geit;

    public Geit() {
        ImageIcon img = new ImageIcon("C:\\Maze\\geit.png");
        geit = img.getImage();

        LocatieVeldX = 32;
        LocatieVeldY = 64;
    }

    @Override
    public Image getPlaatjeGameObject() {
        return geit;
    }

}
