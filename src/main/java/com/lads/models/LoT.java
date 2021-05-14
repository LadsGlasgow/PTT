package com.lads.models;

import java.io.PrintStream;

public class LoT implements List{
	
	Teacher[] LoT;
	
	public LoT() {
		this.LoT = new Teacher[1000]; // max # teachers set to 1000
	}
	
	public void add(Object t) {
		for (int i = 0; i < LoT.length; i++) {
			if(LoT[i] == null) {
				LoT[i] = (Teacher) t;
				return;
			}
		}
	}
	
	public void remove(Object t) {
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

}
