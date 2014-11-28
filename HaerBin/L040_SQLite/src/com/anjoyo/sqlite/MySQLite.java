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
	 * 1.建库建表
	 * 2.曾删改查
	 * 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE user( _id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS user");// 如果数据库存在了这个表，那么删除这个表，重新创建
		db.execSQL("CREATE TABLE user( _id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, content TEXT NOT NULL )");
	}

}
