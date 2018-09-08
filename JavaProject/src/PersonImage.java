import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class PersonImage {
	private BufferedImage image = null;
	private static int persondiameter = 85;
	public static int x = 100;
	public static int y = 430;
	
	
	
	private static int speed = 2;
	private int accelaration = 1;

	//public Timer timer1;
	
	public PersonImage(){
		LoadImage();
	}

	private void LoadImage() {
		try{
			image = ImageIO.read(new File("C:/Users/Md.NizamulHaq/Downloads/JAVA 1/JavaProject/Images/15782645_594278380759459_1900795732_n.png"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	public void drawPerson(Graphics g){
		g.drawImage(image, x, y, null);
	}
	public void personMovement(){
		if(y>=0 && y<=600){
			
			
			speed +=accelaration;
			y+=speed;
			
		}
		
			else{
				reset();
			}
	}
	/*public void boing(){
		if(y==600){
			ap.play();
		}
	}*/
	public void goUpwards(){
		speed=-20;
		
	}
	
	public static void reset(){
		
		x=100;
		y=430;
	}
	public static void resetPersonPosition(){
		x=100;
		y=430;
	
		SecondPanel.score = 0;
	}
	public static Rectangle getPersonRect(){
		Rectangle personRect = new Rectangle(x,y,persondiameter,157);
		return personRect;
	}
	
	
	

}
