package com.lads.models.connection;

import com.lads.models.dataStructure.BasicData;
import com.lads.models.factories.DataFactory;
import com.lads.models.factories.FactoryProducer;
import com.lads.models.iterator.Aggregate;
import com.lads.models.iterator.Iterator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO<T extends BasicData> implements DataHandling<T> {
	
	//path to come from admin & director GUI (textbox)
    private String directory;

    //implementation of Singleton design, so the directory can be shared between classes.
    private static FileIO instance = new FileIO();

    private FileIO(){}

    public static FileIO getInstance(){
        return instance;
    }

    //set the directory before using the FileIO!
    public void setDirectory(String directory){
        this.directory = directory;
    }

    @Override
    public Aggregate<T> fetchData(String className) {
        //merge the directory with file name.
        String path = this.directory + className + ".txt";

        FileReader fr = null;

        //a empty aggregate(list of objects).
        Aggregate<T> result = new Aggregate<T>();

        //get suitable factory with giving class name.
        DataFactory<T> factory = FactoryProducer.getFactory(className.toLowerCase().trim());

        try {
            fr = new FileReader(path);
            // Implement file reading 
            Scanner s = new Scanner(fr);
            //read every line and use factory method to transfer it to object.
            while (s.hasNext()){
                String line = s.nextLine();
                if (!line.equals("")){
                    result.add(
                            //create object with factory
                            factory.createObject(line)
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


    public void storeData(String className,Aggregate<T> data) {
        storeData(className,data,false);
    }

    public void storeData(String className,Aggregate<T> data,boolean isAddingToLast) {
        //merge the directory with file name.
        String path = this.directory + className + ".txt";

        FileWriter fw = null;
        try {
            fw = new FileWriter(path,isAddingToLast);

            //write the list of data into file by calling toString()
            for (Iterator iter = data.getIterator();iter.hasNext();){
                fw.write(iter.next().toString());
            }
            fw.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
