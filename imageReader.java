import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class imageReader extends Thread{
	int[][][][] unityImageTexture;
	String FileName;
	imageReader(String FN) {
		FileName = FN;
		this.setPriority(MIN_PRIORITY);
		this.start();
	}
	
/*
 * Взять изображение
 * сохранить цвета кадого пикселя в массив
 * создать файлы с текстовым содержанием каждого пикселя
 */
		public void run() {
			//if (new File("textures/a0.png").isFile()==false) {
			File file = new File(FileName);			
			BufferedImage image = null;
			Color color;
			//BufferedImage outImage = null;
			try {
				image = ImageIO.read(file);
			//	outImage = new BufferedImage(16,16,2);
			} catch (IOException e) {
				e.printStackTrace();
			}
			int num[] = new int[4];
			int numj = -1;
			boolean forNotVariable = false;
			unityImageTexture = new int[65][4][16][16];
				for (int j = 0; j<image.getHeight()-15; j+=16) {
					numj +=1;
					for (int i = 0; i<image.getWidth()-15; i += 16) {
						color = new Color(image.getRGB(i, j), true);
						if (color.getAlpha()==0) {
						//	forNotVariable = true;
							color = null;
							break;
						}
						num[numj] +=1;
						color = null;
						for (int k = 15;k>=0;k--) {
							for (int v = 15; v>=0; v--) {
								color = new Color(image.getRGB(k+i, v+j), true);
								unityImageTexture[numj*16+num[numj]][0][k][v] = color.getRed();
								unityImageTexture[numj*16+num[numj]][1][k][v] = color.getGreen();
								unityImageTexture[numj*16+num[numj]][2][k][v] = color.getBlue();
								unityImageTexture[numj*16+num[numj]][3][k][v] = color.getAlpha();
								color = null;
							}
						}
						
					}
					if (forNotVariable) {
						break;
					}
				}
		/*	for (int a=0; a<numAllnum<(image.getWidth()/16*image.getHeight()/16)-1; a++) {
				for (int i = 15;i>=0;i--) {
					for (int j = 15; j>=0; j--) {
						color = new Color(image.getRGB(i+a*16, j), true);
						unityImageTexture[a][0][i][j] = color.getRed();
						unityImageTexture[a][1][i][j] = color.getGreen();
						unityImageTexture[a][2][i][j] = color.getBlue();
						unityImageTexture[a][3][i][j] = color.getAlpha();
						color = null;
						}
					
					blue[i][j] = color.getBlue();
					red[i][j] = color.getRed();
					green[i][j] = color.getGreen();
					none[i][j] = color.getAlpha();
				//	outImage.setRGB(i,j, color.getRGB());
				//	System.out.println("b"+color.getBlue());
				//	System.out.println("r"+color.getRed());
				//	System.out.println("g"+color.getGreen());
				//	System.out.println("none "+color.getAlpha() 
					new Color(image.getColorModel().getRGB(image.getRaster().getDataElements(i,j,null)),true).getAlpha()
				//	); возвращает прозрачные пиксели
				}
			}*/
	/*		try {
				ImageIO.write(outImage,"png",outFile);
			} catch (IOException e) {
				// TODO Автоматически созданный блок catch
				e.printStackTrace();
			}*/
		//}
			this.interrupt();
		}
		public int[][][][] getTexture() {
			return unityImageTexture;
		}
}
