package com.om.homeguard;

public class MockView implements HomeGuardView
{
	public String lastMessage;

	public void showMessage(String message)
	{
		lastMessage = message;
	}
}
