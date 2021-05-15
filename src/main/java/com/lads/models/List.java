package com.lads.models;

import java.io.PrintStream;

public interface  List<T> {

	public  void add(T y);
	public  void remove(T y);
	public  T findByName(String name);

	public  List<T> createEmptyList();
	public  T[] getArray();
	
}
