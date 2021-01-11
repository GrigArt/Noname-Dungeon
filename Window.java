
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	int x;
	int y;
	JPanel panel;
	JButton exitbutton;
	listenAction ActionListener;
	BasicMapPanel BMapPanel;
	Window(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double w = screenSize.getWidth();
		double h = screenSize.getHeight();
		int width = (int)w/5*5;
		int height = (int)h/5*5;
		x = 32;
		y = 32;
		this.setSize(screenSize);
		
		panel = new JPanel();
		BMapPanel = new BasicMapPanel(x,y);
		exitbutton = new JButton();
		
		ActionListener = new listenAction(this, exitbutton);
		
		exitbutton.addActionListener(ActionListener);
		exitbutton.setBounds(width-60, 10, 40, 40);
		exitbutton.setBackground(Color.darkGray);
		exitbutton.setBorder(null);
		exitbutton.setFocusable(false);
		exitbutton.setFont(new Font("Arial", Font.BOLD,30));
		exitbutton.setForeground(Color.BLACK);
		exitbutton.setText("X");
		
		BMapPanel.setBounds((width-x*16)/2, (height-y*16)/2, x*16,y*16);
		//BMapPanel.setSize(new Dimension(x*16,y*16));
		
		panel.setSize(screenSize);
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		panel.add(BMapPanel);
		panel.add(exitbutton);
		
		this.add(panel);
		
		this.setUndecorated(true);
		this.setVisible(true);
	}
}
