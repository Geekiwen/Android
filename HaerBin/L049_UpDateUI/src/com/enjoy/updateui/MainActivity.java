package com.enjoy.updateui;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private BroadcastReceiver br = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			int val = intent.getIntExtra("name", 0);
			tv.setText(val + "");
		}
	};

	private Button startbtn, stopbtn;
	private TextView tv;
	private Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ¶¯Ì¬×¢²á
		registerReceiver(br, new IntentFilter("Action1"));
		startbtn = (Button) findViewById(R.id.start);
		stopbtn = (Button) findViewById(R.id.stop);
		tv = (TextView) findViewById(R.id.tv);
		startbtn.setOnClickListener(this);
		stopbtn.setOnClickListener(this);
		i = new Intent(MainActivity.this, MyService.class);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			startService(i);
			break;

		case R.id.stop:
			stopService(i);
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(br);// È¡Ïû×¢²á
	}

}
