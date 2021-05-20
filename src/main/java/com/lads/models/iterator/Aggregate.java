package com.lads.models.iterator;

import com.lads.models.dataStructure.BasicData;

import java.util.ArrayList;

//Use iterator to hide the actual aggregate data
public class Aggregate<T extends BasicData>  { //*** how does this generic extends work
    protected ArrayList<T> array = new ArrayList<>();

    public void add(T obj) {
        this.array.add(obj);
    }

    public void remove(T obj) {
        this.array.remove(obj);
    }

    public T findByName(String name) {
        for (int i = 0; i < array.size(); i++) {
            if(this.array.get(i).getName().equals(name)) {
                return this.array.get(i);
            }
        } return null;
    }


    public Iterator<T> getIterator() {
        return new ConcreteIterator();
    }

    //*** what is a concrete iterator
    private class ConcreteIterator implements Iterator<T>{
        int index;

        @Override
        public boolean hasNext() {
            if (index < array.size()){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (this.hasNext()){
                return array.get(index++);
            }
            return null;
        }
    }
}
