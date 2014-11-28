package com.anjoyo.compass;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager sm;
	private Sensor s;
	private MyAnimation animation;
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		s = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		iv = (ImageView) findViewById(R.id.imageView1);
		animation = new MyAnimation();
		animation.setDuration(3000);
		animation.setFillAfter(true);

	}

	@Override
	protected void onResume() {
		sm.registerListener(this, s, SensorManager.SENSOR_DELAY_GAME);
		super.onResume();
	}

	@Override
	protected void onStop() {
		sm.unregisterListener(this);
		super.onStop();
	}

	float startDegress;

	@Override
	public void onSensorChanged(SensorEvent event) {
		float stopDegress = -event.values[0];
		if (startDegress == stopDegress) {
			return;
		}
		iv.setAnimation(null);
		animation.setStartposition(startDegress);
		animation.setStopposition(stopDegress);
		iv.startAnimation(animation);
		startDegress = stopDegress;
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

}
