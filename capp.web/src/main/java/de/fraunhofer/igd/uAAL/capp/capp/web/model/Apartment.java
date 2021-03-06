package de.fraunhofer.igd.uAAL.capp.capp.web.model;

import java.util.ArrayList;

public class Apartment {
	protected String name;
	protected String ipAdress;
	protected ArrayList<String> deviceList;
	protected boolean available;
	protected String errorCode;
	

	public Apartment(){
		
	}
	
	public Apartment(String name, String ipAdress){
		this.name = name;
		this.ipAdress = ipAdress;
		this.available = true;
		this.errorCode = "";
		this.deviceList = new ArrayList<>();
		
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public ArrayList<String> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(ArrayList<String> deviceList) {
		this.deviceList = deviceList;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public void setNotAvailable(String errorCode){
		this.available = false;
		this.errorCode = errorCode;
	}
	
	

}
