package com.lads.models.factories;

import com.lads.models.dataStructure.Lab;
import com.lads.models.dataStructure.SingletonLoT;

public class LabFactory extends DataAbstractFactory<Lab> {
    //Factory method for lab, example input (parameter)
    //0:lab_name,1:numberOfStaffRequired,2: trainingRequired, 3:teachers_name
    //e.g.: python101 | 2 | training101,training102 | Simon,Max
    @Override
    public Lab createObject(String parameterLine) {
    	
        //separate the string with "|" firstly.
        String[] parameters = parameterLine.split("\\|");

        //1.create the lab with lab name and numberOfStaffRequired
        Lab lab = new Lab(parameters[0].trim(),Integer.parseInt(parameters[1].trim()));

        //2. add training part
        //split with ","
        String[] trainings = parameters[2].
                substring(1,parameters[2].length() - 1).split(",");
        lab.addTrainingRequired(trainings);

        //3. add teachers part
        //split with ","
        String[] teachers = parameters[3].
                substring(1,parameters[3].length() - 1).split(",");
        for (int i = 0; i < teachers.length; i++) {
            //use SingletonLoT to get relating teacher in the list of teacher.
            lab.addTeacher(SingletonLoT.getInstance().findByName(teachers[i]));
        }
        return lab;
    }
}
