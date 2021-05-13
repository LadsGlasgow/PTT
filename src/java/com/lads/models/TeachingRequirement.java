package com.lads.models;

import java.util.ArrayList;

public class TeachingRequirement {
    private String labName;
    private int staffRequired;
    private ArrayList<String> trainingRequired;

    public TeachingRequirement(String labName,int staffRequired){
        this.labName = labName;
        this.staffRequired = staffRequired;
    }

    public void addTrainingRequired(String trainingName){
        this.trainingRequired.add(trainingName);
    }
}
