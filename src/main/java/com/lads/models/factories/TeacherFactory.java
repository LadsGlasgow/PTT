package com.lads.models.factories;

import com.lads.models.Date;
import com.lads.models.dataStructure.Teacher;

public class TeacherFactory implements DataFactory<Teacher> {

    //Factory method for teacher
    //0:name, 1~3(dmy) dob,4: trainings_due, 5:trainings_taken, 6:skills
    //e.g.: StevenJobs | 1955 | 2 | 24 | Design,Management | training1,training2  | Python,Java
    @Override
    public Teacher createObject(String parameterLine) {
        //separate the string with "|" 
        String[] parameters = parameterLine.split("\\|");

        //1.create the teacher with name and dob (dd/mm/yy)
        Teacher teacher = new Teacher(parameters[0].trim(),new Date(
                Integer.parseInt(parameters[1].trim()),Integer.parseInt(parameters[2].trim()),Integer.parseInt(parameters[3].trim()))
        );

        //add trainings_due and split with ","
        String[] trainings_due = parameters[4].
                substring(1,parameters[4].length() - 1).split(",");
        
      //add trainings_taken and split with ","
        String[]  trainings_taken = parameters[5].
                substring(1,parameters[5].length() - 1).split(",");

      //add skills and split with ","
        String[] skills = parameters[6].
                substring(1,parameters[6].length() - 1).split(",");

        //add the rest of the parameters to the teacher
        teacher.addTrainingDue(trainings_due);
        teacher.addTrainingTaken(trainings_taken);
        teacher.addSkills(skills);
        return teacher;
    }

}
