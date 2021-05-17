package com.lads.models.dataStructure;

import com.lads.models.connection.FileIO;
import com.lads.models.iterator.Aggregate;

public class SingletonLoT {
    private static Aggregate<Teacher> instance = FileIO.getInstance().fetchData("teacher");

    private SingletonLoT(){ }

    public static Aggregate<Teacher> getInstance(){
        return instance;
    }

}
