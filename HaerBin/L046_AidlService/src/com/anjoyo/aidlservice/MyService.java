package com.anjoyo.aidlservice;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

	/**
	 * service的第二种生命周期：
	 */

	private Timer timer;
	private TimerTask task;
	private int i = 0;
	private String j = "";
	private String m = "";

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind");
		startTimer();
		return binder;
	}

	private MyBinder binder = new MyBinder();

	// 创建一个IBinder类型的对象
	class MyBinder extends Binder {
		// 得到一个service对象
		public MyService getService() {
			return MyService.this;
		}
	}

	
	@Override
	public void onCreate() {
		System.out.println("onCreate");

		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("onUnbind");
		return true;
	}

	@Override
	public void onRebind(Intent intent) {
		System.out.println("onRebind");
		super.onRebind(intent);
	}

	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		stopTimer();
		super.onDestroy();
	}

	public void startTimer() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				i++;
				m += 1;
				System.out.println(i);
				// System.out.println("我输入的是："+getJ());
				// if (getJ().equals(m)) {
				// System.out.println("xiangang");
				// }
			}
		};
		timer.schedule(task, 1000, 1000);
	}

	public void stopTimer() {
		timer.cancel();
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getJ() {
		return j;
	}

	public void setJ(String j) {
		this.j = j;
	}

}
