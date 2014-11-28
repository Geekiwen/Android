package com.anjoyo.usingasyntask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyAsynTask extends AsyncTask<String, Integer, String> {

	/**
	 * ����1��doInBackground�����������й� ����2:onProgressUpdate:���������й�
	 * ����3��doInBackground�������������йء�onPostExecute�����������й�
	 * 
	 */
	private TextView tv;
	private ProgressBar pb;

	// ���췽��
	public MyAsynTask(TextView tv, ProgressBar pb) {
		this.tv = tv;
		this.pb = pb;
	}

	// ���Ĵ�����
	@Override
	protected String doInBackground(String... params) { // String... params���ɱ����
		String val = params[1];
		String hw = params[2];
		MyThread myThread = new MyThread();
		int i = 0;
		for (i = 0; i <= 100; i++) {
			myThread.netConn();

			//����onProgressUpdateִ��
			publishProgress(i, 1000);
		}
		return val + i + hw;
	}

	// ���첽������ʱ�򴥷��˷���
	@Override
	protected void onPostExecute(String result) {
		if (result != null) {
			tv.setText("�첽����:" + result);
		}
		super.onPostExecute(result);
	}

	// ���첽��ʼ��ʱ�򴥷�
	@Override
	protected void onPreExecute() {
		System.out.println("�첽��ʼ��");
		tv.setText("�첽��ʼ");
		super.onPreExecute();
	}

	// ���ڴ����ʱ���������UI���߳̽��н�����
	@Override
	protected void onProgressUpdate(Integer... values) {
		pb.setProgress(values[0]);
		tv.setText(values[0] + "" + values[1]);
		super.onProgressUpdate(values);
	}
}
