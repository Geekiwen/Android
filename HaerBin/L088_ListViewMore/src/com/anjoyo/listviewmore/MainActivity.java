package com.anjoyo.listviewmore;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;
	private ArrayAdapter<String> adapter;
	private List<String> lists;
	private View foot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		lists = new ArrayList<String>();
		foot = getLayoutInflater().inflate(R.layout.list_more, null);
		lv.addFooterView(foot);
		addData();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lists);
		lv.setAdapter(adapter);
		foot.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				addData();
				adapter.notifyDataSetChanged();// 重新适配
			}
		});
	}

	public void addData() {
		for (int i = 0; i < 10; i++) {
			lists.add("当前是第：" + i);
		}
	}

}
