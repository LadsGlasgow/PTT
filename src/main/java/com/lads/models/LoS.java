package com.lads.models;

import java.io.PrintStream;

public class LoS implements List<Subject>{
	
	Subject[] LoS;
	
	public LoS() {
		this.LoS = new Subject[1000]; // max # subjects set to 1000
	}
	
	public void add(Subject s) {
		for (int i = 0; i < LoS.length; i++) {
			if(LoS[i] == null) {
				LoS[i] = (Subject) s;
				return;
			}
		}
	}
	
	public void remove(Subject s) {
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

	@Override
	public List<Subject> createEmptyList() {
		return new LoS();
	}

	@Override
	public Subject[] getArray() {
		return this.LoS;
	}
}
