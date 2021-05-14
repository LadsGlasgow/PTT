package com.lads.models;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int year,int month,int day){
        this.day = day;
        this.month = month;
        this.day = day;
    }
    
    //getter methods
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
    
    //clone method
    public Date clone(){
		return new Date(day, month, year);
	}
}
