package com.anjoyo.spinner;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private Spinner sp;
	private ArrayAdapter<String> adapter;
	private List<String> lists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sp = (Spinner) findViewById(R.id.sp);
		lists = new ArrayList<String>();
		lists.add("www.baidu.com");
		lists.add("www.google.com");
		lists.add("www.anjoyo.com");
		lists.add("www.wwtliu.com");

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, lists);
		// °ó¶¨adapter
		sp.setAdapter(adapter);
	}

}
