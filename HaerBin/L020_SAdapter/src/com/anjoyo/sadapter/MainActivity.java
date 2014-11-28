package com.anjoyo.sadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView lv;
	private SimpleAdapter adapter;
	// private String data[] ={"����","����","����"};
	private List<Map<String, Object>> lists;
	private TextView tv;
	private int imageids[] = { R.drawable.i1, R.drawable.i2, R.drawable.i3,
			R.drawable.i4, R.drawable.i5, R.drawable.i6 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lv = (ListView) findViewById(R.id.lv);
		tv = (TextView) findViewById(R.id.tv);
		tv.setText("������listViewЧ��");
		
		// �������������
		lists = new ArrayList<Map<String, Object>>();
		Map<String, Object> maps;
		for (int i = 0; i < imageids.length; i++) {
			maps = new HashMap<String, Object>();
			maps.put("datas", "��ǰ�ǵ�" + i + "����");
			maps.put("image", imageids[i]);
			lists.add(maps);
		}

		// ʵ����adapter
		adapter = new SimpleAdapter(this, lists, R.layout.cell, new String[] {
				"datas", "image" }, new int[] { R.id.tv, R.id.imageView1 });
		// ��adapter
		lv.setAdapter(adapter);

		// listView����¼�
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "�ף���ǰ������˵�" + position + "��",
						Toast.LENGTH_SHORT).show();

			}
		});

		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this,
						"��,���ǳ�������¼�����ǰ������˵�" + position + "��",
						Toast.LENGTH_SHORT).show();
				return true;
			}
		});
	}
}
