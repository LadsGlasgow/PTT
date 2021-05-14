package com.lads.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lads.models.FileIO;
import com.lads.view.AdminGUI;

public class ActionEventAdmin implements ActionListener{
	private final AdminGUI frame;
	public ActionEventAdmin(AdminGUI frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frame.getQuit()) {
			System.exit(0);
		}
		if(e.getSource() == frame.getClearBut()) {
			frame.getTeacherDisplay().setText("");
			frame.getSearch().setText("[Enter skill to search]");
			frame.getTeacherDisplay().setText("");
			frame.getClassRequirements().setText("");
			frame.getFileDirectory().setText("[Please enter the file's directory here]");
		}
		if(e.getSource() == frame.getSearchButton()) {
			//Code for loading the list of teachers with that skill
			
		}
		if(e.getSource() == frame.getSubmit()) {
			//Code for adding a teacher to a lab
		}
		if(e.getSource() == frame.getRun()) {
			//Code for taking the string in for the directory and reading the file, then displaying the classes without teachers and teachers with that skill in the TextAreas
			FileIO inputStream = new FileIO(frame.getFileDirectory().getText());
		}
	}
	

}
