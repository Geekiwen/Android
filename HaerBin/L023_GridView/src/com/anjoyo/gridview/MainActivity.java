package com.anjoyo.gridview;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	private GridView gv;
	private SimpleAdapter adapter;
	private int imageids[] = { R.drawable.item1, R.drawable.item2,
			R.drawable.item3, R.drawable.item4, R.drawable.item5,
			R.drawable.item6, R.drawable.item7, R.drawable.item8,
			R.drawable.item9, R.drawable.item10, R.drawable.item11,
			R.drawable.item12, R.drawable.item13, R.drawable.item14,
			R.drawable.item15 };
	private String data[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15" };
	private List<Map<String, Object>> lists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gv = (GridView) findViewById(R.id.gridView1);
		lists = new ArrayList<Map<String, Object>>();
		Map<String, Object> maps;
		for (int i = 0; i < imageids.length; i++) {
			maps = new Hashtable<String, Object>();
			maps.put("image", imageids[i]);
			maps.put("data", data[i]);
			lists.add(maps);
		}

		adapter = new SimpleAdapter(this, lists, R.layout.cell, new String[] {
				"image", "data" },
				new int[] { R.id.imageView1, R.id.textView1 });
		gv.setAdapter(adapter);

		// 点击事件
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Toast.makeText(MainActivity.this, "当前点击了" + position + "数据",
						Toast.LENGTH_LONG).show();

			}
		});

	}
}
