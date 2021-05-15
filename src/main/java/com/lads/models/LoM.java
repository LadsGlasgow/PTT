package com.lads.models;

import java.io.PrintStream;

public class LoM implements List<Module>{
	private int currentIndex;
	private Module[] loM;
	
	public LoM() {
		this.loM = new Module[1000]; // max # subjects set to 1000
		this.currentIndex = -1;

	}
	
	public void add(Module m) {
		this.loM[++currentIndex] = m;

	}
	
	public void remove(Module m) {
		for (int i = 0; i <= this.currentIndex; i++) {
			if(loM[i].getName().equals(m.getName())) {
				//swap from i
				for (int j = i; j < this.currentIndex; j++) {
					this.loM[j] = this.loM[j+1];
				}
				//set the last one to null
				this.loM[currentIndex--] = null;
			}
		}
	}
	
	public Module findByName(String name) {
		for (int i = 0; i <= currentIndex; i++) {
			if(loM[i].getName().equals(name)) {
				return loM[i];
			}
		} return null;
	}

	public List<Module> createEmptyList() {
		return new LoM();
	}


	public Module[] getArray() {
		return this.loM;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

}
