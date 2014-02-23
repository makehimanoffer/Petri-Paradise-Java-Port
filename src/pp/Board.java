/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pp;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author David
 */
public class Board extends JPanel implements ActionListener,Runnable {
    
    int ij=0;
    Animation animate=new Animation();
    Graphics buffer=getGraphics();
    Image bg;
    float timeL=0;

    Amoeba [] a=new Amoeba [2];
    Virus [] v= new Virus [3];
    Bacteria [] b= new Bacteria [3];
    Granule []  sOS={new Sugar(),new Sugar(),new Salt(),new Sugar(),new Salt()};
    Cursor c;
    Thread t;
    Timer time;
    public Board(){
         c=new Cursor(Cursor.HAND_CURSOR);
         a[0] =new Amoeba(0,0,100,100);a[0].alive=true;a[0].cellStrength=100;
         a[1]=new Amoeba(0,0,(int)a[0].x,(int)a[0].y);a[1].alive=false;a[1].cellStrength=0;
         v[0]=new Virus(Math.random(),Math.random(),(Math.random()*(Math.random()*650)),(Math.random()*(Math.random()*200)));
         v[1]=new Virus(-Math.random()*2,Math.random(),(Math.random()*(Math.random()*650)),(Math.random()*(Math.random()*200)));
        v[2]=new Virus(Math.random(),-Math.random(),(Math.random()*(Math.random()*650)),(Math.random()*(Math.random()*200)));
        b[0]=new Bacteria(0,0, 200,200);
        b[1]=new Bacteria(0,0, 400,0);
        b[2]=new Bacteria(0,0, 100,350);






         this.setCursor(c);
         t=new Thread(this);
         bg=new ImageIcon("images/PetriAlt.png").getImage();
         bg=bg.getScaledInstance(620, 420, 0);
         
         addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e){
                for(Amoeba a1: a){
            Rectangle mouseRect=new Rectangle(e.getX(),e.getY(),10,10);
            Rectangle amRect=new Rectangle((int)a1.x, (int)a1.y,40,40);
            if(mouseRect.getBounds().intersects(amRect.getBounds())){
                a1.x=e.getX(); a1.y=e.getY();
            }

            if(e.getX()<a1.x&&e.getY()<a1.y){
                a1.dx=1;a1.dy=1;
            }
            if(e.getX()<a1.x&&e.getY()>a1.y){
                a1.dx=1;a1.dy=-1;
            }
            if(e.getX()>a1.x&&e.getY()<a1.y){
                a1.dx=-1;a[0].dy=1;
            }
            if(e.getX()>a1.x&&e.getY()>a1.y){
                a1.dx=-1;a1.dy=-1;
            }
            if((e.getX()<a1.x&&e.getX()>a1.x+40)&&e.getY()<a1.y){
                a1.dy=1;
            }
            if((e.getX()<a1.x&&e.getX()>a1.x+40)&&e.getY()>a1.y){
                a1.dy=-1;
            }
            if((e.getY()<a1.y&&e.getY()>a1.y+40)&&e.getX()<a1.x){
                a1.dx=1;
            }
            if((e.getY()<a1.y&&e.getY()>a1.y+40)&&e.getX()>a1.x){
                a1.dx=-1;
            }

                }

            }


