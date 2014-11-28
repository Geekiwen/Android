package com.anjoyo.l052_handler;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button startbtn, stopbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startbtn = (Button) findViewById(R.id.start);
		stopbtn = (Button) findViewById(R.id.stop);
		startbtn.setOnClickListener(this);
		stopbtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			// ͨ��handler�������߳�
			handler.post(runnable);
			break;

		case R.id.stop:
			// �Ƴ��̶߳���
			handler.removeCallbacks(runnable);
			break;
		}
	}

	// ����handler
	private Handler handler = new Handler();
	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			System.out.println("�������߳�");
			handler.postDelayed(runnable, 1000);
		}
	};

}
