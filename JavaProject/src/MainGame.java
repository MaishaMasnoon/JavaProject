import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MainGame {
	
	private static JFrame Window;
	public static Timer timer;
	
	private MainGame(){
		
		Window = new JFrame();
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setSize(SecondPanel.width,SecondPanel.height);
		Window.setLocationRelativeTo(null);
		Window.setTitle("JUMPING RABBIT :)");
		Window.setResizable(false);
	
	
	}
	public void menu(){
		FirstPanel f = new FirstPanel();
		SecondPanel s = new SecondPanel();
		
		timer = new Timer(70,new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				s.repaint();
				s.move();
			}
			
		});
		
		Window.add(f);
		Window.setVisible(true);
		while(f.sp == false){
			try{
				Thread.sleep(10);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		Window.remove(f);
		Window.add(s);
		s.setVisible(true);
		Window.revalidate();
		
		timer.start();
	}
	
	public static JFrame getWindow(){
		return Window;
	}
	public static void main(String [] args){
		MainGame mg = new MainGame();
		mg.menu();
	}
}
