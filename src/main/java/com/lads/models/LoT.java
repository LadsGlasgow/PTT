package com.lads.models;

import java.io.PrintStream;

public class LoT implements List<Teacher>{
	
	Teacher[] LoT;
	
	public LoT() {
		this.LoT = new Teacher[1000]; // max # teachers set to 1000
	}
	
	public void add(Teacher t) {
		for (int i = 0; i < LoT.length; i++) {
			if(LoT[i] == null) {
				LoT[i] = (Teacher) t;
				return;
			}
		}
	}
	
	public void remove(Teacher t) {
		for (int i = 0; i < LoT.length; i++) {
			if(LoT[i] == t) {
				LoT[i] = null;
			}
		}
	}
	
	public Teacher find(String name) {
		for (int i = 0; i < LoT.length; i++) {
			if(LoT[i].getName().equals(name)) {
				return LoT[i];
			}
		} return null;
	}

	public void print(PrintStream ps) {
		for (int i = 0; i < LoT.length; i++) {
			if(LoT[i] != null) {
			LoT[i].print(System.err);
			System.out.println();
			}
		}
	}

	@Override
	public  List<Teacher> createEmptyList() {
		return new LoT();
	}

	public Teacher[] getLoT() {
		return LoT;
	}

	@Override
	public Teacher[] getArray() {
		return this.LoT;
	}
}
