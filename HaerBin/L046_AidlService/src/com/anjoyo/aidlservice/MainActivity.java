package com.anjoyo.aidlservice;

import com.anjoyo.aidlservice.MyService.MyBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		ServiceConnection {

	private Button bindbtn, unbindbtn, getServicebtn, startbtn, stopbtn;
	private Intent intent;
	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindbtn = (Button) findViewById(R.id.bind);
		unbindbtn = (Button) findViewById(R.id.unbind);
		getServicebtn = (Button) findViewById(R.id.getservice);
		startbtn = (Button) findViewById(R.id.start);
		stopbtn = (Button) findViewById(R.id.stop);
		et = (EditText) findViewById(R.id.et);
		bindbtn.setOnClickListener(this);
		unbindbtn.setOnClickListener(this);
		getServicebtn.setOnClickListener(this);
		startbtn.setOnClickListener(this);
		stopbtn.setOnClickListener(this);
		intent = new Intent(this, MyService.class);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bind:
			// ��service
			bindService(intent, this, BIND_AUTO_CREATE);// BIND_AUTO_CREATE:�Զ�����service
			break;

		case R.id.unbind:
			unbindService(this);
			break;
		case R.id.getservice:
			 myService.setJ(et.getText().toString());
			 
			 
//			Toast.makeText(MainActivity.this, "��ǰi=" + myService.getI(),
//					Toast.LENGTH_SHORT).show();
			break;
		case R.id.start:
			startService(intent);

			break;
		case R.id.stop:
			stopService(intent);
			break;
		}
	}

	// @Override
	// protected void onDestroy() {
	// unbindService(this);
	// super.onDestroy();
	// }

	// ������ʱ�򴥷�
	private MyService myService;

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		MyService.MyBinder binder = (MyBinder) service;
		myService = binder.getService();// �õ�һ��Service����
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		// �Զ���������service����ֹͣ��ʱ�򴥷�
	}

}
