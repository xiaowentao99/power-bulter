/**
 * 
 */
package com.bean;

/**
 * @author tjy
 *
 */
public class Device {
	
	private int id;
	private short device_type;//refer the  other Class called DeviceType
	private String desc;
	private short fps_soc;//FPS or SOC
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
	 * @return the device_type
	 */
	public short getDevice_type() {
		return device_type;
	}
	/**
	 * @param device_type the device_type to set
	 */
	public void setDevice_type(short device_type) {
		this.device_type = device_type;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the fps_soc
	 */
	public short getFps_soc() {
		return fps_soc;
	}
	/**
	 * @param fps_soc the fps_soc to set
	 */
	public void setFps_soc(short fps_soc) {
		this.fps_soc = fps_soc;
	}
	
}
