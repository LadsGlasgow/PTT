package com.lads.models;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Teacher implements DataFactory<Teacher> {

    private String name;
    private Date dob;
    private ArrayList<String> trainings_due = new ArrayList<>();
    private ArrayList<String> trainings_taken = new ArrayList<>();

    //initialize with basic information.
    public Teacher(String name, Date dob){
        this.name = name;
        this.dob = dob;


    }

    public Teacher(){

    }

    //Factory method for teacher
    //0:name, 1~3 dob,4: trainings_due, 5:trainings_taken
    //e.g.: StevenJobs | 1955 | 2 | 24 | Design,Management | Python,Java
    @Override
    public Teacher createObject(String ...parameters) {
        Teacher teacher = new Teacher(parameters[0].trim(),new Date(
                Integer.parseInt(parameters[1].trim()),Integer.parseInt(parameters[2].trim()),Integer.parseInt(parameters[3].trim()))
        );
        //delete "[" "]" and then split with ","
        String[] trainings_due = parameters[4].
                substring(1,parameters[4].length() - 1).split(",");
        String[]  trainings_taken = parameters[5].
                substring(1,parameters[5].length() - 1).split(",");
        teacher.addTrainingDue(trainings_due);
        teacher.addTrainingTaken(trainings_taken);
        return teacher;
    }

    /**
     * addTrainingUndertaken changed to addTrainingDue
     */
    public void addTrainingDue(String ...trainings){
        for (String training:trainings){
            this.trainings_due.add(training.trim());
        }
    }

    /**
     *
     * Add training taken by teacher
     *
     */
    public void addTrainingTaken(String ...trainings){
        for (String training:trainings){
            this.trainings_taken.add(training.trim());
        }
    }

    //this method decide the format of data stored.
    @Override
    public String toString() {
        return  name + "|" + dob + "|" + this.trainings_due.toString() + "|" + this.trainings_taken.toString() + "\n";
    }

    public String getName() {
		return this.name;
	}

    public Date getDob() {
        return dob;
    }

    public ArrayList<String> getTrainings_taken() {
        return trainings_taken;
    }

    public void print(PrintStream ps) {
		ps.print(String.format("Teacher is %s with dob: %02d/%02d/%04d", this.getName(), this.getDob().getDay(),this.getDob().getMonth(),
				this.getDob().getYear()));
	}

	public boolean hasTakenTraining(String training){
        for (int i = 0; i < trainings_taken.size(); i++) {
            if (trainings_taken.get(i).equals(training)){
                return true;
            }
        }
        return false;
    }


}
