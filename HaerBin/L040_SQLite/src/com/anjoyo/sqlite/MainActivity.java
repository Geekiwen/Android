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
		dbWriter = sqLite.getWritableDatabase();// 实现数据库的可写权限
		dbReader = sqLite.getReadableDatabase();// 实现数据库的可读权限
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
		ContentValues cv = new ContentValues();//必须通过此方法进行添加数据
		cv.put("title", "Helloword111");
		cv.put("content", "欢迎大家111");
		dbWriter.insert("user", null, cv);// 插入到数据库
	}

	public void updateDB() {
		ContentValues cv = new ContentValues();
		cv.put("title", "Hello");
		cv.put("content", "大家好");
		dbWriter.update("user", cv, "_id=3", null);
	}

	public void deleteDB() {
		dbWriter.delete("user", "_id=4", null);
	}

	public void selectDB() {
		// Cursor
		Cursor cursor = dbReader.query("user", null, null, null, null, null,
				null);
		
		
		// 重新适配
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
