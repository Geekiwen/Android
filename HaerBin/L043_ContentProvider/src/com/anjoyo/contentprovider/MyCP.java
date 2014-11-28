package com.anjoyo.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyCP extends ContentProvider {

	/**
	 * 使用CP必须先来了解Uri:资源应用 URL：资源引用地址
	 */
	public static final Uri URI = Uri
			.parse("content://com.anjoyo.contentprovider.MyCP");//固定写法：content://
	public static final String CP_TABLE_NAME = MySqlite.TABLE_NAME;
	public static final String CP_ID = MySqlite.ID;
	public static final String CP_TITLE = MySqlite.TITLE;

	private MySqlite mySqlite;
	private SQLiteDatabase dbReader, dbWirter;

	@Override
	public boolean onCreate() {
		mySqlite = new MySqlite(getContext());
		dbReader = mySqlite.getReadableDatabase();
		dbWirter = mySqlite.getWritableDatabase();
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		return dbReader.query(CP_TABLE_NAME, projection, selection,
				selectionArgs, null, null, sortOrder);
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		dbWirter.insert(CP_TABLE_NAME, null, values);
		return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return dbWirter.delete(CP_TABLE_NAME, selection, selectionArgs);
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return dbWirter.update(CP_TABLE_NAME, values, selection, selectionArgs);
	}

}
