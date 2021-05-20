package com.lads.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.lads.models.connection.FileIO;
import com.lads.models.dataStructure.SingletonLoL;
import com.lads.view.AdminGUI;
import com.lads.view.DirectorGUI;
import com.lads.view.GuiChoice;

public class ActionEventChoice implements ActionListener {
	private final GuiChoice frame; //Private instance variable of GuiChoice in order to access components
	public ActionEventChoice(GuiChoice frame) {
		this.frame = frame; //Pass GuiChoice object in constructor to set instance variable.
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == frame.getQuit()) {
			System.exit(0); //Exit System on Quit
		}
		if(e.getSource() == frame.getAdmin()) {
			//set the file directory before leave
			FileIO.getInstance().setDirectory(frame.getFileDirectory().getText().trim());

			AdminGUI GUI = new AdminGUI();
			GUI.setVisible(true); //Load the AdminGUI if Administrator button is clicked
		}
		if(e.getSource() == frame.getDirector()) {
			//set the file directory before leave

			FileIO.getInstance().setDirectory(frame.getFileDirectory().getText().trim());

			DirectorGUI GUI = new DirectorGUI();
			GUI.setVisible(true); //Load the DirectorGUI if Director button is clicked
		}

	}

}
