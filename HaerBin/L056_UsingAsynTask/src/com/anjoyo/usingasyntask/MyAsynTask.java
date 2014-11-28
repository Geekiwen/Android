package com.anjoyo.usingasyntask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyAsynTask extends AsyncTask<String, Integer, String> {

	/**
	 * 参数1：doInBackground：方法参数有关 参数2:onProgressUpdate:方法参数有关
	 * 参数3：doInBackground：方法的类型有关、onPostExecute：方法参数有关
	 * 
	 */
	private TextView tv;
	private ProgressBar pb;

	// 构造方法
	public MyAsynTask(TextView tv, ProgressBar pb) {
		this.tv = tv;
		this.pb = pb;
	}

	// 核心处理方法
	@Override
	protected String doInBackground(String... params) { // String... params：可变参数
		String val = params[1];
		String hw = params[2];
		MyThread myThread = new MyThread();
		int i = 0;
		for (i = 0; i <= 100; i++) {
			myThread.netConn();

			//触发onProgressUpdate执行
			publishProgress(i, 1000);
		}
		return val + i + hw;
	}

	// 当异步结束的时候触发此方法
	@Override
	protected void onPostExecute(String result) {
		if (result != null) {
			tv.setText("异步结束:" + result);
		}
		super.onPostExecute(result);
	}

	// 当异步开始的时候触发
	@Override
	protected void onPreExecute() {
		System.out.println("异步开始了");
		tv.setText("异步开始");
		super.onPreExecute();
	}

	// 正在处理的时候出发。与UI主线程进行交互的
	@Override
	protected void onProgressUpdate(Integer... values) {
		pb.setProgress(values[0]);
		tv.setText(values[0] + "" + values[1]);
		super.onProgressUpdate(values);
	}
}
