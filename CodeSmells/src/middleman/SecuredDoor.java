package middleman;

public class SecuredDoor extends SecurableItem {

	private Sensor sensor = new Sensor();
	private String location;

	public SecuredDoor(String location) {
		this.location = location;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public String getLocationName() {
		return location;
	}

}
