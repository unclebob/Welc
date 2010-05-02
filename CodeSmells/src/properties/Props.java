package properties;

import java.util.*;

public class Props {
	public void getTimes(Properties props) throws Exception {
		String valueString;
		int value;

		valueString = props.getProperty("interval");
		if (valueString == null) {
			throw new MissingPropertiesException("monitor interval");
		}
		value = Integer.parseInt(valueString);

		if (value <= 0) {
			throw new MissingPropertiesException("monitor interval > 0");
		}
		int checkInterval = value;

		valueString = props.getProperty("duration");
		if (valueString == null) {
			throw new MissingPropertiesException("duration");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new MissingPropertiesException("duration > 0");
		}
		if ((value % checkInterval) != 0) {
			throw new MissingPropertiesException("duration % checkInterval");
		}
		//int monitorTime = value;

		valueString = props.getProperty("departure");
		if (valueString == null) {
			throw new MissingPropertiesException("departure offset");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new MissingPropertiesException("departure > 0");
		}
		if ((value % checkInterval) != 0) {
			throw new MissingPropertiesException("departure % checkInterval");
		}
		//int departureOffset = value;
	}
}
