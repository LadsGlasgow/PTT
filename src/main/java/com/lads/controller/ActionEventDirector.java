package com.lads.controller;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.FileWriter;


import com.lads.models.connection.FileIO;
import com.lads.models.dataStructure.Lab;
import com.lads.models.dataStructure.Module;
import com.lads.models.dataStructure.SingletonLoL;
import com.lads.models.dataStructure.SingletonLoM;
import com.lads.models.factories.FactoryProducer;
import com.lads.models.factories.LabFactory;
import com.lads.view.DirectorGUI;

import javax.swing.*;

public class ActionEventDirector implements ActionListener {
	private final DirectorGUI frame;
	public ActionEventDirector(DirectorGUI frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == frame.getQuit()) { //quits application
			System.exit(0);
		}
		if(e.getSource() == frame.getClear()) { // clears text in textbox
			frame.getEnterText().setText("");
		}

		//**** Set by GUI Choice
		if (e.getSource() == frame.getSubmit() ||e.getSource() == frame.getAdd()){
			FileIO.getInstance().setDirectory(frame.getFileDirectory().getText().trim());
			Boolean isDone = true;

			//the format should be:(ModuleName | LabName | numberStaffRequired|trainingRequired)
			// e.g. Module2|JavaLab202|1|[java,python]

			String[] textLine = frame.getEnterText().getText().split("\n");

			for (String line:textLine){
				//use "|" to split the parameter
				String[] parameters = line.split("\\|");

				//finds the module from the input
				Module module = SingletonLoM.getInstance().findByName(parameters[0].trim());
				//if the module does not exist
				if (module == null){
					JOptionPane.showMessageDialog(null,"The module does not exist, try again");
					isDone =false;
					break;
				}
				else {
					Lab lab = new Lab(parameters[1],Integer.parseInt(parameters[2])); //create lab from input
					// removes [] and splits training with , character and adds to attribute
					lab.addTrainingRequired(parameters[3]. 
							substring(1,parameters[3].length() - 1).split(","));
					//add lab to the existing module
					module.addLabs(lab);
					//add lab to the singleton list of labs
					SingletonLoL.getInstance().add(lab);
				}

			}

			if (isDone){
				//save labs and module when if input was successful
				FileIO.getInstance().storeData("module",SingletonLoM.getInstance());
				FileIO.getInstance().storeData("lab",SingletonLoL.getInstance());
				JOptionPane.showMessageDialog(null,"Done");

			}
		}

	}
	
}
