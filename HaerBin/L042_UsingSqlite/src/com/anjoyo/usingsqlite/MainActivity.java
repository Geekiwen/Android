package com.anjoyo.usingsqlite;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity implements OnItemClickListener,
		OnItemLongClickListener {

	private MySqlite sqlite;
	private SQLiteDatabase dbWirter, dbReader;
	private SimpleCursorAdapter adapter;
	private EditText name_et, sex_et;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sqlite = new MySqlite(this);
		name_et = (EditText) findViewById(R.id.name_et);
		sex_et = (EditText) findViewById(R.id.sex_et);
		btn = (Button) findViewById(R.id.add_btn);
		dbWirter = sqlite.getWritableDatabase();
		dbReader = sqlite.getReadableDatabase();
		adapter = new SimpleCursorAdapter(this, R.layout.cell, null,
				new String[] { MySqlite.NAME, MySqlite.SEX }, new int[] {
						R.id.name_tv, R.id.sex_tv });
		// 绑定adapter
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);
		getListView().setOnItemLongClickListener(this);
		selectDB();
		// deleteDB();
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				addDB();
				selectDB();
			}
		});

	}

	public void addDB() {

		if (TextUtils.isEmpty(name_et.getText().toString())) {
			Toast.makeText(this, "bunegn weikong", Toast.LENGTH_SHORT).show();
			return;
		}
		if (TextUtils.isEmpty(sex_et.getText().toString())) {
			Toast.makeText(this, "bunegn weikong", Toast.LENGTH_SHORT).show();
			return;
		}
		ContentValues cv = new ContentValues();
		cv.put(MySqlite.NAME, name_et.getText().toString());
		cv.put(MySqlite.SEX, sex_et.getText().toString());
		dbWirter.insert(MySqlite.TABLE_NAME, null, cv);

	}

	public void selectDB() {
		Cursor cursor = dbReader.query(MySqlite.TABLE_NAME, null, null, null,
				null, null, null);
		// 重新适配
		adapter.changeCursor(cursor);
	}

	public void deleteDB() {
		dbWirter.delete(MySqlite.TABLE_NAME, null, null);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Cursor cursor = adapter.getCursor();// 获得游标对象
		cursor.moveToPosition(position);
		int ids = cursor.getInt(cursor.getColumnIndex("_id"));
		System.out.println(ids + ">>>>>>>");

	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		new AlertDialog.Builder(MainActivity.this)
				.setTitle("选项")
				.setItems(new String[] { "删除", "添加", "选择" },
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								switch (which) {
								case 0:
									Toast.makeText(MainActivity.this, "点击了第一项",
											Toast.LENGTH_LONG).show();
									break;

								case 1:

									Toast.makeText(MainActivity.this, "点击了第二项",
											Toast.LENGTH_LONG).show();
									break;
								}
							}
						}).show();
		return true;
	}

}
