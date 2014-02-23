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
public class Amoeba implements Runnable {
double x,y,dx,dy;Thread t;;boolean hit=false;boolean hitBac=false;
double life=3;boolean alive; int cellStrength;
Rectangle impactRadius;
    public Amoeba(double dx,double dy, double x, double y){
        this.x=x;this.y=y;this.dx=dx;this.dy=dy;
        t=new Thread(this);

        
    
        }
    public void move(){
        x+=dx;y+=dy;
        
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
            if(x>=569){
                dx=-dx;
               // return dx;
            }
        if(life<0){
            alive=false;
        }
        checkHit();

    }

    public void run() {
        t.start();
    }
    public void paint(Graphics g){
        
    }
    public void checkHit(){
        if(hit==true){
            life-=.5;cellStrength-=20;
            hit=false;
        }
        if(hitBac==true){
            life-=1;cellStrength-=40;
            hitBac=false;
        }
    }

    }

