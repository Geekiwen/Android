package com.enjoy.updateui;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

	private Timer timer;
	private TimerTask task;
	private int j = 0;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		startTimer();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		stopTimer();
		super.onDestroy();
	}

	public void startTimer() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				j++;

				Intent i = new Intent();
				i.setAction("Action1");
				i.putExtra("name", j);
				sendBroadcast(i);
			}
		};
		timer.schedule(task, 1000, 1000);
	}

	public void stopTimer() {
		timer.cancel();
	}
}
