package com.anjoyo.activitygroup;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends ActivityGroup implements OnClickListener {

	private Button btn1, btn2, btn3;
	private View view1 = null;
	private View view2 = null;
	private View view3 = null;
	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		layout = (LinearLayout) findViewById(R.id.layout);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			// 独立view
			layout.removeAllViews();
			if (view1 == null) {
				view1 = getLocalActivityManager().startActivity("view1",
						new Intent(MainActivity.this, Act1.class))
						.getDecorView();
				// 设置
				view1.setLayoutParams(pa());
				layout.addView(view1);
			} else {
				layout.addView(view1);
			}
			break;

		case R.id.button2:
			layout.removeAllViews();
			if (view2 == null) {
				view2 = getLocalActivityManager().startActivity("view2",
						new Intent(MainActivity.this, Act2.class))
						.getDecorView();
				// 设置
				view2.setLayoutParams(pa());
				layout.addView(view2);
			} else {
				layout.addView(view2);
			}
			break;

		case R.id.button3:
			layout.removeAllViews();
			if (view3 == null) {
				view3 = getLocalActivityManager().startActivity("view3",
						new Intent(MainActivity.this, Act3.class))
						.getDecorView();
				// 设置
				view3.setLayoutParams(pa());
				layout.addView(view3);
			} else {
				layout.addView(view3);
			}
			break;
		}
	}

	public LayoutParams pa() {
		LayoutParams params = new LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT);
		return params;
	}

}
