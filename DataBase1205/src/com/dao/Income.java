package com.dao;

public class Income {

	private String month;
	private int income;
	public Income(String month,int income){
		this.income=income;
		this.month=month;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		 this.month=month;
	}
	
	
}
