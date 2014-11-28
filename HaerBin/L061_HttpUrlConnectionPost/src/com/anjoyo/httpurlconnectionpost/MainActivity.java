package com.anjoyo.httpurlconnectionpost;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	private HttpURLConnection conn;
	private URL url;
	private OutputStream out;
	private InputStream in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String urldata = "http://10.0.2.2:8080/Android_Service/webdata.jsp";
				try {
					url = new URL(urldata);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn = (HttpURLConnection) url.openConnection();
					// post��ʽ
					// �������������
					conn.setDoOutput(true);
					conn.setDoInput(true);
					// ���õ�ǰ��post��ʽ
					conn.setRequestMethod("POST");
					// post��ʽ���ܻ�������
					conn.setUseCaches(false);
					// ����
					conn.connect();
					// �õ������
					out = conn.getOutputStream();
					// ͨ��dataOutputStream���д��ݲ���
					DataOutputStream dataOutputStream = new DataOutputStream(
							out);
					dataOutputStream.writeBytes("name="
							+ URLEncoder.encode("liuxingyu", "utf-8"));

					in = conn.getInputStream();

					// ������
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
