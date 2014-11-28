package com.anjoyo.listviewanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;
	private ArrayAdapter<String> adapter;
	private String data[] = { "1", "2", "3" };
	private RotateAnimation ra = new RotateAnimation(0, 360, 0.5f, 0.5f);
	private AlphaAnimation aa = new AlphaAnimation(1, 0);
	private LayoutAnimationController controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data);
		lv.setAdapter(adapter);
		ra.setDuration(1000);
		aa.setDuration(1000);
		//  π”√
		controller = new LayoutAnimationController(aa);
		// …Ë÷√
		controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
		lv.setLayoutAnimation(controller);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				lv.startLayoutAnimation();
			}
		});

	}

}
