package com.om.scheduler;
import java.util.Date;

public class Meeting extends Event {
	
	private String description;
	
	public Meeting(Date date, int slot, String description) {
		super(date, slot);
		this.description = description;
	}

	public String getText() {
		return description;
	}

	public boolean isPastDue() {
		return TimeServices.isPastDue(getDate());
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		int n = 0;
		buffer.append(super.toString());
		String result = formatText(description);
		buffer.append("[" + result.length());
		for(n = 0; n < result.length(); n++) {
			buffer.append("{");			
		}
		buffer.append(formatText(description));
		for(n = 0; n < result.length(); n++) {
			buffer.append("}");			
		}		
		buffer.append(result.length() + "]");
		return new String(result);
		
	}

  

    public void appendToText(String newText)
	{
		description += newText;
	}


	private String formatText(String text) 
	{
		StringBuffer result = new StringBuffer();
		for (int n = 0; n < text.length(); ++n) {
			int c = text.charAt(n);
			if (c == '<') {
				while(text.charAt(n) != '/' && text.charAt(n) != '>')
					n++;
				if (text.charAt(n) == '/')
					n+=4;
				else
					n++;
			}
			if (n < text.length())
				result.append(text.charAt(n));
		}
		return new String(result);
	}

}
