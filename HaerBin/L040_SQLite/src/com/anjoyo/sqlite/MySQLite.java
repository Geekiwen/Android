package com.anjoyo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLite extends SQLiteOpenHelper {


	public MySQLite(Context context) {
		super(context, "hs.db", null, 2);
	}

	/**
	 * 1.���⽨��
	 * 2.��ɾ�Ĳ�
	 * 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE user( _id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS user");// ������ݿ�������������ôɾ����������´���
		db.execSQL("CREATE TABLE user( _id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, content TEXT NOT NULL )");
	}

}
