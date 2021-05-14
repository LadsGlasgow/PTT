package com.lads.view;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.lads.controller.*;

public class GuiChoice extends JFrame {
	private JButton quit;
	private JButton admin;
	private JButton director;
	public GuiChoice() {
		this.setSize(500, 100);
		this.setTitle("User Selection");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocation(300, 300);
		
		quit = new JButton("Quit");
		admin = new JButton("Administrator");
		director = new JButton("Director");
		JLabel choiceLabel = new JLabel("Please select your role:");
		
		ActionEventChoice handler = new ActionEventChoice(this);
		quit.addActionListener(handler);
		director.addActionListener(handler);
		admin.addActionListener(handler);
		
		this.add(choiceLabel);
		this.add(admin);
		this.add(director);
		this.add(quit);
	}
	public static void main(String[] args) {
		GuiChoice gui = new GuiChoice();
		gui.setVisible(true);
	}
	public JButton getQuit() {
		return quit;
	}
	public JButton getAdmin() {
		return admin;
	}
	public JButton getDirector() {
		return director;
	}
	
}