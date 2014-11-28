package com.anjoyo.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {

	/**
	 * adapter:适配器 c(控制器) adapterView:适配器控件（高级控件）（listView） v（视图） data：数据源
	 * M（数据模型）
	 */
	private ListView lv;
	private ArrayAdapter<String> adapter;
	private String data[] = { "张三", "李四", "王五" };
	private List<String> lists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);
		// 实现adapter
		lists = new ArrayList<String>();
		lists.add("3");
		lists.add("2");
		lists.add("1");
		adapter = new ArrayAdapter<String>(this, R.layout.cell, lists);
		// 绑定listView

		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		lists.remove(position);
		adapter.notifyDataSetChanged();
	}

}
