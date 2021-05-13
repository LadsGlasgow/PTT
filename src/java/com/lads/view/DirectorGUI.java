package com.lads.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DirectorGUI extends JFrame {
	protected JButton quit;
	protected JButton submit;
	protected JButton clear;
	private JTextArea enterText;
	private JTextArea addingT;
	private JTextArea addingC;
	
	public DirectorGUI() {
		this.setSize(700, 500);
		this.setTitle("Director - Add teaching requirements");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel mainPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel northPanel = new JPanel();
		
		mainPanel.setLayout(new GridLayout(2, 3));
		
		
		quit = new JButton("Quit");
		submit = new JButton("Submit");
		clear = new JButton("Clear");
		enterText = new JTextArea(25, 40);
		addingT = new JTextArea(20, 5);
		addingC = new JTextArea(20, 5);
		JLabel instruction = new JLabel("Please enter all teaching requirements into the TextArea below and hit Submit to add these to the file");
		JLabel teacherAdd = new JLabel("Please add the details of any new teachers below in the format [Name] [DateOfBirth] [Skills]");
		JLabel subjectAdd = new JLabel("Please add the details of any new classes below in the format [ClassName] [TeachingRequirements]");
		
		mainPanel.add(instruction);
		mainPanel.add(teacherAdd);
		mainPanel.add(subjectAdd);
		mainPanel.add(enterText);
		mainPanel.add(addingT);
		mainPanel.add(addingC);
		buttonPanel.add(submit);
		buttonPanel.add(clear);
		buttonPanel.add(quit);
		//northPanel.add(instruction);
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(northPanel, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		DirectorGUI gui = new DirectorGUI();
		gui.setVisible(true);
	}
}
