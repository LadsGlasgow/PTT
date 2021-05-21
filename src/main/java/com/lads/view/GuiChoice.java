package com.lads.view;
import java.awt.FlowLayout;


import javax.swing.*;

import com.lads.controller.*;

public class GuiChoice extends JFrame {
	private JButton quit;
	private JButton admin;
	private JButton director;
	private JTextField fileDirectory;

	public GuiChoice() {
		this.setSize(500, 120);
		this.setTitle("User Selection");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocation(300, 300);
		
		quit = new JButton("Quit");
		admin = new JButton("Administrator");
		director = new JButton("Director");
		JLabel choiceLabel = new JLabel("Please select your role:");
		fileDirectory = new JTextField(30);

		ActionEventChoice handler = new ActionEventChoice(this);
		quit.addActionListener(handler);
		director.addActionListener(handler);
		admin.addActionListener(handler);
		
		this.add(choiceLabel);
		this.add(admin);
		this.add(director);
		this.add(quit);

		this.add(new JLabel("Please input the file directory for data(end with \"\\\"(Windows) or \"/\"(Mac))"));
		this.add(fileDirectory);
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

	public JTextField getFileDirectory() {
		return fileDirectory;
	}
}
