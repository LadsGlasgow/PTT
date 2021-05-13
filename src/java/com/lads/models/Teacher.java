package com.lads.models;

import java.util.ArrayList;

public class Teacher extends Staff{

    private ArrayList<String> trainings_due;
    private ArrayList<String> trainings_taken;

    //initialize with basic information.
    public Teacher(String name,Role role,Date dob){
        this.name = name;
        this.role = role;
        this.dob = dob;
    }

    /**
     *
     * Add training undertaken by teacher
     *
     */
    public void addTrainingUndertaken(String ...trainings){
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

}
