package com.lads.models.connection;

import com.lads.models.dataStructure.BasicData;
import com.lads.models.iterator.Aggregate;

public interface DataHandling<T extends BasicData> {

    Aggregate<T> fetchData(String className);
    void storeData(String className,Aggregate<T> data);
}
