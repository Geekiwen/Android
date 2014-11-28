package com.anjoyo.sensorsize;

import java.util.List;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {

	// 得到
	private SensorManager sm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ALL);
		Sensor s;
		for (int i = 0; i < sensors.size(); i++) {
			s = sensors.get(i);
			System.out.println("类型" + s.getType() + "---名字:" + s.getName());
		}
	}

}
