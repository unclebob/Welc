package com.om.scheduler;
import java.util.Date;

public class Event {
	private Date date;
	private int slot;
	
	public Event(Date date, int slot) {
		this.date = date;
		this.slot = slot;
	}
	
	public void added() {
		
	}
	
	public Date getDate() { 
		return date;
	}
	
	public int getSlot() {
		return slot;
	}
	
	public String toString() {
		return date + " @" + slot + ":00 hours";
	}

}

