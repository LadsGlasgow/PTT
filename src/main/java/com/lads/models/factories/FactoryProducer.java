package com.lads.models.factories;

/**
 *
 * A producer class for generating factories with static methods.
 *
 */
public class FactoryProducer {
    public static DataFactory getFactory(String factoryName){
        if (factoryName.equalsIgnoreCase("teacher")){
            return new TeacherFactory();
        }
        else if (factoryName.equalsIgnoreCase("module")){
            return new ModuleFactory();
        }
        else if (factoryName.equalsIgnoreCase("lab")){
            return new LabFactory();
        }
        return null;
    }

}
