package com.lads.models.iterator;

public interface Iterator<T> {
    public boolean hasNext(); // looks for end of list
    public T next(); // looks for next element in list
}