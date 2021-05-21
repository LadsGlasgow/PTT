package com.lads.models.factories;

import com.lads.models.dataStructure.Module;
import com.lads.models.dataStructure.SingletonLoL;
import com.lads.models.dataStructure.SingletonLoT;

public class ModuleFactory implements DataFactory<Module> {

    //Factory method for Module
    //0:Module Name,1:teachers, 2:labs
    //e.g.: Module1 | [Simon,max] | [pythonLab101,JavaLab102]
	
    @Override
    public Module createObject(String parameterLine) {
        String[] parameters = parameterLine.split("\\|");

        //1.create with name
        Module module = new Module(parameters[0].trim());

        //teachers add part
        //delete "[" "]" and then split with ","
        String[] teachers = parameters[1].trim().substring(1,parameters[1].length() - 1).split(",");
        for (int i = 0; i < teachers.length; i++) {
            //use SingletonLoT to get relating teacher in the list of teacher.
            module.addTeacher(SingletonLoT.getInstance().findByName(teachers[i]));
        }

        //lab add part
        //delete "[" "]" and then split with ","
        String[] labs = parameters[2].trim().substring(1,parameters[2].length() - 1).split(",");
        for (int i = 0; i < labs.length; i++) {
            //use SingletonLoT to get relating teacher in the list of teacher.
            module.addLabs(SingletonLoL.getInstance().findByName(labs[i]));
        }
        return module;
    }
}
