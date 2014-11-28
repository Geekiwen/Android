package com.anjoyo.myreceiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private BroadcastReceiver br = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// 比对当前要接收的广播是否一样
//			if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
				int level = intent.getIntExtra("level", 0);// level:系统所提供的得到当前电量的一个键
				int scale = intent.getIntExtra("scale", 100);
				tv.setText(level * 100 / scale + "%");
//			}
		}
	};

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		// 动态注册
		registerReceiver(br, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));// 我们要接收电池电量改变的信息
	}

	@Override
	protected void onStop() {
		super.onStop();
		// 取消注册
		unregisterReceiver(br);
	}
}
