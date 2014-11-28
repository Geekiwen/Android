package com.anjoyo.service;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

	/**
	 * service的生命周期有2种：不交互：onCreate()---onStartCommand---onDestroy()
	 */

	private int i = 0;

	private Timer timer;
	private TimerTask task;

	// 与应用程序交互使用
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		System.out.println("onCreate");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand");
		startTimer();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		stopTimer();
		System.out.println("onDestroy");
	}

	public void startTimer() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				i++;
				System.out.println(i);
			}
		};
		timer.schedule(task, 1000, 1000);// 启动timer
	}

	public void stopTimer() {
		timer.cancel();
	}

}
