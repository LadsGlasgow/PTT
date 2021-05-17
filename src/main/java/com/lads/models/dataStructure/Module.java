package com.lads.models.dataStructure;

import java.util.ArrayList;

public class Module extends BasicData {
	private String name;
	private ArrayList<Teacher> teachers = new ArrayList<>(); //assume two teachers cannot have same name.

	private ArrayList<Lab> labs = new ArrayList<>();


	public Module(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	//Factory method for Module
	//0:Module Name,1:teachers, 2:labs
	//e.g.: Module1 | [Simon,max] | [pythonLab101,JavaLab102]
	public String toString() {
		String result =  this.name + "|[";

		//add all teachers
		for (int i = 0; i < this.teachers.size(); i++) {
			result += this.teachers.get(i).getName() ;
			if (i != this.teachers.size() - 1){
				result += ",";
			}
		}

		result += "]|[";

		//add all labs
		for (int i = 0; i < this.labs.size(); i++) {
			result += this.labs.get(i).getName() ;
			if (i != this.labs.size() - 1){
				result += ",";
			}
		}

		return result + "]\n";
	}


	public void addTeacher(Teacher ...teachers){
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i]!=null){
				this.teachers.add(teachers[i]);
			}
		}
	}

	public void addLabs(Lab ...labs){
		for (int i = 0; i < labs.length; i++) {
			if (labs[i]!=null){
				this.labs.add(labs[i]);
			}
		}
	}
}
