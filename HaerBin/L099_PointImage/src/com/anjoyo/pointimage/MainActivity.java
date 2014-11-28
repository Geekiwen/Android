package com.anjoyo.pointimage;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends Activity implements OnTouchListener {

	private ImageView iv;
	private RelativeLayout layout;
	private RelativeLayout.LayoutParams rl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.imageView1);
		layout = (RelativeLayout) findViewById(R.id.layout);
		layout.setOnTouchListener(this);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			rl = (LayoutParams) iv.getLayoutParams();
			rl.leftMargin = (int) event.getX();
			rl.topMargin = (int) event.getY();
			iv.setLayoutParams(rl);
		}
		return true;
	}

}
