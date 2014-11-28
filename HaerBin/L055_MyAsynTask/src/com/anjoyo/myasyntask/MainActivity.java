package com.anjoyo.myasyntask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button btn1, btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button) findViewById(R.id.start);
		btn2 = (Button) findViewById(R.id.pritln);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			MyAsynTask myAsynTask = new MyAsynTask();
			myAsynTask.execute();// 启动AsynTask
			break;

		case R.id.pritln:
			System.out.println("大家好");
			break;
		}
	}

}
