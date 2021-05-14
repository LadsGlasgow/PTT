package com.lads.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lads.models.FileIO;
import com.lads.view.DirectorGUI;

public class ActionEventDirector implements ActionListener {
	private final DirectorGUI frame;
	public ActionEventDirector(DirectorGUI frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frame.getQuit()) {
			System.exit(0);
		}
		if(e.getSource() == frame.getClear()) {
			frame.getEnterText().setText("");
		}
		if(e.getSource() == frame.getAdd()) {
			//Code for loading the file
			FileIO newFile = new FileIO(frame.getEnterText().getText());
		}
		if(e.getSource() == frame.getSubmit()) {
			//Code for writing the requirements from the TextArea to the file.
		}
	}
	
}
