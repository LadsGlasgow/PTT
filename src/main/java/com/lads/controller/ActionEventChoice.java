package com.lads.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.lads.models.connection.FileIO;
import com.lads.view.AdminGUI;
import com.lads.view.DirectorGUI;
import com.lads.view.GuiChoice;

public class ActionEventChoice implements ActionListener {
	private final GuiChoice frame;
	public ActionEventChoice(GuiChoice frame) {
		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == frame.getQuit()) {
			System.exit(0);
		}
		if(e.getSource() == frame.getAdmin()) {
			//set the file directory before leave
			FileIO.getInstance().setDirectory(frame.getFileDirectory().getText().trim());

			AdminGUI GUI = new AdminGUI();
			GUI.setVisible(true);
		}
		if(e.getSource() == frame.getDirector()) {
			//set the file directory before leave

			FileIO.getInstance().setDirectory(frame.getFileDirectory().getText().trim());

			DirectorGUI GUI = new DirectorGUI();
			GUI.setVisible(true);
		}

	}

}
