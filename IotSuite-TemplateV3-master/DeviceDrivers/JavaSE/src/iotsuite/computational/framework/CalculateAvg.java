package iotsuite.computational.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

<<<<<<< HEAD
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

=======
>>>>>>> 5dcfd9395670f7a8c0c2bcc258a72a7d4664e14d
import iotsuite.localmiddleware.IDataListener;
import iotsuite.localmiddleware.PubSubsSensingFramework;
import framework.*;

public class CalculateAvg implements IDataListener {

	private PubSubsSensingFramework pubSubSensingFramework = null;

	final List<Double> temps = Collections
			.synchronizedList(new ArrayList<Double>());
	private double currentAverage;
	private int numSample = 0;
<<<<<<< HEAD
	static  int NUM_SAMPLE_FOR_AVG;
	
=======
	private final int NUM_SAMPLE_FOR_AVG = 3;
>>>>>>> 5dcfd9395670f7a8c0c2bcc258a72a7d4664e14d

	public CalculateAvg() {
		pubSubSensingFramework = PubSubsSensingFramework.getInstance();
		pubSubSensingFramework.registerForSensorData(this, "AVG-REQUEST");
	}

	@Override
<<<<<<< HEAD
	public void onDataReceived(String eventName, JSONArray data) {

		//  Unwrapping is performed here

		JSONObject obj = new JSONObject();
		double value = 0;
		String unitOfMeasurement = null;
		try {
			obj=data.getJSONObject(0);
			value = obj.getDouble("tempValue");
			unitOfMeasurement=obj.getString("unitOfMeasurement");
			NUM_SAMPLE_FOR_AVG=obj.getInt("sampleValue");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is " +e.getMessage());
		}
	
=======
	public void onDataReceived(String eventName, Object data) {

		TempStruct arg = (TempStruct) data;

>>>>>>> 5dcfd9395670f7a8c0c2bcc258a72a7d4664e14d
		synchronized (this.temps) {
			numSample = numSample + 1;
			if (numSample <= NUM_SAMPLE_FOR_AVG) {
				// Handling of temperature Value with different unit.
<<<<<<< HEAD
				if (unitOfMeasurement.equals("F")) {
					double convertToCelcius = (value - 32)
							* (5 / 9);
					temps.add(convertToCelcius);
				} else {
					temps.add(value);
=======
				if (arg.getunitOfMeasurement().equals("F")) {
					double convertToCelcius = (arg.gettempValue() - 32)
							* (5 / 9);
					temps.add(convertToCelcius);
				} else {
					temps.add(arg.gettempValue());
>>>>>>> 5dcfd9395670f7a8c0c2bcc258a72a7d4664e14d
				}
				currentAverage = 0;
				for (Double temp : temps) {
					currentAverage += temp;
				}
				currentAverage /= temps.size();

			}

			if (numSample == NUM_SAMPLE_FOR_AVG) {
				numSample = 0;

<<<<<<< HEAD
				 JSONObject jsonObj = new JSONObject();
				 
						try {
							obj.put("tempValue",currentAverage);
							obj.put("unitOfMeasurement", "C");
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							System.out.println("Exception is " +e.getMessage());
						}
						
				 JSONArray publishData = new JSONArray();
	             publishData.put(jsonObj);
				pubSubSensingFramework
						.publish("AVG-RESULT", publishData);
=======
				TempStruct avgTempMeasurement = new TempStruct(currentAverage,
						"C");

				pubSubSensingFramework
						.publish("AVG-RESULT", avgTempMeasurement);
>>>>>>> 5dcfd9395670f7a8c0c2bcc258a72a7d4664e14d

			}

		}

	}

}