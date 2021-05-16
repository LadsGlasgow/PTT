package com.lads.models;

public class LoT implements List<Teacher>{

	private int lastIndex;
	private Teacher[] lot;
	
	public LoT() {

		this.lot = new Teacher[1000]; // max # teachers set to 1000
		this.lastIndex = -1;
	}
	
	public void add(Teacher t) {
		this.lot[++lastIndex] = t;
	}
	
	public void remove(Teacher t) {
		for (int i = 0; i <= this.lastIndex; i++) {
			if(lot[i].getName().equals(t.getName())) {
				//swap from i
				for (int j = i; j < this.lastIndex; j++) {
					this.lot[j] = this.lot[j+1];
				}
				//set the last one to null
				this.lot[lastIndex--] = null;
			}
		}
	}
	
	public Teacher findByName(String name) {
		for (int i = 0; i <= lastIndex; i++) {
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

	public int getLastIndex() {
		return lastIndex;
	}
}
