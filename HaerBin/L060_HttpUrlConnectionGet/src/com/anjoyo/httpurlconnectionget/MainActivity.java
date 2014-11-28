package com.anjoyo.httpurlconnectionget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	private HttpURLConnection conn;
	private URL url;
	private InputStream in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String urldata = "http://10.0.2.2:8080/Android_Service/webdata.jsp?name=liu&password=123";
				try {
					url = new URL(urldata);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn = (HttpURLConnection) url.openConnection();// 打开网址
					conn.connect();// 连接
					in = conn.getInputStream();
					// 缓冲区
					BufferedReader br = new BufferedReader(
							new InputStreamReader(in));
					String line = null;
					StringBuffer sb = new StringBuffer();
					while ((line = br.readLine()) != null) {
						sb.append(line);
					}
					System.out.println(sb.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
