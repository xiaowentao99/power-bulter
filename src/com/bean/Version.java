/**
 * 
 */
package com.bean;

/**
 * @author tjy
 *
 */
public class Version {
	
	private int hardware_main;
	private int hardware_sub;
	private int software_main;
	private int sotfware_sub;
	private String ID;
	private String ip;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the hardware_main
	 */
	public int getHardware_main() {
		return hardware_main;
	}
	/**
	 * @param hardware_main the hardware_main to set
	 */
	public void setHardware_main(int hardware_main) {
		this.hardware_main = hardware_main;
	}
	/**
	 * @return the hardware_sub
	 */
	public int getHardware_sub() {
		return hardware_sub;
	}
	/**
	 * @param hardware_sub the hardware_sub to set
	 */
	public void setHardware_sub(int hardware_sub) {
		this.hardware_sub = hardware_sub;
	}
	/**
	 * @return the software_main
	 */
	public int getSoftware_main() {
		return software_main;
	}
	/**
	 * @param software_main the software_main to set
	 */
	public void setSoftware_main(int software_main) {
		this.software_main = software_main;
	}
	/**
	 * @return the sotfware_sub
	 */
	public int getSotfware_sub() {
		return sotfware_sub;
	}
	/**
	 * @param sotfware_sub the sotfware_sub to set
	 */
	public void setSotfware_sub(int sotfware_sub) {
		this.sotfware_sub = sotfware_sub;
	}
	

}
