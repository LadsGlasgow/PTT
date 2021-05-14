package com.lads.models;

import java.io.PrintStream;

public class Subject {
	
	private String name;
	private String teacher;
	/*
	 *  UML Class diagram has String[] teachingRequirements? Do we need this?
	 */
	
	public Subject(String name, String teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	
	public String getName() {
		return name;
	}

	public String getTeacher() {
		return teacher;
	}
	
	public void print(PrintStream ps) {
		ps.print(String.format("The subject %s is taught by the teacher %s", this.getName(), this.getTeacher()));
	}
	
	

	
}
