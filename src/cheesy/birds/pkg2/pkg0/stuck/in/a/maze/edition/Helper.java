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
public class Helper extends GameObject {

    private final Image kaas;
    public boolean isKaas = true;

    public Helper() {
        ImageIcon img = new ImageIcon("C:\\Maze\\kaas.PNG");
        kaas = img.getImage();

        LocatieVeldX = 13;
        LocatieVeldY = 10;

    }

    @Override
    public Image getPlaatjeGameObject() {
        return kaas;
    }

}
