/**
 * 
 */
package com.bean;

import java.sql.Time;

/**
 * @author tjy
 *
 */
public class Soc_policy {
	private int  id;
	private int start_time;//here need to discuss the data type.I do not know what this policy is for day or year
	private int end_time;
	private float temp_up;
	private float temp_low;
	private float humidity_up;
	private float humidity_low;
	private float noise_up;
	private float noise_low;
	
	//private short status;
	private int device_id;
	private String device_name;
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
	 * @return the start_time
	 */
	public int getStart_time() {
		return start_time;
	}
	/**
	 * @param i the start_time to set
	 */
	public void setStart_time(int i) {
		this.start_time = i;
	}
	/**
	 * @return the end_time
	 */
	public int getEnd_time() {
		return end_time;
	}
	/**
	 * @param end_time the end_time to set
	 */

	/**
	 * @return the status
	 */
//	public short getStatus() {
//		return status;
//	}
	/**
	 * @param status the status to set
	 */
//	public void setStatus(short status) {
//		this.status = status;
	//}
	/**
	 * @return the device_id
	 */
	public int getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}
	/**
	 * @param device_name the device_name to set
	 */
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	/**
	 * @return the temp_up
	 */
	public float getTemp_up() {
		return temp_up;
	}
	/**
	 * @param temp_up the temp_up to set
	 */
	public void setTemp_up(float temp_up) {
		this.temp_up = temp_up;
	}
	/**
	 * @return the temp_low
	 */
	public float getTemp_low() {
		return temp_low;
	}
	/**
	 * @param temp_low the temp_low to set
	 */
	public void setTemp_low(float temp_low) {
		this.temp_low = temp_low;
	}
	/**
	 * @return the humidity_up
	 */
	public float getHumidity_up() {
		return humidity_up;
	}
	/**
	 * @param humidity_up the humidity_up to set
	 */
	public void setHumidity_up(float humidity_up) {
		this.humidity_up = humidity_up;
	}
	/**
	 * @return the humidity_low
	 */
	public float getHumidity_low() {
		return humidity_low;
	}
	/**
	 * @param humidity_low the humidity_low to set
	 */
	public void setHumidity_low(float humidity_low) {
		this.humidity_low = humidity_low;
	}
	/**
	 * @return the noise_up
	 */
	public float getNoise_up() {
		return noise_up;
	}
	/**
	 * @param noise_up the noise_up to set
	 */
	public void setNoise_up(float noise_up) {
		this.noise_up = noise_up;
	}
	/**
	 * @return the noise_low
	 */
	public float getNoise_low() {
		return noise_low;
	}
	/**
	 * @param noise_low the noise_low to set
	 */
	public void setNoise_low(float noise_low) {
		this.noise_low = noise_low;
	}
	/**
	 * @param end_time the end_time to set
	 */
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
	

}
