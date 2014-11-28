package com.anjoyo.usinghandler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private Button btn;
	private ProgressBar pbBar;
	private int i = 0;

	// private MyThread myThread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// myThread = new MyThread();
		btn = (Button) findViewById(R.id.start);
		pbBar = (ProgressBar) findViewById(R.id.progressBar1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				handler.post(runnable);
				// myThread.start();
			}
		});
	}

	private Handler handler = new Handler() {
		// handler������Ϣ
		public void handleMessage(Message msg) {
			// ����progressBar
			pbBar.setProgress(msg.arg1);
			handler.post(runnable);
			if (msg.arg1 == 80) {
				handler.removeCallbacks(runnable);
			}
		};

	};

	Runnable runnable = new Runnable() {// ֻ����һ��

		@Override
		public void run() {
			i += 10;
			// ����Message��������������Ϣ
//			Message message = new Message();//
			Message message = handler.obtainMessage();//�õ�Message����
			message.arg1 = i; // {message.age1=10,message.arg1=20}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
			// ������Ϣ
			handler.sendMessage(message);
		}
	};

	// private class MyThread extends Thread {
	//
	// int i = 0;
	//
	// @Override
	// public void run() {
	// i += 10;
	// // // ����Message��������������Ϣ
	// Message message = new Message();
	// message.arg1 = i; // {message.age1=10,message.arg1=20}
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// System.out.println(i);
	// // ������Ϣ
	// handler.sendMessage(message);
	// super.run();
	// }
	// }

}
