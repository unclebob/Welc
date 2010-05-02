package middleman;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SecuredDoorTest {
	@Test
	public void testAccessPage() {
		SecuredDoor door = new SecuredDoor("front door");
		Sensor sensor = door.getSensor();
		assertEquals("auto-triggered", sensor.getStatus());
	}
}
