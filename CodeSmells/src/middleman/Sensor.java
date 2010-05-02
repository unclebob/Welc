package middleman;

public class Sensor {

	private SensorSettings settings = new SensorSettings();
	
	public String getStatus() {
		return settings.isAutoTriggered() ? "auto-triggered" : "manually-triggered";
	}
	
	public SensorSettings getSettings() {
		return settings;
	}

}
