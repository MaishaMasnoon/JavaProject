import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class FirstPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image = null;
	public boolean sp = false;
	public FirstPanel(){
		LoadImage();
		
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
				sp = true;
			}
		});
	}
	
	private void LoadImage() {
		try{
			image= ImageIO.read(new File("C:/Users/Md.NizamulHaq/Downloads/JAVA 1/JavaProject/Images/moody rabbit.jpg"));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void paint(Graphics g){
		super.paint(g);
		
		g.drawImage(image, 0, 0, SecondPanel.width, SecondPanel.height, null);
	}
}
