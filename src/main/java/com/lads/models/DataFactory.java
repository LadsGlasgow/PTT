package com.lads.models;

public interface DataFactory<T> {
    T createObject(String ...parameters);
}
