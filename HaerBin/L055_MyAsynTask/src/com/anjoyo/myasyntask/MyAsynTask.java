package com.anjoyo.myasyntask;

import android.os.AsyncTask;

public class MyAsynTask extends AsyncTask<Void, Void, String> {

	@Override
	protected String doInBackground(Void... params) {
		MyThread myThread = new MyThread();
		myThread.netConn();
		return null;
	}

}
