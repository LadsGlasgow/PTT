package com.lads.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lads.view.DirectorGUI;

public class ActionEventDirector implements ActionListener {
	private final DirectorGUI frame;
	public ActionEventDirector(DirectorGUI frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frame.quit) {
			System.exit(0);
		}
		if(e.getSource() == frame.clear) {
			frame.enterText.setText("");
		}
	}
	
}
