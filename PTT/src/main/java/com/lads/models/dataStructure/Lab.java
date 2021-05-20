package com.lads.models.dataStructure;

import java.util.ArrayList;

public class Lab extends BasicData {
    private String name;
    private int numberOfStaffRequired;
    private ArrayList<String> trainingRequired = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public Lab(String name,int numberOfStaffRequired){
        this.name = name;
        this.numberOfStaffRequired = numberOfStaffRequired;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addTrainingRequired(String ...training){
        for (int i = 0; i < training.length; i++) {
            if (training[i]!=null){
                this.trainingRequired.add(training[i].trim());
            }
        }
    }

    public void addTeacher(Teacher ...teachers){
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i]!=null){
                this.teachers.add(teachers[i]);
            }
        }
    }

    public boolean hasTeacher(){
        if (this.teachers.size() <= 0){
            return false;
        }
        return true;
    }

    //the format should be "name|numberOfStaffRequired|trainingRequired|teachers"
    //0:lab_name,1:numberOfStaffRequired,2: trainingRequired, 3:teachers_name
    //e.g.: python101 | 2 |  training101,training102  | Simon,Max
    @Override
    public String toString() {

        String result = name + "|" + numberOfStaffRequired + "|";

        //add training required
        result += trainingRequired.toString() + "|";

        for (int i = 0; i < this.teachers.size(); i++) {
            result += this.teachers.get(i).getName() ;
            if (i != this.teachers.size() - 1){
                result += ",";
            }
        }

        return   result + "\n";


    }

    public int getNumberOfStaffRequired() {
        return numberOfStaffRequired;
    }

    public ArrayList<String> getTrainingRequired() {
        return trainingRequired;
    }
}
