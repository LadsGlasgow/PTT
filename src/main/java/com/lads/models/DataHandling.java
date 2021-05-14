package com.lads.models;

public interface DataHandling<T extends DataFactory> {
    //dataFactory is to creat Object T.
    //listFactory is to create List<T>
    List<T> fetchData(T dataFactory,List<T> listFactory);
    void storeData(List<T> data);
}
