/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pp;

/**
 *
 * @author David
 */
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Frame implements Runnable {
    public final int leng= 620;
    public final int wid= 420;
    Board b;
    Thread t;

	public Frame(){
		JFrame frame = new JFrame();

                b=new Board();
                t=new Thread(this);
                frame.add(b);

		frame.setTitle("2-D Test Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(leng,wid);
                frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	public static void main(String[] args){
		new Frame();


	}
        public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

                if (b.GameOver()==true&&key == KeyEvent.VK_R){

                    b=new Board();}






	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
                if (b.GameOver()==true&&key == KeyEvent.VK_R){

                    b=new Board();}

	}


    public void run() {
        t.start();
        b.run();
    }
}
