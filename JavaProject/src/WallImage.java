import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class WallImage {
	private BufferedImage image = null;
	private static int wall_width = 30;
	private static int wall_Height = 170;
	public static int x;
	public static int y = SecondPanel.height - 200;
	//public static int y = 0;
	AudioPlayer ap2 = new AudioPlayer("/videoplayback.mp3");
	
	public static int speed = -6;
	
	public WallImage(int x){
		this.x=x;
		LoadImage();
	}

	private void LoadImage() {
		try{
			image = ImageIO.read(new File("C:/Users/Md.NizamulHaq/workspace/JavaProject/Images/wall1.png"));
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void drawWall(Graphics g){
		g.drawImage(image, x, y, null);
		
	}
	public void wallMoving(){
		x+=speed;
		if(x<=-wall_width){
			x=SecondPanel.width;
			y = SecondPanel.height - 200;
			//y=0;
			wall_Height = 170;
		}
		
		Rectangle wallRect = new Rectangle(x,y,wall_width, wall_Height);
		
		if(wallRect.intersects(PersonImage.getPersonRect())){
			ap2.play();
			boolean option = SecondPanel.popUpMassage();
			if(option){
			try{
				Thread.sleep(500);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			PersonImage.resetPersonPosition();
			resetWallPosition();
		}else{
			JFrame frame = MainGame.getWindow();
			frame.dispose();
			MainGame.timer.stop();
			}
		}
	}

	private void resetWallPosition() {
		SecondPanel.GameOver = true;
		
	}
}
