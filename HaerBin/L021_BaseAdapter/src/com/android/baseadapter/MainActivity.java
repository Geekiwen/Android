package com.android.baseadapter;

import com.anjoyo.adapter.MyAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;
	private MyAdapter adapter;
	private String data[] = { "张三", "李四", "王五" };
	private int image[] = { R.drawable.i1, R.drawable.i2, R.drawable.i3 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);
		adapter = new MyAdapter(this, data, image);
		lv.setAdapter(adapter);
	}

}
