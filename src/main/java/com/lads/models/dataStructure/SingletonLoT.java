package com.lads.models.dataStructure;

import com.lads.models.connection.FileIO;
import com.lads.models.iterator.Aggregate;

//LoT should be singleton, the list of teachers can be shared between classes.
public class SingletonLoT {
  //implementation of Singleton design
    private static Aggregate<Teacher> instance = FileIO.getInstance().fetchData("teacher");

    private SingletonLoT(){ }

    public static Aggregate<Teacher> getInstance(){
        return instance;
    }

}
