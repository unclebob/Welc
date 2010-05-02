package com.om.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Scheduler {
	private String owner = "";
	private MailService mailService;
	private SchedulerDisplay display;
	private List<Event> events = new ArrayList<Event>();

	public Scheduler(String owner) {
		this.owner = owner;

		mailService = MailService.getInstance();
		display = new SchedulerDisplay();
	}

	public void addEvent(Event event) {
		event.added();
		events.add(event);
		mailService.sendMail("jacques@spg1.com", "Event Notification", event
				.toString());
		display.showEvent(event);
	}

	public boolean hasEvents(Date date) {
		for (Iterator<Event> it = events.iterator(); it.hasNext();) {
			Event event = it.next();
			if (event.getDate().equals(date))
				return true;
		}
		return false;
	}
	
	public String getOwner() {
		return owner;
	}

	public void performConsistencyCheck(StringBuffer message) {
	}

	public void update() {
		for (Iterator<Event> it = events.iterator(); it.hasNext();) {
			Event event = it.next();

			if (!(event instanceof Meeting)) {
				continue;
			}

			Meeting meeting = (Meeting) event;

			String note = NoteRetriever.get_note(meeting.getDate());
			if (note.length() == 0)
				continue;

			meeting.appendToText(note);
		}
	}

	public Meeting getMeeting(Date date, int slot) {
		for (Iterator<Event> it = events.iterator(); it.hasNext();) {
			Event event = it.next();
			if (!(event instanceof Meeting))
				continue;
			Meeting meeting = (Meeting) event;
			if (meeting.getDate().equals(date) && meeting.getSlot() == slot
					&& !TimeServices.isHoliday(meeting.getDate()))
				return meeting;

		}
		return null;
	}
}
