package com.lads.models.dataStructure;

import com.lads.models.connection.FileIO;
import com.lads.models.iterator.Aggregate;


//LoL should be singleton, the list of lab can be shared between classes.
public class SingletonLoL {
    //implementation of Singleton design,read from file once.
    private static Aggregate<Lab> instance = FileIO.getInstance().fetchData("lab");

    private SingletonLoL(){ }

    public static Aggregate<Lab> getInstance(){
        return instance;
    }
}
