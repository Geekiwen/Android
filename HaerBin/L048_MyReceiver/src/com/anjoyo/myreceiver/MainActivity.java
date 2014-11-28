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
			// �ȶԵ�ǰҪ���յĹ㲥�Ƿ�һ��
//			if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
				int level = intent.getIntExtra("level", 0);// level:ϵͳ���ṩ�ĵõ���ǰ������һ����
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
		// ��̬ע��
		registerReceiver(br, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));// ����Ҫ���յ�ص����ı����Ϣ
	}

	@Override
	protected void onStop() {
		super.onStop();
		// ȡ��ע��
		unregisterReceiver(br);
	}
}
