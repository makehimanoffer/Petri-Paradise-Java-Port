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
public class Salt extends Granule  implements Runnable{
double x,y,dx,dy;Thread t;Image salt;
    public Salt(){
        x= (Math.random()*(Math.random()*600)); y=(Math.random()*(Math.random()*500));
        salt=new ImageIcon("images/salt.png").getImage();
        //salt=getImage(getCodeBase(),"salt.png");
        salt=salt.getScaledInstance(30, 30, 0);
    }

    public void run() {
        t.start();
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(salt, (int)x,(int) y, null);
    }
    public void collisionwithAmoeba(Amoeba a){
        Rectangle arect=new Rectangle((int)a.x,(int)a.y,50,50);
        Rectangle saltrect=new Rectangle((int)x,(int)y,30,30);
        if(arect.getBounds().intersects(saltrect.getBounds())){
            a.cellStrength-=10;
            x= (Math.random()*(Math.random()*650)); y=(Math.random()*(Math.random()*450));
        }

    }

}
