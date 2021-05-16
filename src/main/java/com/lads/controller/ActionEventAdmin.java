package com.lads.controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lads.models.*;
import com.lads.models.List;
import com.lads.models.Module;
import com.lads.view.AdminGUI;

import javax.swing.*;

public class ActionEventAdmin implements ActionListener{
	private final AdminGUI frame;
	public ActionEventAdmin(AdminGUI frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		LoT loT = (LoT) (new FileIO<Teacher>(FileIO.teacherFilePath).fetchData(new Teacher(),new LoT()));

		FileIO<Module> moduleFileIO = new FileIO<Module>(FileIO.moduleFilePath);
		LoM loM = (LoM) moduleFileIO.fetchData(new Module(),new LoM());

		if(e.getSource() == frame.getQuit()) {
			System.exit(0);
		}
		if(e.getSource() == frame.getClearBut()) {
			frame.getTeacherSelected().setText("");
		}
		if (e.getSource() == frame.getRun()){
			//e.g. "DTA|Simon,Chris"
			if (!frame.getTeacherSelected().getText().equals("")){
				String[] teachersSelected = frame.getTeacherSelected().getText().split("\\|");
				loM.findByName(teachersSelected[0].trim()) //find the Module first
						.addTeacher(teachersSelected[1].trim().split(",")); // add teachers
			}
			moduleFileIO.storeData(loM);
			JOptionPane.showMessageDialog(null,"Done");
		}


		//search function
		if (e.getSource() == frame.getSearchButton()){

			String trainingFilter = frame.getSearch().getText();

			//if user does not input anything, refresh with all teachers
			if (trainingFilter.equals("")){
				frame.refreshSearchResult(loT);
			}
			else {
				LoT filterLoT = new LoT();

				//find the filtered teachers
				for (int i = 0; i <= loT.getLastIndex(); i++) {
					if (loT.getArray()[i].hasTakenTraining(trainingFilter)){
						filterLoT.add(loT.getArray()[i]);
					}
				}

				frame.refreshSearchResult(filterLoT);
			}


			
		}
	}
	

}
