/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pp;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class Virus implements Runnable {
double x,y,dx,dy;Thread t;Image virus;
Rectangle trackingRadius;
    public Virus(double dx,double dy, double x, double y){
        this.x=x;this.y=y;this.dx=dx;this.dy=dy;
        trackingRadius=new Rectangle((int)x+50,(int)y+50,100,100);
        t=new Thread(this);

        

        }

    public void run() {
        t.start();
    }
    public void move(){
        x+=dx; y+=dy;
     if(y<=0){
                dy=-dy;
                //return dy;
            }
            if(y>=369){
                dy=-dy;
                //return dy;
            }
            if(x<=0){
                dx=-dx;
               // return dx;
            }
            if(x>=565){
                dx=-dx;
               // return dx;
            }

    }
    public void paint(Graphics g){
        
    }

}
