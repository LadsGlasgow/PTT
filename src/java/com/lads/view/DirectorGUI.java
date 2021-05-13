package com.lads.view;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ActionEventDirector;

public class DirectorGUI extends JFrame {
	protected JButton quit;
	protected JButton submit;
	protected JButton clear;
	protected JTextArea enterText;
	
	
	public DirectorGUI() {
		this.setSize(700, 500);
		this.setTitle("Director - Add teaching requirements");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocation(300, 200);
		
		JPanel mainPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel subPanel = new JPanel();
		JPanel subPanel2 = new JPanel();
		
		mainPanel.setLayout(new BorderLayout());
		subPanel2.setLayout(new GridLayout(2, 2));
		
		
		
		quit = new JButton("Quit");
		submit = new JButton("Submit");
		clear = new JButton("Clear");
		enterText = new JTextArea(25, 30);
		
		
		enterText.setLineWrap(true);
		
		JLabel instruction = new JLabel("Add teaching requirements below and click submit when finished");
		JLabel teacherAdd = new JLabel("Add a Teacher:");
		JLabel subjectAdd = new JLabel("Add a class:");
		instruction.setHorizontalAlignment(JLabel.CENTER);
		teacherAdd.setHorizontalAlignment(JLabel.CENTER);
		subjectAdd.setHorizontalAlignment(JLabel.CENTER);
			
		
		ActionEventDirector handler = new ActionEventDirector(this);
		quit.addActionListener(handler);
		clear.addActionListener(handler);
		submit.addActionListener(handler);
		
		subPanel.add(enterText);
		buttonPanel.add(submit);
		buttonPanel.add(clear);
		buttonPanel.add(quit);
		northPanel.add(instruction);
		mainPanel.add(subPanel);
		
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(new JLabel("                     "), BorderLayout.WEST);
		this.add(new JLabel("                     "), BorderLayout.EAST);

	}
	public static void main(String[] args) {
		DirectorGUI gui = new DirectorGUI();
		gui.setVisible(true);
	}
}
