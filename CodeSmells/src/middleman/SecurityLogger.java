package middleman;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecurityLogger {
		private PrintStream stream;
		
		public SecurityLogger(PrintStream stream) {
			this.stream = stream;
		}
		
		public void logStatuses(List<SecuredDoor> securedItems) throws IOException {
			for(Iterator<SecuredDoor> it = securedItems.iterator(); it.hasNext(); ) {
				SecurableItem item = it.next();
				
				stream.println("item name: " + item.getLocationName());
				stream.println("auto trigger?: " + item.getSensor().getSettings().isAutoTriggered());
				stream.println("det. delay: " + item.getSensor().getSettings().getDetectionDelay() + " seconds");
				
			}	
		}
		
		
		private static List<SecuredDoor> getItems() {
			List<SecuredDoor> items = new ArrayList<SecuredDoor>();
			items.add(new SecuredDoor("front door"));
			return items;
		}
		
		public static void main(String [] args) {
			try {
				new SecurityLogger(System.out).logStatuses(getItems());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}				
	}
