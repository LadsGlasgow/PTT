package com.lads.view;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import ActionEventAdmin;
import com.lads.controller.*;

public class AdminGUI extends JFrame {
	private JButton quit;
	private JButton submit;
	private JButton clearBut;
	private JButton searchButton;
	private JTextArea teacherDisplay;
	private JTextField search;
	private JButton run;
	private JTextArea classRequirements;
	private JTextField fileDirectory;
	public JTextField getFileDirectory() {
		return fileDirectory;
	}
	//
	public AdminGUI() {
		this.setSize(700, 500);
		this.setTitle("Administrator - Locate Teachers with Required Skills");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocation(300, 200);
		
		GridLayout gLayout = new GridLayout(0, 2);
		gLayout.setHgap(10);
		
		JPanel textBoxPanel = new JPanel(gLayout);
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel classPanel = new JPanel(new BorderLayout());
		
		
		JPanel teacherPanel = new JPanel(new BorderLayout());
		JPanel teacherTextBox = new JPanel(new BorderLayout());
		JPanel searchBar = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel trainingPanel = new JPanel(new FlowLayout());
		JPanel directoryPanel = new JPanel();
		
		quit = new JButton("Quit");
		clearBut = new JButton("Clear All");
		run = new JButton("Get File");
		submit = new JButton("Submit Training");
		
		JLabel subjectInst = new JLabel("Classes without Teachers:");
		JLabel teacherInst = new JLabel("Enter skill to find suitable teachers:");
		
		classRequirements = new JTextArea(10, 10);
		JScrollPane scroll = new JScrollPane(classRequirements);
		JTextField search = new JTextField("[Enter skill to search...]");
		searchButton = new JButton("Search");
		teacherDisplay = new JTextArea(10, 10);
		JScrollPane scroll2 = new JScrollPane(teacherDisplay);
		fileDirectory = new JTextField("[Please Enter the file's directory here]");
		JTextField training = new JTextField("Enter Lab Name and Teacher Name to organise training");
		
		ActionEventAdmin handler = new ActionEventAdmin(this);
		quit.addActionListener(handler);
		clearBut.addActionListener(handler);
		submit.addActionListener(handler);
		
		directoryPanel.add(fileDirectory);
		directoryPanel.add(run);
		trainingPanel.add(training);
		trainingPanel.add(submit);
		searchBar.add(search);
		searchBar.add(searchButton);
		teacherPanel.add(searchBar, BorderLayout.NORTH);
		teacherTextBox.add(scroll2, BorderLayout.CENTER);
		teacherTextBox.add(teacherInst, BorderLayout.NORTH);
		teacherPanel.add(teacherTextBox, BorderLayout.CENTER);
		teacherPanel.add(trainingPanel, BorderLayout.SOUTH);
		classPanel.add(scroll, BorderLayout.CENTER);
		classPanel.add(subjectInst, BorderLayout.NORTH);
		textBoxPanel.add(classPanel);
		textBoxPanel.add(teacherPanel);
		buttonPanel.add(clearBut);
		buttonPanel.add(quit);
		mainPanel.add(textBoxPanel, BorderLayout.CENTER);
		mainPanel.add(directoryPanel, BorderLayout.NORTH);
		mainPanel.add(trainingPanel, BorderLayout.SOUTH);
		
		
	
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(new JLabel("                     "), BorderLayout.WEST);
		this.add(new JLabel("                     "), BorderLayout.EAST);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		
	}
	public JButton getSearchButton() {
		return searchButton;
	}
	public static void main(String[] args) {
		AdminGUI gui = new AdminGUI();
		gui.setVisible(true);
	}
	public JButton getQuit() {
		return quit;
	}
	public JTextArea getClassRequirements() {
		return classRequirements;
	}
	public JButton getSubmit() {
		return submit;
	}
	public JButton getClearBut() {
		return clearBut;
	}
	public JTextArea getTeacherDisplay() {
		return teacherDisplay;
	}
	public JTextField getSearch() {
		return search;
	}
	public JButton getRun() {
		return run;
	}
	
}
