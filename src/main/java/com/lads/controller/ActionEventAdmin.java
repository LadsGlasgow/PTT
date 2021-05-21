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

	//refresh the search result
	public void refreshSearchResult(Aggregate<Teacher> loT){
		String s = "";

		for (Iterator<Teacher> iterator = loT.getIterator();iterator.hasNext();){
			Teacher teacher = iterator.next();
			s +=
					"name:" + teacher.getName()
							+ " DOB:" + teacher.getDob() + // Changed to DOB
							" Training Taken:" + teacher.getTrainings_taken() + "Skills:" + teacher.getSkills() +  "\n";
		}
		frame.getTeacherText().setText(s);
	}

	public void populateText() {
		//Aggregate<Lab> labAggregate = FileIO.getInstance().fetchData("lab"); //***Create an aggregate of all of the different labs in the labs.txt file
		Aggregate<Lab> labAggregate = SingletonLoL.getInstance(); //Create an aggregate of all of the different labs in the labs.txt file

		String s = "";
		for (Iterator<Lab> iterator = labAggregate.getIterator();iterator.hasNext(); ){
			Lab lab = iterator.next();
			//If the lab has no teacher...
			if (!lab.isAlreadyHaveTeacher()){
				s +=
						"Lab Name:" + lab.getName()
								+ " * Number Staff Required:" + lab.getNumberOfStaffRequired()
								+ "* Training Required"	+ lab.getTrainingRequired().toString() + "\n";
			}
		}
		frame.getClassText().setText(s); //ClassText will display all labs without a teacher.
		Aggregate<Teacher> teacherAggregate = SingletonLoT.getInstance();
		refreshSearchResult(teacherAggregate); //Adds the teachers to the TeacherTextArea
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == frame.getQuit()) {
			//save labs, module,teachers before leave.
			FileIO.getInstance().storeData("module",SingletonLoM.getInstance());
			FileIO.getInstance().storeData("lab", SingletonLoL.getInstance());
			FileIO.getInstance().storeData("teacher", SingletonLoT.getInstance());
			System.exit(0);
		}
		
		//import from file.
		if (e.getSource() == frame.getAddTraining()){
			
			String line = frame.getTrainingAllocation().getText();
			String[] nameAndTraining = line.split("\\|");
			if(SingletonLoT.getInstance().findByName(nameAndTraining[0].trim()) != null) {
				Teacher teacher = SingletonLoT.getInstance().findByName(nameAndTraining[0].trim());
				//add training only needs
				if (!teacher.hasTakenTraining(nameAndTraining[1].trim())){
					teacher.addTrainingTaken(nameAndTraining[1].trim());
					//store to file
					FileIO.getInstance().storeData("teacher",SingletonLoT.getInstance());
					JOptionPane.showMessageDialog(null,"Done");
					Aggregate<Teacher> teacherAggregate = SingletonLoT.getInstance();
					refreshSearchResult(teacherAggregate); //Add teachers to the TeacherTextArea
				}
				else {
					JOptionPane.showMessageDialog(null,"Already taken");
				}
			}else {
				JOptionPane.showMessageDialog(null,"Cannot find teacher. Please ensure this teacher's name is entered correctly.");
			}
		}
		
		//submit lab allocation - Adding a teacher to a lab
		if (e.getSource() == frame.getAllocateLabButton()){
			//e.g. "Simon|DTALab101"
			if (!frame.getTeacherSelected().getText().equals("")){
				String[] teachersSelected = frame.getTeacherSelected().getText().split("\\|");

				Lab lab = SingletonLoL.getInstance().findByName(teachersSelected[1].trim());//find the lab first
				if (lab!=null){

					Teacher teacher = SingletonLoT.getInstance().findByName(teachersSelected[0].trim());
					//if lab do not contains the teacher and the teacher already takes all the trainings required.
					if ((!lab.haveTeacher(teacher.getName())) && lab.isTeacherHasQualification(teacher) ){
						lab.addTeacher(teacher);
						JOptionPane.showMessageDialog(null,"Done");
						Aggregate<Teacher> teacherAggregate = SingletonLoT.getInstance();
						refreshSearchResult(teacherAggregate); //Add teachers to the TeacherTextArea
						populateText();
					}
					else{
						JOptionPane.showMessageDialog(null,"The lab already has " + teacher.getName() + " added to it " +
								"\nor else they have not taken training for this lab.");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Cannot find the lab please check."); //Will only allow us to add Teachers to pre-existing Labs.
				}
			}

			//save labs, module,teachers before leave.
			FileIO.getInstance().storeData("module",SingletonLoM.getInstance());
			FileIO.getInstance().storeData("lab", SingletonLoL.getInstance());
			FileIO.getInstance().storeData("teacher", SingletonLoT.getInstance());
		}
		
		//search for skills
		if (e.getSource() == frame.getSearchButton()){
			String skillFilter = frame.getSearch().getText();

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
