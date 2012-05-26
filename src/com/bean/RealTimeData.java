/**
 * 
 */
package com.bean;

import java.sql.Time;

/**
 * @author tjy
 *
 */
public class RealTimeData {
	private int id;
	private long time_s;
	private int dev_id;
	private String dev_name;
	private short data_type;//it shows it is temperature/shidu/power-loss
	private float sample_data;
	public long getTime_s() {
		return time_s;
	}
	public void setTime_s(long time_s) {
		this.time_s = time_s;
	}
	public short getData_type() {
		return data_type;
	}
	public void setData_type(short data_type) {
		this.data_type = data_type;
	}
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
	 * @return the time
	 */

	/**
	 * @return the dev_id
	 */
	public int getDev_id() {
		return dev_id;
	}
	/**
	 * @param dev_id the dev_id to set
	 */
	public void setDev_id(int dev_id) {
		this.dev_id = dev_id;
	}
	/**
	 * @return the dev_name
	 */
	public String getDev_name() {
		return dev_name;
	}
	/**
	 * @param dev_name the dev_name to set
	 */
	public void setDev_name(String dev_name) {
		this.dev_name = dev_name;
	}
	/**
	 * @return the sample_data
	 */
	public float getSample_data() {
		return sample_data;
	}
	/**
	 * @param sample_data the sample_data to set
	 */
	public void setSample_data(float sample_data) {
		this.sample_data = sample_data;
	}
	
}
