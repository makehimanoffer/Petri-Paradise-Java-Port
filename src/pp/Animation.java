/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pp;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class Animation implements Runnable{
    Thread t; int vrunTime=0;int arunTime=0;

    Image [] virusReel=new Image [5];
    Image [] amoebaReel=new Image[4];
    public Animation(){
        t=new Thread(this);
        virusReel[0]=new ImageIcon("images/virus1.png").getImage();
        virusReel[0]=virusReel[0].getScaledInstance(50, 50, 0);
        virusReel[1]=new ImageIcon("images/virus2.png").getImage();
        virusReel[1]=virusReel[1].getScaledInstance(50, 50, 0);
        virusReel[2]=new ImageIcon("images/virus3.png").getImage();
        virusReel[2]=virusReel[2].getScaledInstance(50, 50, 0);
        virusReel[3]=new ImageIcon("images/virus4.png").getImage();
        virusReel[3]=virusReel[3].getScaledInstance(50, 50, 0);
        virusReel[4]=new ImageIcon("images/virus5.png").getImage();
        virusReel[4]=virusReel[4].getScaledInstance(50, 50, 0);

        amoebaReel[0]=new ImageIcon("images/amoeba.png").getImage();
        amoebaReel[0]=amoebaReel[0].getScaledInstance(50, 50, 0);
        amoebaReel[1]=new ImageIcon("images/amoeba2.png").getImage();
        amoebaReel[1]=amoebaReel[1].getScaledInstance(50, 50, 0);
        amoebaReel[2]=new ImageIcon("images/amoeba3.png").getImage();
        amoebaReel[2]=amoebaReel[2].getScaledInstance(50, 50, 0);
        amoebaReel[3]=new ImageIcon("images/amoeba4.png").getImage();
        amoebaReel[3]=amoebaReel[3].getScaledInstance(50, 50, 0);
    }
    public void run() {
        t.start();
    }
    public void animateViruses(Graphics g, Virus v){
        vrunTime++;
        if(vrunTime<200){
            g.drawImage(virusReel[0],(int)v.x ,(int) v.y, null);
        }
        if(vrunTime>200&&vrunTime<400){
            g.drawImage(virusReel[1],(int)v.x ,(int) v.y, null);
        }
        if(vrunTime>400&&vrunTime<600){
            g.drawImage(virusReel[2],(int)v.x ,(int) v.y, null);
        }
        if(vrunTime>200&&vrunTime<800){
            g.drawImage(virusReel[3],(int)v.x ,(int) v.y, null);
        }
        if(vrunTime>800&&vrunTime<1000){
            g.drawImage(virusReel[4],(int)v.x ,(int) v.y, null);
        }
        if(vrunTime>1000){
            vrunTime=0;
        }
    }
    public void animateAmoeba(Graphics g, Amoeba v){
        arunTime++;
        if(arunTime<200){
            g.drawImage(amoebaReel[0],(int)v.x ,(int) v.y, null);
        }
        if(arunTime>200&&arunTime<400){
            g.drawImage(amoebaReel[1],(int)v.x ,(int) v.y, null);
        }
        if(arunTime>400&&arunTime<600){
            g.drawImage(amoebaReel[2],(int)v.x ,(int) v.y, null);
        }
        if(arunTime>600&&arunTime<800){
            g.drawImage(amoebaReel[3],(int)v.x ,(int) v.y, null);
        }

        if(arunTime>800){
            arunTime=0;
        }
    }

}
