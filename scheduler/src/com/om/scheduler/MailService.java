package com.om.scheduler;

public class MailService {
	private static MailService instance;
	
    private MailService() {
    }
    
    public static MailService getInstance() {
        if (instance == null)
        	instance = new MailService();
        return instance;
    }
    
	public void sendMail(String address, String subject, String message) {
		// this method really sends mail
	}
}
