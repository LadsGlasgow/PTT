package com.lads.view;
import java.awt.*;

import javax.swing.*;

//import ActionEventAdmin;
import com.lads.controller.*;

import com.lads.models.dataStructure.Teacher;
import com.lads.models.iterator.Aggregate;
import com.lads.models.iterator.Iterator;

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
	private JTextField fileDirectory;
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
		quit = new JButton("Quit");
		allocateLabButton = new JButton("Add teacher to Lab");
		addTraining = new JButton("Add Training");
		submit = new JButton("Submit Training");
		teacherSelected = new JTextField("Select the teachers(Lab name|Teacher name).e,g. 'ADS|Simon,Chris'");
		//JTextArea instructions = new JTextArea("Classes that require a teacher, and their teaching requirements, will appear on the left. On the right, please enter the skill you are looking for to locate teachers with that skill");
		//instructions.setHorizontalAlignment(JLabel.CENTER);
		//instructions.setLineWrap(true);n
		JLabel subjectInst = new JLabel("Labs without Teachers:");
		JLabel teacherInst = new JLabel("Enter skill to find suitable teachers:");
		
//		JTextArea classRequirements = new JTextArea(10, 10);


		search = new JTextField("[Enter skill to search...]");
		searchButton = new JButton("Search");
		classText = new JTextArea(40, 40);
		teacherText = new JTextArea(40, 40);
		JScrollPane scroll = new JScrollPane(classText);
		//JScrollPane scroll2 = new JScrollPane(teacherText);
		JScrollPane scroll2 = new JScrollPane(teacherText);


		teacherDisplay = new JPanel(new BorderLayout());
		fileDirectory = new JTextField("To add training for a teacher, enter \"Teacher name|Training required \"");
		teacherDisplay.add(scroll2);

		//refresh with all teacher in file.
//		refreshSearchResult(SingletonLoT.getInstance());
		//teacherDisplay.add(scroll2);

		ActionEventAdmin handler = new ActionEventAdmin(this);
		quit.addActionListener(handler);
		allocateLabButton.addActionListener(handler);
		searchButton.addActionListener(handler);
		addTraining.addActionListener(handler);


		directoryPanel.add(fileDirectory);
		directoryPanel.add(addTraining);
		searchBar.add(search);
		searchBar.add(searchButton);
		teacherPanel.add(searchBar, BorderLayout.NORTH);
		teacherTextBox.add(teacherDisplay, BorderLayout.CENTER);
		teacherTextBox.add(teacherInst, BorderLayout.NORTH);
		teacherTextBox.add(teacherSelected,BorderLayout.SOUTH);

		teacherPanel.add(teacherTextBox, BorderLayout.CENTER);
		teacherPanel.add(allocateLabButton, BorderLayout.SOUTH);
//		classPanel.add(classRequirements, BorderLayout.CENTER);
		classPanel.add(subjectInst, BorderLayout.NORTH);
		//classPanel.add(classText);


		classPanel.add(scroll);


//		classPanel.add(fileDirectory, BorderLayout.SOUTH);
		mainPanel.add(classPanel);
		mainPanel.add(teacherPanel);
		buttonPanel.add(directoryPanel);
		//northPanel.add(instructions);
		//buttonPanel.add(clearBut);
		//buttonPanel.add(addTraining);
		buttonPanel.add(quit);
		

		this.add(mainPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(new JLabel("                     "), BorderLayout.WEST);
		this.add(new JLabel("                     "), BorderLayout.EAST);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		handler.populateTeacherText();
		
		
	}
	//To be deleted, here rn for convenience
	public static void main(String[] args) {
		AdminGUI gui = new AdminGUI();
		gui.setVisible(true);
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

	public JTextField getFileDirectory() {
		return fileDirectory;
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
