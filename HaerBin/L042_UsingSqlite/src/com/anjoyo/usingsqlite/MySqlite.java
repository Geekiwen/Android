package com.anjoyo.usingsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlite extends SQLiteOpenHelper {
	public static final String TABLE_NAME = "dbld";
	public static final String ID = "_id";
	public static final String NAME = "name";
	public static final String SEX = "sex";

	public MySqlite(Context context) {
		super(context, "h.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_NAME + "( " + ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME
				+ " TEXT NOT NULL," + SEX + " TEXT NOT NULL)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

}
