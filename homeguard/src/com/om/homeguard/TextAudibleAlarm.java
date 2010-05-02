package com.om.homeguard;

public class TextAudibleAlarm implements AudibleAlarm
{
	private boolean isOn = false;

	public void sound()
	{
		isOn = true;
		while(isOn)
		{
			System.out.println("BUZZ BUZZ BUZZ!!!");
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void silence()
	{
		isOn = false;
	}
}
