package com.example.demo;

public class StaDat {

	private double avg;
	private double min;
	private double max;
	private double sum;
	private int count;


	public StaDat(double avg, double min, double max, double sum, int count) {
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.sum = sum;
		this.count = count;
	}


	public double getAvg() {
		return avg;
	}


	public void setAvg(double avg) {
		this.avg = avg;
	}


	public double getMin() {
		return min;
	}


	public void setMin(double min) {
		this.min = min;
	}


	public double getMax() {
		return max;
	}


	public void setMax(double max) {
		this.max = max;
	}


	public double getSum() {
		return sum;
	}


	public void setSum(double sum) {
		this.sum = sum;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
}
