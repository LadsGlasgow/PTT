package com.lads.view;
import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import ActionEventDirector;
import com.lads.controller.*;
import com.lads.models.FileIO;

public class DirectorGUI extends JFrame {
	private JButton quit;
	private JButton submit;
	private JButton clear;
	private JTextArea enterText;
	private JButton add;


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
		subPanel.setLayout(new FlowLayout());
		
		
		
		quit = new JButton("Quit");
		submit = new JButton("Submit");
		clear = new JButton("Clear");
		enterText = new JTextArea("(name|numberStaffRequired|TrainingRequired)  e.g.\nDTA|2|[java]\nProg|1|[python,business]",25, 30);
		enterText.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(enterText);
//		importFile = new JButton("Import");
		enterText = new JTextArea(25, 30);
		add = new JButton("Add");
		
		JLabel instruction = new JLabel("Add teaching requirements below and click submit when finished");
		JLabel teacherAdd = new JLabel("Add a Teacher:");
		JLabel subjectAdd = new JLabel("Add a class:");
		JTextField fileDirectory = new JTextField("[Please enter the file's directory here]");
//		fileDirectory = new JTextField(FileIO.moduleFilePath);

		instruction.setHorizontalAlignment(JLabel.CENTER);
		teacherAdd.setHorizontalAlignment(JLabel.CENTER);
		subjectAdd.setHorizontalAlignment(JLabel.CENTER);
			
		
		ActionEventDirector handler = new ActionEventDirector(this);
		getQuit().addActionListener(handler);
		clear.addActionListener(handler);
		submit.addActionListener(handler);
		
		buttonPanel.add(submit);
		buttonPanel.add(clear);
		buttonPanel.add(getQuit());
		northPanel.add(instruction);
		
		subPanel.add(fileDirectory);
		subPanel.add(add);
		
//		subPanel.add(fileDirectory);
//		subPanel.add(importFile);
		mainPanel.add(scroll, BorderLayout.CENTER);
		mainPanel.add(subPanel, BorderLayout.SOUTH);
		
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(northPanel, BorderLayout.NORTH);
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
//	public JButton getImportFile() {
//		return importFile;
//	}
//
//	public JTextField getFileDirectory() {
//		return fileDirectory;
//	}
}
