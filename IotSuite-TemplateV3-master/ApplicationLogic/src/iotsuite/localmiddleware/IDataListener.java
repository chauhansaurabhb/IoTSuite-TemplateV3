package iotsuite.localmiddleware;

<<<<<<< HEAD
import org.json.JSONArray;

public interface IDataListener {
	// public abstract void onDataReceived(String eventName, JsonObject
	// dataEvent);
	public abstract void onDataReceived(String eventName, JSONArray data);
=======
public interface IDataListener {
	// public abstract void onDataReceived(String eventName, JsonObject
	// dataEvent);
	public abstract void onDataReceived(String eventName, Object data);
>>>>>>> 5dcfd9395670f7a8c0c2bcc258a72a7d4664e14d

}
