package com.domenicosp.projectoop;

public class StaDat {

	/**
	 * 
	 */
	
	private String field;
	private double avg;
	private double min;
	private double max;
	private double sum;
	private int count;

	
	public StaDat(String field, double avg, double min, double max, double sum, int count) {
		
		this.field = field;
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.sum = sum;
		this.count = count;
	}

	/**
	 * Preleva la stringa 
	 * @return field stringa del campo dei record 
	 */
	public String getField() {
		return field;
	}

	/**
	 * Fa il set della stringa field
	 * @param field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * Preleva la media 
	 * @return averange media dei valori
	 */
	public double getAvg() {
		return avg;
	}

	/**
	 * Fa il set di avg 
	 * @param avg double media 
	 */
	public void setAvg(double avg) {
		this.avg = avg;
	}

	/**
	 * Preleva il minimo degli elementi di tipo double
	 * @return min double 
	 */
	public double getMin() {
		return min;
	}

	/**
	 * Imposta min di tipo double
	 * @param min double minimo
	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * Preleva il massimo degli elementi di tipo double
	 * @return max double
	 */
	public double getMax() {
		return max;
	}

	/**
	 * Imposta max di tipo double
	 * @param max
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * Preleva la somma degli elementi 
	 * @return sum double
	 */
	public double getSum() {
		return sum;
	}

	/**
	 * Imposta somma di tipo double
	 * @param sum 
	 */
	public void setSum(double sum) {
		this.sum = sum;
	}

	/**
	 * Preleva il contatore di elementi
	 * @return count di tipo int
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Imposta il contatore di tipo intero 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "StaDat [field=" + field + ", avg=" + avg + ", min=" + min + ", max=" + max + ", sum=" + sum + ", count="
				+ count + "]";
	}
	
	
}
