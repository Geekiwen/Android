package com.anjoyo.imageview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv;
	private int imageids[] = { R.drawable.i1, R.drawable.i2, R.drawable.i3,
			R.drawable.i4, R.drawable.i5, R.drawable.i6 };
	private int i = 0;
	private ImageButton ib;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.iv);
		iv.setBackgroundResource(R.drawable.i1);
		// ∏¯imageview…Ë÷√±≥æ∞Õº∆¨
//		iv.setImageResource(R.drawable.i1);
		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				i++;
				if (i == imageids.length) {
					i = 0;
				}
				iv.setBackgroundResource(imageids[i]);
			}
		});
	}

}
