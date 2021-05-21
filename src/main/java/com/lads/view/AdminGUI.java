package com.lads.view;
import java.awt.*;

import javax.swing.*;

//import ActionEventAdmin;
import com.lads.controller.*;

public class AdminGUI extends JFrame {
	private JButton quit;
	private JButton submit;
	private JButton allocateLabButton;
	private JPanel teacherDisplay;
	private JTextField search;
	private JButton addTraining;
	private JPanel classPanel;
	private JButton searchButton;
	private JTextField teacherSelected;
	private JTextArea teacherText;
	private JTextField trainingAllocation;
	private JTextArea classText;

	public AdminGUI() {

		this.setSize(1300, 500);
		this.setTitle("Administrator - Locate Teachers with Required Skills");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocation(300, 200);
		
		GridLayout gLayout = new GridLayout(0, 2);
		gLayout.setHgap(10);
		
		JPanel textBoxPanel = new JPanel(gLayout);
		JPanel mainPanel = new JPanel(gLayout);
		classPanel = new JPanel(new BorderLayout());

		
		JPanel teacherPanel = new JPanel(new BorderLayout());
		JPanel teacherTextBox = new JPanel(new BorderLayout());
		JPanel searchBar = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel directoryPanel = new JPanel();
		JLabel subjectInst = new JLabel("Labs without Teachers:");
		JLabel teacherInst = new JLabel("Enter skill to find suitable teachers:");
		quit = new JButton("Quit");
		allocateLabButton = new JButton("Add teacher to Lab");
		addTraining = new JButton("Schedule Training");
		submit = new JButton("Add Training");
		teacherSelected = new JTextField("Select the teachers(Teacher name|Lab name).e,g. 'Simon|python101'");

		
		search = new JTextField("[Enter skill to search...]");
		searchButton = new JButton("Search");
		classText = new JTextArea(40, 40);
		teacherText = new JTextArea(40, 40);
		JScrollPane scroll = new JScrollPane(classText);
		JScrollPane scroll2 = new JScrollPane(teacherText);


		teacherDisplay = new JPanel(new BorderLayout());
		trainingAllocation = new JTextField("To add training for a teacher, enter \"Teacher name|Training required \"");
		teacherDisplay.add(scroll2);
		

		ActionEventAdmin handler = new ActionEventAdmin(this);
		quit.addActionListener(handler);
		allocateLabButton.addActionListener(handler);
		searchButton.addActionListener(handler);
		addTraining.addActionListener(handler);


		directoryPanel.add(trainingAllocation);
		directoryPanel.add(addTraining);
		searchBar.add(search);
		searchBar.add(searchButton);
		teacherPanel.add(searchBar, BorderLayout.NORTH);
		teacherTextBox.add(teacherDisplay, BorderLayout.CENTER);
		teacherTextBox.add(teacherInst, BorderLayout.NORTH);
		teacherTextBox.add(teacherSelected,BorderLayout.SOUTH);
		teacherPanel.add(teacherTextBox, BorderLayout.CENTER);
		teacherPanel.add(allocateLabButton, BorderLayout.SOUTH);
		
		classPanel.add(subjectInst, BorderLayout.NORTH);
		classPanel.add(scroll);


		mainPanel.add(classPanel);
		mainPanel.add(teacherPanel);
		buttonPanel.add(directoryPanel);
		buttonPanel.add(quit);
		

		this.add(mainPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(new JLabel("                     "), BorderLayout.WEST);
		this.add(new JLabel("                     "), BorderLayout.EAST);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		handler.populateText();
	}
	
	public JButton getQuit() {
		return quit;
	}
	public JButton getSubmit() {
		return submit;
	}
	public JButton getAllocateLabButton() {
		return allocateLabButton;
	}
	public JPanel getTeacherDisplay() {
		return teacherDisplay;
	}
	public JTextField getSearch() {
		return search;
	}
	public JButton getAddTraining() {
		return addTraining;
	}

	public JTextField getTrainingAllocation() {
		return trainingAllocation;
	}

	public JPanel getClassPanel() {
		return classPanel;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public JTextField getTeacherSelected() {
		return teacherSelected;
	}

	public JTextArea getClassText() {
		return classText;
	}

	public JTextArea getTeacherText() {
		return teacherText;
	}
}
