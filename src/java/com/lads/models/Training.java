package com.lads.models;

import java.util.ArrayList;

//renamed class to Training

public class Training {
    private String labName;
    private int staffRequired;
    private ArrayList<String> trainingRequired;
    private Date trainingDate;

    public Training(String labName,int staffRequired, Date trainingDate){
        this.labName = labName;
        this.staffRequired = staffRequired;
        this.trainingDate = trainingDate.clone();
    }

    public void addTrainingRequired(String trainingName){
        this.trainingRequired.add(trainingName);
    }
}
