package com.lads.models;

import java.io.PrintStream;

public class LoT implements List<Teacher>{

	private int currentIndex;
	private Teacher[] lot;
	
	public LoT() {

		this.lot = new Teacher[1000]; // max # teachers set to 1000
		this.currentIndex = -1;
	}
	
	public void add(Teacher t) {
		this.lot[++currentIndex] = t;
	}
	
	public void remove(Teacher t) {
		for (int i = 0; i <= this.currentIndex; i++) {
			if(lot[i].getName().equals(t.getName())) {
				//swap from i
				for (int j = i; j < this.currentIndex; j++) {
					this.lot[j] = this.lot[j+1];
				}
				//set the last one to null
				this.lot[currentIndex--] = null;
			}
		}
	}
	
	public Teacher findByName(String name) {
		for (int i = 0; i <= currentIndex; i++) {
			if(lot[i].getName().equals(name)) {
				return lot[i];
			}
		} return null;
	}


	public  List<Teacher> createEmptyList() {
		return new LoT();
	}

	public Teacher[] getArray() {
		return this.lot;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}
}
