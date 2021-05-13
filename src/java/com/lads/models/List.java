package com.lads.models;

import java.io.PrintStream;

public interface List<T> {
	//define method headers for LoT and LoS
	public void add(T y);
	public void remove(T y);
	public T find(String y);
	public void print(PrintStream y);
	
}
