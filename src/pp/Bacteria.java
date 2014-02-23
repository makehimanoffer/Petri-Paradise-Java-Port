/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pp;

/**
 *
 * @author David
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class Bacteria implements Runnable {
double x,y,dx,dy;Thread t;Image bacteria;
Rectangle trackingRadius;
    public Bacteria(double dx,double dy, double x, double y){
        this.x=x;this.y=y;this.dx=dx;this.dy=dy;
        bacteria=new ImageIcon("images/bacteria.png").getImage();
         bacteria=bacteria.getScaledInstance(40, 60, 0);
        t=new Thread(this);



        }

    public void run() {
        t.start();
    }
    public void move(){


    }
    public void paint(Graphics g){
        g.drawImage(bacteria,(int) x, (int)y, null);
    }

}

