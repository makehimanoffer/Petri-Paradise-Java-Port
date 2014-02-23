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
public class Sugar extends Granule implements Runnable {
double x,y,dx,dy;Thread t;Image sugar;
    public Sugar(){
        x= (Math.random()*(Math.random()*650)); y=(Math.random()*(Math.random()*450));
        sugar=new ImageIcon("images/sugar.png").getImage();
        //sugar=getImage(getDocumentBase(),"sugar.png");
        sugar=sugar.getScaledInstance(30, 30, 0);
    }


    public void run() {
        t.start();
    }
     public void paint(Graphics g){
        g.drawImage(sugar, (int)x, (int)y, null);
    }
    public void collisionwithAmoeba(Amoeba a){
        Rectangle arect=new Rectangle((int)a.x,(int)a.y,50,50);
        Rectangle sugarrect=new Rectangle((int)x,(int)y,30,30);
        if(arect.getBounds().intersects(sugarrect.getBounds())&&a.life>0){
            a.life+=1;a.cellStrength+=20;
            x= (Math.random()*(Math.random()*650)); y=(Math.random()*(Math.random()*450));
        }

    }
}
