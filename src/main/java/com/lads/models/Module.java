package com.lads.models;

import javax.xml.crypto.Data;
import java.io.PrintStream;
import java.util.ArrayList;

public class Module implements DataFactory<Module> {
	private String name;
	private int numberStaffRequired;
	private ArrayList<String> teachers; //assume two teachers cannot have same name.
	private ArrayList<String> trainingsNeed;


	public Module(String name,int numberStaffRequired) {
		this.name = name;
		this.numberStaffRequired = numberStaffRequired;
		this.teachers = new ArrayList<String>();
		this.trainingsNeed = new ArrayList<String>();
	}

	public Module(){}

	public void addTraining(String ...training){
		for (int i = 0; i < training.length; i++) {
			this.trainingsNeed.add(training[i].trim());
		}
	}

	public void addTeacher(String ...teacherName){
		for (int i = 0; i < teacherName.length; i++) {
			this.teachers.add(teacherName[i].trim());
		}	}

	
	public String getName() {
		return name;
	}


	public String toString() {
		return  name + "|" + teachers.toString() + '|' + numberStaffRequired  + "|" + trainingsNeed.toString() + "\n" ;
	}

	//Factory method for Module
	//0:Module Name,1:teachers, 2:the number staff required ,3: training that they need
	//e.g.: AdvancedProgram|[Simon,Maria]|2|[Python,Java]
	public Module createObject(String... parameters) {
		Module module = new Module(parameters[0].trim(),Integer.parseInt(parameters[2].trim()));
		module.addTeacher(parameters[1].trim().substring(1,parameters[1].length() - 1).split(","));
		module.addTraining(parameters[3].trim().substring(1,parameters[3].length() - 1).split(","));

		return module;
	}
}
