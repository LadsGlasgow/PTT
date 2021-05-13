package com.lads.models;

import java.io.FileReader;
import java.io.IOException;

public class FileIO<T> implements DataHandling<T>{
	
	//path to come from admin & director GUI (textbox)
    private String path;


    public FileIO(String path){
       this.path = path;

    }

    @Override
    public T[] fetchData() {
        FileReader fr = null;
        try {
            fr = new FileReader(this.path);
            // Implement file reading 
            
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

}
