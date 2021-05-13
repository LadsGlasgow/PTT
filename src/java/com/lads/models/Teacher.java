package com.lads.models;

import java.io.PrintStream;
import java.util.ArrayList;

public class Teacher extends Staff{

    private ArrayList<String> trainings_due;
    private ArrayList<String> trainings_taken;

    //initialize with basic information.
    //do we need role since its always going to be a teacher? We can all discuss in meeting, nice programming technique though
    //also do we need getter for name and dob?
    public Teacher(String name, Role role, Date dob){
        this.name = name;
        this.role = role;
        this.dob = dob;
    }

    /**
     * addTrainingUndertaken changed to addTrainingDue
     */
    public void addTrainingDue(String ...trainings){
        for (String training:trainings){
            this.trainings_taken.add(training);
        }
    }

    /**
     *
     * Add training taken by teacher
     *
     */
    public void addTrainingTaken(String ...trainings){
        for (String training:trainings){
            this.trainings_taken.add(training);
        }
    }
    
    public String getName() {
		return this.name;
	}
    
    public void print(PrintStream ps) {
		ps.print(String.format("Teacher is %s with dob: %02d/%02d/%04d", this.getName(), this.getDob().getDay(),this.getDob().getMonth(),
				this.getDob().getYear()));
	}

}
