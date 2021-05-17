package com.lads.models.factories;

public abstract class DataAbstractFactory<T> {
    public abstract T createObject(String parameterLine);
}
