package com.anjoyo.contentprovider;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addDB();
		selectDB();
	}

	public void addDB() {
		ContentValues cv = new ContentValues();
		cv.put(MyCP.CP_TITLE, "HelloWord");
		// MainActivity.this.getContentResolver();
		getContentResolver().insert(MyCP.URI, cv);
	}

	public void selectDB() {
		Cursor cursor = getContentResolver().query(MyCP.URI, null, null, null,
				null);
		while (cursor.moveToNext()) {

			System.out.println(cursor.getString(cursor
					.getColumnIndex(MyCP.CP_TITLE)));
		}
	}

}
