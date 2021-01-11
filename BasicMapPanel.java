import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class BasicMapPanel extends JPanel{
	int x;
	int y;
	//0 - пустая плитка, 1 - пол, 2 - пол, 3 - стена
	BasicMapPanel(int x, int y){
		int generationNumTexture = 5;
		imageReader reader = new imageReader("textures/0.png");
		ImageNamer ImNam = new ImageNamer();
		ImageRuleReader rule = new ImageRuleReader(ImNam.getName("textures/0.png"));
		while(reader.isAlive()) {
			
		}
		this.setLayout(new GridLayout(x,y));
		this.setPreferredSize(new Dimension(x*16, y*16));
		this.setBackground(Color.LIGHT_GRAY);
		for (int a = x*y;a!=0; a--)
			this.add(new unityMapDetal(0,3,reader.getTexture()));
		
	}
}
