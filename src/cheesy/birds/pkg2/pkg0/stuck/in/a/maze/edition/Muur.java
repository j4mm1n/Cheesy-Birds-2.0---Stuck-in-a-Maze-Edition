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
 *
 *
 */
public class Muur extends Veld {

    private final Image wall;
    public String naam;
    

    public Muur() {
        //inladen van de muren.
        ImageIcon img = new ImageIcon("C:\\Maze\\wall.jpg");
        wall = img.getImage();

    }
    
    @Override
    public Image getPlaatjeVeld(){
        return wall;
    }

    
}
