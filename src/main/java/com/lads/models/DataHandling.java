package com.lads.models;

public interface DataHandling<T> {
    T[] fetchData();
    void storeData(T[] data);
}
