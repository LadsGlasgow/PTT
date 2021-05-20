package com.lads.view;
import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import ActionEventDirector;
import com.lads.controller.*;

public class DirectorGUI extends JFrame {
	private JButton quit;
	private JButton submit;
	private JButton clear;
	private JTextArea enterText;
	private JButton add;
	private JTextField fileDirectory;


	public DirectorGUI() {
		//Details of the JFrame itself.
		this.setSize(700, 500);
		this.setTitle("Director - Add teaching requirements");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocation(300, 200);
		
		//Instantiating the panels that will be required to achieve the desired layout.
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		JPanel northPanel = new JPanel(new GridLayout(3,0));
		JPanel subPanel = new JPanel(new FlowLayout());
		
		//Instantiating the instance variables - Components of the GUI that will be required by other classes.
		quit = new JButton("Quit");
		submit = new JButton("Submit");
		clear = new JButton("Clear");
		enterText = new JTextArea("",25, 30);
		enterText.setLineWrap(true);
		add = new JButton("Add");
		fileDirectory = new JTextField("[Please enter the file's directory here]");
		
		//Adding a scrollbar to the JTextArea in order to ensure a large file can be read and displayed.
		JScrollPane scroll = new JScrollPane(enterText);
		//Instruction JLabels
		JLabel instruction = new JLabel("Add teaching requirements below and click submit when finished");
		JLabel instruction2 = new JLabel("Module name|Lab name|number of staff required|Training required");
		JLabel instruction3 = new JLabel("e.g Module1|SQLLab101|2|SQL");
		JLabel teacherAdd = new JLabel("Add a Teacher:");
		JLabel subjectAdd = new JLabel("Add a class:");
		
		//Setting the instructions to be aligned to the centre.
		instruction.setHorizontalAlignment(JLabel.CENTER);
		instruction2.setHorizontalAlignment(JLabel.CENTER);
		instruction3.setHorizontalAlignment(JLabel.CENTER);
		teacherAdd.setHorizontalAlignment(JLabel.CENTER);
		subjectAdd.setHorizontalAlignment(JLabel.CENTER);
			
		//Creating an object of type ActionEventDirector in order to add action listeners to the appropriate components.
		ActionEventDirector handler = new ActionEventDirector(this);
		getQuit().addActionListener(handler);
		clear.addActionListener(handler);
		submit.addActionListener(handler);
		add.addActionListener(handler);

		//Adding the components to the JPanels
		buttonPanel.add(submit);
		buttonPanel.add(clear);
		buttonPanel.add(getQuit());
		northPanel.add(instruction);
		northPanel.add(instruction2);
		northPanel.add(instruction3);
		
		//subPanel.add(fileDirectory);
		//subPanel.add(add);
		
		mainPanel.add(scroll, BorderLayout.CENTER);
		mainPanel.add(subPanel, BorderLayout.SOUTH);
		
		//Finally, adding the Panels to the main JFrame
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(northPanel, BorderLayout.NORTH);
		//The below two lines add blank JLabels in order to add a border, preventing the JTextAreas from extending all the way to the sides of the interface.
		this.add(new JLabel("                     "), BorderLayout.WEST);
		this.add(new JLabel("                     "), BorderLayout.EAST);

	}
	//To be deleted, here right now for convenience:
	public static void main(String[] args) {
		DirectorGUI gui = new DirectorGUI();
		gui.setVisible(true);
	}
	public JButton getQuit() {
		return quit;
	}
	public JButton getSubmit() {
		return submit;
	}
	public JButton getClear() {
		return clear;
	}
	public JTextArea getEnterText() {
		return enterText;
	}

	public JButton getAdd() {
		return add;
	}

	public JTextField getFileDirectory() {
		return fileDirectory;
	}
}
