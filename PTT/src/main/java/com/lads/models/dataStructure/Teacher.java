package com.lads.models.dataStructure;

import com.lads.models.Date;

import java.util.ArrayList;

public class Teacher extends BasicData {

    private String name;
    private Date dob;
    private ArrayList<String> skills = new ArrayList<>();
    private ArrayList<String> trainings_due = new ArrayList<>();
    private ArrayList<String> trainings_taken = new ArrayList<>();

    //initialize with basic information.
    public Teacher(String name, Date dob){
        this.name = name;
        this.dob = dob;
    }


    public void addTrainingDue(String ...trainings){
        for (String training:trainings){
            this.trainings_due.add(training.trim());
        }
    }

    public void addSkills(String ...skills){
        for (String skill:skills){
            this.skills.add(skill.trim());
        }
    }


    public void addTrainingTaken(String ...trainings){
        for (String training:trainings){
            this.trainings_taken.add(training.trim());
        }
    }

    //this method decide the format of data stored.
    @Override
    public String toString() {
        return  name + "|" + dob + "|" + this.trainings_due.toString() + "|"
                + this.trainings_taken.toString() + "|" + this.skills.toString() + "\n";
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


	public boolean hasTakenTraining(String training){
        for (int i = 0; i < trainings_taken.size(); i++) {
            if (trainings_taken.get(i).equals(training)){
                return true;
            }
        }
        return false;
    }

    public boolean hasSkill(String skill){
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).equals(skill)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }
}
