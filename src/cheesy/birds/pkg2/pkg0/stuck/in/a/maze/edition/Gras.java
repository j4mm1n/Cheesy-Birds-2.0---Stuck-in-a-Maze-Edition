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
public class Gras extends Veld {

    private final Image gras;

    public Gras() {
       //inladen van het gras. 
        ImageIcon img = new ImageIcon("C:\\Maze\\grass.png");
        //ImageIcon img = new ImageIcon("Images/grass.png");
        gras = img.getImage();

    }

    @Override
    public Image getPlaatjeVeld(){
        return gras;
    }

}
