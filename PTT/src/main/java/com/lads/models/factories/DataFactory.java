package com.lads.models.factories;

public interface DataFactory<T> {
    public T createObject(String parameterLine);
}
