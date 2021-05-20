package com.lads.models.dataStructure;


import com.lads.models.connection.FileIO;
import com.lads.models.iterator.Aggregate;

//LoM should be singleton, the list of modules can be shared between classes.
public class SingletonLoM {
    //implementation of Singleton design
    private static Aggregate<Module> instance = FileIO.getInstance().fetchData("module");

    private SingletonLoM(){ }

    public static Aggregate<Module> getInstance(){
        return instance;
    }



}
