package com.anjoyo.usingcp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		selectDB();
	}

	public void selectDB() {
		Cursor cursor = getContentResolver().query(
				Uri.parse("content://com.anjoyo.contentprovider.MyCP"), null,
				null, null, null);
		while (cursor.moveToNext()) {

			System.out
					.println(cursor.getString(cursor.getColumnIndex("title")));
		}
	}

}
