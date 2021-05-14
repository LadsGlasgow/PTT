package com.lads.models;

import javax.xml.crypto.Data;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileIO<T extends DataFactory> implements DataHandling<T>{
	
	//path to come from admin & director GUI (textbox)
    private String path;


    public FileIO(String path){
       this.path = path;

    }

    @Override
    public List<T> fetchData(T factory,List<T> listFactory) {
        FileReader fr = null;

        //Empty list
        List result = listFactory.createEmptyList();

        try {
            fr = new FileReader(this.path);
            // Implement file reading 
            Scanner s = new Scanner(fr);
            //read every line and use factory method to transfer it to object.
            for (int i = 0; s.hasNext(); i++) {
                String line = s.nextLine();
                if (!line.equals("")){

                    result.add(
                            factory.createObject(
                                    //split the string with |
                                    line.split("\\|"))
                    );
                }
            }
            fr.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public void storeData(List<T> data) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(this.path);

            // Implement file writing
            for (int i = 0; i < data.getArray().length; i++) {
                if (data.getArray()[i] != null){
                    fw.write(data.getArray()[i].toString());
                }
            }
            fw.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
