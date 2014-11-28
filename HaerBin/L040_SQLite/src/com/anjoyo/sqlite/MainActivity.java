package com.anjoyo.sqlite;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

	private MySQLite sqLite;
	private SQLiteDatabase dbWriter;
	private SQLiteDatabase dbReader;
	private SimpleCursorAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sqLite = new MySQLite(this);
		dbWriter = sqLite.getWritableDatabase();// ʵ�����ݿ�Ŀ�дȨ��
		dbReader = sqLite.getReadableDatabase();// ʵ�����ݿ�Ŀɶ�Ȩ��
		// addDB();
		// updateDB();
		adapter = new SimpleCursorAdapter(this, R.layout.cell, null,
				new String[] { "title", "content" }, new int[] { R.id.tv1,
						R.id.tv2 });
		setListAdapter(adapter);
		addDB();
		selectDB();
	}

	public void addDB() {
		// contentvaluse
		ContentValues cv = new ContentValues();//����ͨ���˷��������������
		cv.put("title", "Helloword111");
		cv.put("content", "��ӭ���111");
		dbWriter.insert("user", null, cv);// ���뵽���ݿ�
	}

	public void updateDB() {
		ContentValues cv = new ContentValues();
		cv.put("title", "Hello");
		cv.put("content", "��Һ�");
		dbWriter.update("user", cv, "_id=3", null);
	}

	public void deleteDB() {
		dbWriter.delete("user", "_id=4", null);
	}

	public void selectDB() {
		// Cursor
		Cursor cursor = dbReader.query("user", null, null, null, null, null,
				null);
		
		
		// ��������
		adapter.changeCursor(cursor);
//
		while (cursor.moveToNext()) {
			System.out
					.println(cursor.getString(cursor.getColumnIndex("title")));
			System.out.println(cursor.getString(cursor
					.getColumnIndex("content")));
		}
	}

}
