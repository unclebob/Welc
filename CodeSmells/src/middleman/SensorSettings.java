package middleman;

public class SensorSettings {
	
	public static final int DEFAULT_DETECTION_DELAY = 90;
	
	private Zone detectionZone = new Zone();
	private boolean isAutoTriggered = true;
	private int detectionDelay = DEFAULT_DETECTION_DELAY;
	
	public void setZone(Zone newZone) {
		detectionZone = newZone;
	}
	
	public Zone getZone() {
		return detectionZone;
	}
	
	public void beAutoTriggered() {
		isAutoTriggered = true;
	}
	
	public void beManuallyTriggered() {
		isAutoTriggered = false;
	}

	public boolean isAutoTriggered() {
		return isAutoTriggered;
	}
	
	public void setDetectionDelay(int seconds) {
		detectionDelay = seconds;
	}
	
	public int getDetectionDelay() {
		return detectionDelay;
	}
}