            public void mouseReleased(MouseEvent e) {
                    
            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });
        time=new Timer(5,this);
         time.start();
    }

    public void actionPerformed(ActionEvent e) {
        a[0].move();
        if(GameOver()!=true){timeL++;}
        for(int i=0;i<2;i++){
            collisionBacteria(a[0]);
        }
        a[1].move();
        collisionVirus(a[1]);
        collisionVirus(a[0]);
        for(int i=0;i<3;i++){
            v[i].move();
            for(int j=0;j<5;j++){
            virusWithSugar(v[i],sOS[j]);
            }
        }
        
            if(a[0].cellStrength>150){
                a[1].alive=true; a[1].life=3; a[1].cellStrength=100;a[0].cellStrength-=25;
                

        }
                
               
                for(int i=0;i<5;i++){
            
            sOS[i].collisionwithAmoeba(a[0]);
            sOS[i].collisionwithAmoeba(a[1]);

            
            
        }

                
            
       
        for(int i=0;i<5;i++){
            
            sOS[i].collisionwithAmoeba(a[0]);

            
        }
        collisionVirus(a[0]);

    }

    public void run() {
        t.start();
        //a[0].run();
    }
    public void paint(Graphics g){
         

        
        g.drawImage(bg, 0, 0, this);
        Font font2=new Font("TimesRoman", Font.ITALIC,  20);
                    g.setFont(font2);


       
        for(int i=0;i<5;i++){
            sOS[i].paint(g);
        }

        
        for(int i=0;i<3;i++){
        animate.animateViruses(g,v[i]);
        }
       

       
           if(a[0].alive==true){
            animate.animateAmoeba(g,a[0]);}
        if(a[1].alive==true){
            animate.animateAmoeba(g,a[1]);
            }
        for(int i=0;i<3;i++){
            b[i].paint(g);
        }
        

            g.setColor(Color.red);
           g.fillRect(0, 0,a[0].cellStrength,15);
           g.setColor(Color.GREEN);
           g.fillRect(0, 20,a[1].cellStrength,15);
           g.setColor((Color.black));
           g.drawString("Time " + timeL, 373, 20);

           if(a[0].cellStrength<=0&&a[1].cellStrength<=0){

               font2=new Font("TimesRoman", Font.ITALIC,  50);
                    g.setFont(font2);
                g.drawString("GAME OVER!!!!", 200, 200);
           }

       
           
        
       
        repaint();
    }
    public void collisionVirus(Amoeba a){
        
        Rectangle arect=new Rectangle((int)a.x,(int)a.y,40,40);

        for(Virus virus: v){
        Rectangle vrect=new Rectangle((int)virus.x,(int)virus.y,40,40);
        if(arect.getBounds().intersects(vrect.getBounds())&&a.hit==false){
            a.hit=true;
            
            virus.x=Math.random()*(Math.random()*800)*Math.random(); virus.y=Math.random()*(Math.random()*200)*Math.random();
            }
            }
        }
    public void collisionBacteria(Amoeba a){

        Rectangle arect=new Rectangle((int)a.x,(int)a.y,40,40);

        for(Bacteria bac: b){
        Rectangle vrect=new Rectangle((int)bac.x,(int)bac.y,40,40);
        if(arect.getBounds().intersects(vrect.getBounds())&&a.hit==false){
            a.hitBac=true;

            bac.x=-60; bac.y=-60;
            
            }

            }
        if((b[0].x==-60)&&(b[1].x==-60)&&(b[2].x==-60)){
            b[0]=new Bacteria(0,0, 200,200);
            b[1]=new Bacteria(0,0, 400,0);
            b[2]=new Bacteria(0,0, 100,350);
        }
        }
    public void virusWithSugar(Virus v, Granule a){
        Rectangle virusRect=new Rectangle((int)v.x,(int)v.y,40,40);
        Rectangle sugarRect=new Rectangle((int)a.x,(int)a.y,30,30);
        if(virusRect.intersects(sugarRect)){
            a=new Salt();
        }

    }
    public boolean GameOver(){
         if(a[0].cellStrength<=0&&a[1].cellStrength<=0){
               for(Amoeba am:a){
                   for(Virus vir: v){
                   for(Bacteria bac:b){
                   for(Granule s: sOS){

                   s.x=-60; s.y=-40;
                   am.alive=false;am.cellStrength=0;am.hit=false;
                   am.hitBac=false; am.dy=0; am.dy=0;
                   vir.x=-60; vir.y=-40;vir.dx=0; vir.dy=0;
                   bac.x=-60;bac.y=-40;
                   }
                   }
                   }
               }

                return true;
           }
         return false;
    }

    }
    


