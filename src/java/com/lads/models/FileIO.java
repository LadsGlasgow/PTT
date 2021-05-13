package com.lads.models;

import java.io.FileReader;
import java.io.IOException;

//TODO 
public class FileIO<T> implements DataHandling<T>{
    private String path;


    public FileIO(String path){
       this.path = path;

    }

    @Override
    public T[] fetchData() {
        FileReader fr = null;
        try {
            fr = new FileReader(this.path);
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

}
