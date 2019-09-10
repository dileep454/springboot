package com.dbs.hack2hire.hack2hiredbfx.model;

import java.io.Serializable;

public class NotificationRequest  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String to;
	private Object data;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	

}
