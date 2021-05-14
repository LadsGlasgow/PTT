package com.lads.models;

import java.io.PrintStream;

public class LoS implements List{
	
	Subject[] LoS;
	
	public LoS() {
		this.LoS = new Subject[1000]; // max # subjects set to 1000
	}
	
	public void add(Object s) {
		for (int i = 0; i < LoS.length; i++) {
			if(LoS[i] == null) {
				LoS[i] = (Subject) s;
				return;
			}
		}
	}
	
	public void remove(Object s) {
		for (int i = 0; i < LoS.length; i++) {
			if(LoS[i] == s) {
				LoS[i] = null;
			}
		}
	}
	
	public Subject find(String name) {
		for (int i = 0; i < LoS.length; i++) {
			if(LoS[i].getName().equals(name)) {
				return LoS[i];
			}
		} return null;
	}

	public void print(PrintStream ps) {
		for (int i = 0; i < LoS.length; i++) {
			if(LoS[i] != null) {
			LoS[i].print(System.err);
			System.out.println();
			}
		}
	}
}
