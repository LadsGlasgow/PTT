import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ActionEventChoice implements ActionListener {
	private final GuiChoice frame;
	public ActionEventChoice(GuiChoice frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frame.quit) {
			System.exit(0);
		}
		if(e.getSource() == frame.admin) {
			//Create and run Admin GUI
		}
		if(e.getSource() == frame.director) {
			//Create and run Director GUI
		}
	}

}
