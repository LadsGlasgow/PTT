package com.lads.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

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
		// TODO Auto-generated method stub
		if(e.getSource() == frame.quit) {
			System.exit(0);
		}
		if(e.getSource() == frame.admin) {
			AdminGUI GUI = new AdminGUI();
			GUI.setVisible(true);
		}
		if(e.getSource() == frame.director) {
			DirectorGUI GUI = new DirectorGUI();
			GUI.setVisible(true);
		}
	}

}
