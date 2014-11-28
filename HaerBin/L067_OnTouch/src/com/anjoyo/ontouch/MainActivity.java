package com.anjoyo.ontouch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener {

	private RelativeLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout = (RelativeLayout) findViewById(R.id.layout);
		layout.setOnTouchListener(this);// 设置监听事件
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Toast.makeText(this, event.getX() + "---" + event.getY(),
					Toast.LENGTH_LONG).show();
			break;

		case MotionEvent.ACTION_MOVE:
			System.out.println(event.getX() + "---" + event.getY());
			break;
		case MotionEvent.ACTION_UP:
			System.out.println(event.getX() + "Up事件" + event.getY());
			break;
		}
		return true;
	}
}
