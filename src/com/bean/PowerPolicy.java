/**
 * 
 */
package com.bean;

/**
 * @author tjy
 *
 */
public class PowerPolicy {
	private int id;
	private int start_time_second;//in db table,it is time data type,but it would be easy if i set it to second 
	private int end_time_second;
	private float price;//yuan per kwh
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the start_time_second
	 */
	public int getStart_time_second() {
		return start_time_second;
	}
	/**
	 * @param start_time_second the start_time_second to set
	 */
	public void setStart_time_second(int start_time_second) {
		this.start_time_second = start_time_second;
	}
	/**
	 * @return the end_time_second
	 */
	public int getEnd_time_second() {
		return end_time_second;
	}
	/**
	 * @param end_time_second the end_time_second to set
	 */
	public void setEnd_time_second(int end_time_second) {
		this.end_time_second = end_time_second;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	

}
