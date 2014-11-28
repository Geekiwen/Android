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
	 * adapter:������ c(������) adapterView:�������ؼ����߼��ؼ�����listView�� v����ͼ�� data������Դ
	 * M������ģ�ͣ�
	 */
	private ListView lv;
	private ArrayAdapter<String> adapter;
	private String data[] = { "����", "����", "����" };
	private List<String> lists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);
		// ʵ��adapter
		lists = new ArrayList<String>();
		lists.add("3");
		lists.add("2");
		lists.add("1");
		adapter = new ArrayAdapter<String>(this, R.layout.cell, lists);
		// ��listView

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
