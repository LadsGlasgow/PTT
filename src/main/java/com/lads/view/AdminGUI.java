package com.lads.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ActionEventAdmin;

public class AdminGUI extends JFrame {
	protected JButton quit;
	protected JButton submit;
	protected JButton clearBut;
	protected JTextArea teacherDisplay;
	protected JTextField search;
	protected JButton run;
	//
	public AdminGUI() {
		this.setSize(700, 500);
		this.setTitle("Administrator - Locate Teachers with Required Skills");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocation(300, 200);
		
		GridLayout gLayout = new GridLayout(0, 2);
		gLayout.setHgap(10);
		
		JPanel mainPanel = new JPanel(gLayout);
		JPanel classPanel = new JPanel(new BorderLayout());
		
		
		JPanel teacherPanel = new JPanel(new BorderLayout());
		JPanel teacherTextBox = new JPanel(new BorderLayout());
		JPanel searchBar = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		quit = new JButton("Quit");
		clearBut = new JButton("Clear");
		run = new JButton("Run");
		
		//JTextArea instructions = new JTextArea("Classes that require a teacher, and their teachning requirements, will appear on the left. On the right, please enter the skill you are looking for to locate teachers with that skill");
		//instructions.setHorizontalAlignment(JLabel.CENTER);
		//instructions.setLineWrap(true);n
		JLabel subjectInst = new JLabel("Classes without Teachers:");
		JLabel teacherInst = new JLabel("Enter skill to find suitable teachers:");
		
		JTextArea classRequirements = new JTextArea(10, 10);
		JTextField search = new JTextField("[Enter skill to search...]");
		JButton clear = new JButton("Search");
		teacherDisplay = new JTextArea(10, 10);
		JTextField fileDirectory = new JTextField("[Please Enter the file's directory here]");
		
		/*ActionEventAdmin handler = new ActionEventAdmin(this);
		quit.addActionListener(handler);
		clearBut.addActionListener(handler);*/
		
		searchBar.add(search);
		searchBar.add(clear);
		teacherPanel.add(searchBar, BorderLayout.NORTH);
		teacherTextBox.add(teacherDisplay, BorderLayout.CENTER);
		teacherTextBox.add(teacherInst, BorderLayout.NORTH);
		teacherPanel.add(teacherTextBox, BorderLayout.CENTER);
		teacherPanel.add(clearBut, BorderLayout.SOUTH);
		classPanel.add(classRequirements, BorderLayout.CENTER);
		classPanel.add(subjectInst, BorderLayout.NORTH);
		classPanel.add(fileDirectory, BorderLayout.SOUTH);
		mainPanel.add(classPanel);
		mainPanel.add(teacherPanel);
		//northPanel.add(instructions);
		//buttonPanel.add(clearBut);
		buttonPanel.add(run);
		buttonPanel.add(quit);
		
		
	
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(new JLabel("                     "), BorderLayout.WEST);
		this.add(new JLabel("                     "), BorderLayout.EAST);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		
	}
	public static void main(String[] args) {
		AdminGUI gui = new AdminGUI();
		gui.setVisible(true);
	}
}
