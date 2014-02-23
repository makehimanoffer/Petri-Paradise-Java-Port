/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pp;

import java.awt.Graphics;

/**
 *
 * @author David
 */
public abstract class Granule {
    double x,y,dx,dy;
    public  Granule(){
         x= (Math.random()*(Math.random()*1000)); y=(Math.random()*(Math.random()*350));
    }
    public abstract void paint(Graphics g);
    public abstract void collisionwithAmoeba(Amoeba a);
}
