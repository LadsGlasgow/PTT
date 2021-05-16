package com.lads.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import com.lads.models.FileIO;
import com.lads.models.LoM;
import com.lads.models.Module;
import com.lads.view.DirectorGUI;

import javax.swing.*;

public class ActionEventDirector implements ActionListener {
	private final DirectorGUI frame;
	public ActionEventDirector(DirectorGUI frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == frame.getQuit()) {
			System.exit(0);
		}
		if(e.getSource() == frame.getClear()) {
			frame.getEnterText().setText("");
		}

		//when click submit
		if (e.getSource() == frame.getSubmit()){

			FileIO<Module> moduleFileIO = new FileIO<>(FileIO.moduleFilePath);

			LoM loM = new LoM();


			//the format should be:DTA|2|[java]
			String[] textLine = frame.getEnterText().getText().split("\n");

			for (String line:textLine){
				//use "|" to split the parameter
				String[] parameters = line.split("\\|");
				Module module = new Module(parameters[0].trim(),Integer.parseInt(parameters[1].trim()));
				module.addTraining(
						parameters[2].trim().substring(1, parameters[2].length()-1).split(",")
				);

				loM.add(module);
			}

			//store the data
			moduleFileIO.storeData(loM,true);

			JOptionPane.showMessageDialog(null,"Done");
		}

	}
	
}
