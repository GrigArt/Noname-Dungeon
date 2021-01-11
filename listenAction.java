import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

public class listenAction implements ActionListener{
	Window window;
	JComponent component;
	String name;
	listenAction (Window w, JComponent JC){
		window = w;
		component = JC;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==component) {
			window.dispose();
		}
		
	}

}
