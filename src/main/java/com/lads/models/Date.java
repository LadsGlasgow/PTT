package com.lads.models;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int year,int month,int day){
        this.year = year;
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

    @Override
    public String toString() {
        return day + "|" + month  + "|" + year   + "|";
    }

    //clone method
    public Date clone(){
		return new Date(day, month, year);
	}
}
