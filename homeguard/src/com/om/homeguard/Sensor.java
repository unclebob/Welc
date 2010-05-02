package com.om.homeguard;

public class Sensor
{
	public static final String DOOR = "door";
	public static final String MOTION = "motion";
	public static final String WINDOW = "window";
	public static final String FIRE = "fire";

	private String id;
	private String location;
	private String type;
	private boolean tripped = false;

	public Sensor(String id, String location, String type)
	{
		this.id = id;
		this.location = location;
		this.type = type;
	}

	public String getId()
	{
		return id;
	}

	public String getType()
	{
		return type;
	}

	public String getLocation()
	{
		return location;
	}

	public void trip()
	{
		tripped = true;
	}

	public void reset()
	{
		tripped = false;
	}

	public boolean isTripped()
	{
		return tripped;
	}
}
