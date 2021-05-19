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

	public void populateTeacherText() {
		Aggregate<Lab> labAggregate = FileIO.getInstance().fetchData("lab"); //***Create an aggregate of all of the different labs in the labs.txt file

		String s = "";
		for (Iterator<Lab> iterator = labAggregate.getIterator();iterator.hasNext(); ){
			Lab lab = iterator.next();
			//If the lab has no teacher...
			if (!lab.hasTeacher()){
				s +=
						"Lab Name:" + lab.getName()
								+ " * Number Staff Required:" + lab.getNumberOfStaffRequired()
								+ "* Training Required"	+ lab.getTrainingRequired().toString() + "\n"
				;
			}

		}
		frame.getClassText().setText(s); //***ClassText will display all labs without a teacher.

		Aggregate<Teacher> teacherAggregate = FileIO.getInstance().fetchData("teacher");
		refreshSearchResult(teacherAggregate); //***Adds the teachers to the TeacherTextArea
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
/*			FileIO.getInstance().setDirectory(frame.getFileDirectory().getText().trim());
			Aggregate<Lab> labAggregate = FileIO.getInstance().fetchData("lab"); //***Create an aggregate of all of the different labs in the labs.txt file

			String s = "";
			for (Iterator<Lab> iterator = labAggregate.getIterator();iterator.hasNext(); ){
				Lab lab = iterator.next();
				//If the lab has no teacher...
				if (!lab.hasTeacher()){
					s +=
							"Lab Name:" + lab.getName()
									+ " * Number Staff Required:" + lab.getNumberOfStaffRequired()
									+ "* Training Required"	+ lab.getTrainingRequired().toString() + "\n"
					;
				}

			}
			frame.getClassText().setText(s); //***ClassText will display all labs without a teacher.

			Aggregate<Teacher> teacherAggregate = FileIO.getInstance().fetchData("teacher");
			refreshSearchResult(teacherAggregate); //***Adds the teachers to the TeacherTextArea */
			
			String line = frame.getAddTraining().getText();
			String[] nameAndTraining = line.split("|");
			if(SingletonLoT.getInstance().findByName(nameAndTraining[0].trim()) != null) {
				SingletonLoT.getInstance().findByName(nameAndTraining[0].trim()).addTrainingDue(nameAndTraining[1].trim());;
			}else {
				JOptionPane.showMessageDialog(null,"Cannot find teacher. Please ensure this teacher's name is entered correctly.");
			}
		


		}
		//submit lab allocation - Adding a teacher to a lab
		if (e.getSource() == frame.getAllocateLabButton()){
			//e.g. "DTALab101|Simon,Chris"
			if (!frame.getTeacherSelected().getText().equals("")){
				String[] teachersSelected = frame.getTeacherSelected().getText().split("\\|");

				Lab lab = SingletonLoL.getInstance().findByName(teachersSelected[0].trim());//find the lab first
				if (lab!=null){
					for (String teacher_name:teachersSelected[1].trim().split(",")){
						lab.addTeacher(SingletonLoT.getInstance().findByName(teacher_name));
					}
					JOptionPane.showMessageDialog(null,"Done");

				}
				else {
					JOptionPane.showMessageDialog(null,"Cannot find the lab please check."); //***Will only allow us to add Teachers to pre-existing Labs.
				}

			}

			//save labs, module,teachers before leave.
			FileIO.getInstance().storeData("module",SingletonLoM.getInstance());
			FileIO.getInstance().storeData("lab", SingletonLoL.getInstance());
			FileIO.getInstance().storeData("teacher", SingletonLoT.getInstance());


		}
		//***Training Scheduler
		
		
		

		//search function
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
