package com.lads.models;

import java.util.ArrayList;
import java.util.Arrays;

public class LoM implements List<Module>{
	private int lastIndex;
	private Module[] loM;
	
	public LoM() {
		this.loM = new Module[1000]; // max # subjects set to 1000
		this.lastIndex = -1;

	}
	
	public void add(Module m) {
		this.loM[++lastIndex] = m;

	}
	
	public void remove(Module m) {
		for (int i = 0; i <= this.lastIndex; i++) {
			if(loM[i].getName().equals(m.getName())) {
				//swap from i
				for (int j = i; j < this.lastIndex; j++) {
					this.loM[j] = this.loM[j+1];
				}
				//set the last one to null
				this.loM[lastIndex--] = null;
			}
		}
	}
	
	public Module findByName(String name) {
		for (int i = 0; i <= lastIndex; i++) {
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

	public Module[] getArrayWithoutTeacher() {
		Module[] modules = new Module[100];
		int index = -1;

		for (int i = 0; i <= lastIndex; i++) {
			if (loM[i].getTeachers().size() == 0){
				modules[++index] = loM[i];
			}
		}

		Module[] result = Arrays.copyOf(modules,index+1);

		return  result;

	}

	public int getLastIndex() {
		return lastIndex;
	}

}
