package com.anjoyo.service;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button startbtn, stopbtn;
	private Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startbtn = (Button) findViewById(R.id.start);
		stopbtn = (Button) findViewById(R.id.stop);
		startbtn.setOnClickListener(this);
		stopbtn.setOnClickListener(this);
		i = new Intent(this, MyService.class);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			// 启动service的方法
			startService(i);
			break;

		case R.id.stop:
			// 停止service的方法
			stopService(i);
			break;
		}
	}

}
