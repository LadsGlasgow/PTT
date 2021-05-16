package com.lads.view;
import java.awt.*;

import javax.swing.*;

//import ActionEventAdmin;
import com.lads.controller.*;
import com.lads.models.*;
import com.lads.models.List;
import com.lads.models.Module;

public class AdminGUI extends JFrame {
	private JButton quit;
	private JButton submit;
	private JButton clearBut;
	private JPanel teacherDisplay;
	private JTextField search;
	private JButton run;
//	private JTextField fileDirectory;
	private JPanel classPanel;
	private JButton searchButton;
	private JTextField teacherSelected;

	//
	public AdminGUI() {

		this.setSize(1200, 500);
		this.setTitle("Administrator - Locate Teachers with Required Skills");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocation(300, 200);
		
		GridLayout gLayout = new GridLayout(0, 2);
		gLayout.setHgap(10);
		
		JPanel mainPanel = new JPanel(gLayout);
		classPanel = new JPanel(new GridLayout(10,1));


		JPanel teacherPanel = new JPanel(new BorderLayout());
		JPanel teacherTextBox = new JPanel(new BorderLayout());
		JPanel searchBar = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		quit = new JButton("Quit");
		clearBut = new JButton("Clear");
		run = new JButton("Run");
		teacherSelected = new JTextField("Select the teachers(moduleName|teacherName).e,g. 'ADS|Simon,Chris'");
		//JTextArea instructions = new JTextArea("Classes that require a teacher, and their teaching requirements, will appear on the left. On the right, please enter the skill you are looking for to locate teachers with that skill");
		//instructions.setHorizontalAlignment(JLabel.CENTER);
		//instructions.setLineWrap(true);n
		JLabel subjectInst = new JLabel("Classes without Teachers:");
		JLabel teacherInst = new JLabel("Enter skill to find suitable teachers:");
		
//		JTextArea classRequirements = new JTextArea(10, 10);


		search = new JTextField("[Enter skill to search...]");
		searchButton = new JButton("Search");


		teacherDisplay = new JPanel(new GridLayout(10,2));
//		fileDirectory = new JTextField("[Please Enter the file's directory here]");

		//refresh with teacher in file.
		refreshSearchResult(new FileIO<Teacher>(FileIO.teacherFilePath).fetchData(new Teacher(),new LoT()));

		ActionEventAdmin handler = new ActionEventAdmin(this);
		quit.addActionListener(handler);
		clearBut.addActionListener(handler);
		searchButton.addActionListener(handler);
		run.addActionListener(handler);

		searchBar.add(search);
		searchBar.add(searchButton);
		teacherPanel.add(searchBar, BorderLayout.NORTH);
		teacherTextBox.add(teacherDisplay, BorderLayout.CENTER);
		teacherTextBox.add(teacherInst, BorderLayout.NORTH);
		teacherTextBox.add(teacherSelected,BorderLayout.SOUTH);

		teacherPanel.add(teacherTextBox, BorderLayout.CENTER);
		teacherPanel.add(clearBut, BorderLayout.SOUTH);
//		classPanel.add(classRequirements, BorderLayout.CENTER);
		classPanel.add(subjectInst);

		LoM loM = (LoM) (new FileIO<Module>(FileIO.moduleFilePath).fetchData(new Module(),new LoM()));
		for (int i = 0; i < loM.getArrayWithoutTeacher().length; i++) {
			JLabel jLabel = new JLabel(
					"Class Name:" + loM.getArrayWithoutTeacher()[i].getName()
					+ " * Number Staff Required:" + loM.getArrayWithoutTeacher()[i].getNumberStaffRequired()
							+ "* Training Required"	+ loM.getArrayWithoutTeacher()[i].getTrainingsNeed().toString()
			);
			classPanel.add(jLabel);
		}



//		classPanel.add(fileDirectory, BorderLayout.SOUTH);
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
	public JButton getQuit() {
		return quit;
	}
	public JButton getSubmit() {
		return submit;
	}
	public JButton getClearBut() {
		return clearBut;
	}
	public JPanel getTeacherDisplay() {
		return teacherDisplay;
	}
	public JTextField getSearch() {
		return search;
	}
	public JButton getRun() {
		return run;
	}

//	public JTextField getFileDirectory() {
//		return fileDirectory;
//	}

	public JPanel getClassPanel() {
		return classPanel;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public JTextField getTeacherSelected() {
		return teacherSelected;
	}

	//refresh the search result
	public void refreshSearchResult(List<Teacher> loT){
		teacherDisplay.removeAll();

		//generate radio button with teachers
		for (int i = 0; i <= loT.getLastIndex(); i++) {
			JLabel jLabel = new JLabel(
					"name:" + loT.getArray()[i].getName()
							+ " date:" + loT.getArray()[i].getDob() +
							" Training Taken:" + loT.getArray()[i].getTrainings_taken()
			);
			teacherDisplay.add(jLabel);
		}

		teacherDisplay.repaint();
		teacherDisplay.validate();
	}


}
