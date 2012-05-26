/**
 * 
 */
package com.bean;

import java.sql.Time;

/**
 * @author tjy
 *
 */
public class Fps_policy {
	private int  id;
	private int start_time;
	private int end_time;
	private short status;
	private int device_id;
	private String device_name;
	private int exec_humidity;
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
	 * @param start_time the start_time to set
	 */
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	/**
	 * @return the end_time
	 */
	public int getEnd_time() {
		return end_time;
	}
	/**
	 * @param i the end_time to set
	 */
	public void setEnd_time(int i) {
		this.end_time = i;
	}
	/**
	 * @return the status
	 */
	public short getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(short status) {
		this.status = status;
	}
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
	 * @return the exec_humidity
	 */
	public int getExec_humidity() {
		return exec_humidity;
	}
	/**
	 * @param exec_humidity the exec_humidity to set
	 */
	public void setExec_humidity(int exec_humidity) {
		this.exec_humidity = exec_humidity;
	}
	

}
