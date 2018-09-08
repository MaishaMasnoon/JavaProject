import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SecondPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public static boolean GameOver = false;
	
	public static boolean point = false;
	public static int score = 0;
	public static final int width = 600;
	public static final int height = 800;
	
	AudioPlayer ap = new AudioPlayer("/Cartoon Hop-SoundBible.com-553158131.mp3");
	
	private int x = 0;
	private BufferedImage image;
	
	PersonImage pi = new PersonImage();
	
	WallImage wi = new WallImage(SecondPanel.width);
	Carrot c = new Carrot(SecondPanel.width);
	WallImage wi2 = new WallImage(SecondPanel.width+(SecondPanel.width/2));
	Carrot c2 = new Carrot(SecondPanel.width+(SecondPanel.width/2));
	
	public SecondPanel(){
		LoadImage();
		
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				super.mousePressed(e);
					ap.play();
					pi.goUpwards();
					
					
					
			}
			
		});
		
		
		
	}

	private void LoadImage() {
		try{
			image = ImageIO.read(new File("C:/Users/Md.NizamulHaq/Downloads/JAVA 1/JavaProject/Images/2nd panel1.jpg"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void paint(Graphics g){
		super.paint(g);
		
		g.drawImage(image,x,0, null);
		g.drawImage(image,x+2400,0, null);
		
		pi.drawPerson(g);
		wi.drawWall(g);
		c.drawCarrot(g);
		wi2.drawWall(g);
		c2.drawCarrot(g);
		
		g.setFont(new Font("Tahoma",Font.BOLD,40));
		g.drawString("Score "+score, width/2, 100);
		
		
	}
	
	public void move(){
		pi.personMovement();
		
	
		wi.wallMoving();
		c.carrotMoving();
		wi2.wallMoving();
		c2.carrotMoving();
		
		if(GameOver){
		wi.x=SecondPanel.width;
		c.x=SecondPanel.width;
		wi2.x=SecondPanel.width+(SecondPanel.width/2);
		c2.x=SecondPanel.width+(SecondPanel.width/2);
		GameOver = false;
	}
		
		x+=WallImage.speed;
		if(x==-2400){
			x=0;
		}
	
		if(point == true ){
			
				score+=1;
				
				point=false;
				
			
		}
	}
	
	public static boolean popUpMassage(){
		int result = JOptionPane.showConfirmDialog(null,"Game Over.\n Your Score is " +score+"\n Do you want to restart the game?","Game over", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION){
			return true;
		}
		else{
			return false;
		}
	}

	
	
}
