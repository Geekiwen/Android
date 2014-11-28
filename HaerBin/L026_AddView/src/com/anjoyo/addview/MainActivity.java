package com.anjoyo.addview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private LinearLayout layout;
	private View viewdemo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		layout = (LinearLayout) findViewById(R.id.layout);

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				viewdemo();
			}
		});
	}

	public void viewdemo() {

		LayoutInflater lf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		viewdemo = (LinearLayout) lf.inflate(R.layout.cell, null);
		layout.addView(viewdemo);
		// layout.removeView(view)
	}

}
