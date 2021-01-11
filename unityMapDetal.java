
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;



public class unityMapDetal extends JPanel{
	int type; // 0 - базовый слой, 1 - слой рельефа, 2 - слой объектов рельефа и предметов, 3 - слой объектов и сущностей, 4 - слой взаимодействий
	int textureType;
	int[][][][] texture;
	unityMapDetal(int type, int textureType, int[][][][] IT){
		this.textureType = textureType-1;
		this.texture = IT;
		this.setLayout(null);
		if	(type==0) {
			this.setPreferredSize(new Dimension(16,16));
	
		}	
	}
	 public void paint(Graphics g) {
		 Graphics2D g2D = (Graphics2D) g;
		 for(int j=0;j<16;j++) {
			 for(int v=0;v<16;v++) {
				 g2D.setColor(new Color(texture[textureType][0][j][v], texture[textureType][1][j][v], texture[textureType][2][j][v], texture[textureType][3][j][v]));
				 g2D.fillRect(j, v, 1, 1);


			}
		 }
	 }
}
