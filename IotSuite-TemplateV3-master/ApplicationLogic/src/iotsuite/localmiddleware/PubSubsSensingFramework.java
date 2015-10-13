package iotsuite.localmiddleware;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

<<<<<<< HEAD
import org.json.JSONArray;

=======
>>>>>>> 5dcfd9395670f7a8c0c2bcc258a72a7d4664e14d
import com.google.gson.JsonObject;

public class PubSubsSensingFramework {

	private Map<String, Set<IDataListener>> subscriberMap = new Hashtable<String, Set<IDataListener>>();

	static PubSubsSensingFramework singletonInstance;

	public static PubSubsSensingFramework getInstance() {

		if (singletonInstance == null) {
			singletonInstance = new PubSubsSensingFramework();
		}

		return singletonInstance;

	}

	/*
	 * Data consumer implements this interface.
	 */

	public void registerForSensorData(IDataListener s, String eventSignature) {

		registerNewSubscriber(s, eventSignature);
	}

	private void registerNewSubscriber(IDataListener s, String eSig) {

		// create Map by EventName

		if (subscriberMap.containsKey(eSig)) {

			Set<IDataListener> tempSet = subscriberMap.get(eSig);
			tempSet.add(s);
		} else {
			Set<IDataListener> newSet = new HashSet<IDataListener>();
			newSet.add(s);
			subscriberMap.put(eSig, newSet);

		}

	}

	/*
	 * Data producer implements this interface.
	 */

	// public void publish(String eventName, JsonObject dataEvent) {
<<<<<<< HEAD
	public void publish(String eventName, JSONArray data) {
=======
	public void publish(String eventName, Object data) {
>>>>>>> 5dcfd9395670f7a8c0c2bcc258a72a7d4664e14d

		Set<IDataListener> subscriberEventSet = getSubscribersForEvent(eventName);

		if (subscriberEventSet != null) {
			for (IDataListener s : subscriberEventSet) {
				// s.onDataReceived(eventName, dataEvent);
				s.onDataReceived(eventName, data);
			}
		}

	}

	private Set<IDataListener> getSubscribersForEvent(String eventName) {

		return subscriberMap.get(eventName);
	}

}
