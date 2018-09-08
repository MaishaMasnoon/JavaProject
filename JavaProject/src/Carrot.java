import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Carrot {
	public boolean carrot = false;
	private BufferedImage image = null;
	private static int carrot_width = 49;
	private static int carrot_Height = 96;
	public static int x;
	public static int y = SecondPanel.height/2;
	public static int speed = -6;
	
	AudioPlayer ap1 = new AudioPlayer("/Apple_Bite-Simon_Craggs-1683647397.mp3");
	
	public Carrot(int x){
		this.x=x;
		LoadImage();
	}
	private void LoadImage() {
		try{
			image = ImageIO.read(new File("C:/Users/Md.NizamulHaq/Downloads/JAVA 1/JavaProject/Images/carrot.png"));
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void drawCarrot(Graphics g){
		g.drawImage(image, x, y, null);
		
	}
	public void carrotMoving(){
		x+=speed;
		if(x<=-carrot_width){
			x=SecondPanel.width;
			y = SecondPanel.height/2;
			carrot_Height = 96;
		}
	
	
		Rectangle CarrotRect = new Rectangle(x,y,carrot_width, carrot_Height);
		
		if(CarrotRect.intersects(PersonImage.getPersonRect())){
			ap1.play();
			System.out.println("1");
			y=-SecondPanel.height;
			SecondPanel.point=true;
				
			
		}
		
	}
	
}