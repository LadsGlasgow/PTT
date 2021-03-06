package com.lads.models.dataStructure;

import java.util.ArrayList;

public class Lab implements BasicData {
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

    public boolean isAlreadyHaveTeacher(){
        if (this.teachers.size() < this.numberOfStaffRequired){
            return false;
        }
        return true;
    }

    public boolean haveTeacher(String teacherName){
        Boolean result = false;
        for (int i = 0; i < teachers.size(); i++) {
            if (teacherName.equals(this.teachers.get(i))){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isTeacherHasQualification(Teacher teacher){
        boolean result = false;

        for (int i = 0; i < this.trainingRequired.size(); i++) {
            result = false;
            for (int j = 0; j < teacher.getTrainings_taken().size(); j++) {
                //if the teacher already taken the training.
                if (teacher.getTrainings_taken().get(j).equals(this.trainingRequired.get(i))){
                    result = true;
                }
            }
            //if any training is not taken.
            if (result == false) { break; }
        }
        return result;
    }

    //the format should be "name|numberOfStaffRequired|trainingRequired|teachers"
    //0:lab_name,1:numberOfStaffRequired,2: trainingRequired, 3:teachers_name
    //e.g.: python101 | 2 |  training101,training102  | Simon,Max
    
    @Override
    public String toString() {

        String result = name + "|" + numberOfStaffRequired + "|";

        //add training required
        result += trainingRequired.toString() + "|[";

        for (int i = 0; i < this.teachers.size(); i++) {
            result += this.teachers.get(i).getName() ;
            if (i != this.teachers.size() - 1){
                result += ",";
            }
        }
        return result  + "]"  + "\n";
    }

    public int getNumberOfStaffRequired() {
        return numberOfStaffRequired;
    }

    public ArrayList<String> getTrainingRequired() {
        return trainingRequired;
    }
}
