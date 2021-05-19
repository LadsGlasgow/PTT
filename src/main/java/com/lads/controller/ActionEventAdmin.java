package com.lads.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lads.models.connection.FileIO;
import com.lads.models.dataStructure.*;
import com.lads.models.iterator.Aggregate;
import com.lads.models.iterator.Iterator;
import com.lads.view.AdminGUI;

import javax.swing.*;

public class ActionEventAdmin implements ActionListener{
	private final AdminGUI frame;
	public ActionEventAdmin(AdminGUI frame) {
		this.frame = frame;
	}


	//iterates through the list of teachers and prints their details to the text area
	public void refreshSearchResult(Aggregate<Teacher> loT){
		String s = "";

		for (Iterator<Teacher> iterator = loT.getIterator();iterator.hasNext();){
			Teacher teacher = iterator.next();
			s +=
					"name:" + teacher.getName()
							+ " date:" + teacher.getDob() +
							" Training Taken:" + teacher.getTrainings_taken() + "Skills:" + teacher.getSkills() +  "\n";
		}
		frame.getTeacherText().setText(s);
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getSource() == frame.getQuit()) {
			//save labs, module,teachers before leaving.
			FileIO.getInstance().storeData("module",SingletonLoM.getInstance());
			FileIO.getInstance().storeData("lab", SingletonLoL.getInstance());
			FileIO.getInstance().storeData("teacher", SingletonLoT.getInstance());
			System.exit(0);
		}
		//*** Don't need this anymore, edit and move this to GUI Choice
		if (e.getSource() == frame.getImportFileButton()){
			FileIO.getInstance().setDirectory(frame.getFileDirectory().getText().trim());
			Aggregate<Lab> labAggregate = FileIO.getInstance().fetchData("lab");

			String s = "";
			for (Iterator<Lab> iterator = labAggregate.getIterator();iterator.hasNext(); ){
				Lab lab = iterator.next();
				//if the lab has no teacher
				if (!lab.hasTeacher()){
					s +=
							"Lab Name:" + lab.getName()
									+ " * Number Staff Required:" + lab.getNumberOfStaffRequired()
									+ "* Training Required"	+ lab.getTrainingRequired().toString() + "\n";
				}
			}
			frame.getClassText().setText(s); // add lab details to view

			// add teacher details to the view
			Aggregate<Teacher> teacherAggregate = FileIO.getInstance().fetchData("teacher");
			refreshSearchResult(teacherAggregate);
		}
		
		//add teachers to a lab
		if (e.getSource() == frame.getAllocateLabButton()){
			
			if (!frame.getTeacherSelected().getText().equals("")){ // if teacher textbox is not empty
				String[] teachersSelected = frame.getTeacherSelected().getText().split("\\|"); // add teacher to array

				//** not sure how this code works (Dáire)
				// if the lab has not previously been linked with this teacher they should get training
				Lab lab = SingletonLoL.getInstance().findByName(teachersSelected[0].trim());
				if (lab!=null){
					for (String teacher_name:teachersSelected[1].trim().split(",")){
						lab.addTeacher(SingletonLoT.getInstance().findByName(teacher_name));
					}
					JOptionPane.showMessageDialog(null,"Done");
				}
				else {
					JOptionPane.showMessageDialog(null,"Cannot find the lab please check.");
				}
			}

			//save labs, module,teachers before leave.
			FileIO.getInstance().storeData("module",SingletonLoM.getInstance());
			FileIO.getInstance().storeData("lab", SingletonLoL.getInstance());
			FileIO.getInstance().storeData("teacher", SingletonLoT.getInstance());

		}


		//search function
		if (e.getSource() == frame.getSearchButton()){

			String skillFilter = frame.getSearch().getText(); // get text from search bar

			//if user does not input anything, refresh with all teachers
			if (skillFilter.equals("")){
				refreshSearchResult(SingletonLoT.getInstance());
			}
			else {
				Aggregate<Teacher> filterLoT = new Aggregate<Teacher>();

				//find the filtered teachers
				for (Iterator<Teacher> iterator = SingletonLoT.getInstance().getIterator();iterator.hasNext();){
					Teacher teacher = iterator.next();
					if (teacher.hasSkill(skillFilter)){
						filterLoT.add(teacher);
					}
				}

				//refresh the GUI with filter list.
				refreshSearchResult(filterLoT);
			}


			
		}
	}


	

}
