package com.anjoyo.gallery;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Gallery;

public class MainActivity extends Activity {

	private Gallery gy;
	private MyAdapter adapter;
	private int imageids[] = { R.drawable.i1, R.drawable.i2, R.drawable.i3,
			R.drawable.i4, R.drawable.im };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gy = (Gallery) findViewById(R.id.gy);
		adapter = new MyAdapter(this, imageids);
		gy.setAdapter(adapter);

	}
}
