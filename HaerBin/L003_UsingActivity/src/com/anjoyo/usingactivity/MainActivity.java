package com.anjoyo.usingactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	//����һ��Button
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//ͨ��findviewbyid����ȥ������Դ�ļ�
		btn = (Button)findViewById(R.id.btn);
		//����ť������
		btn.setOnClickListener(new OnClickListener() {
			
			//�η����ǳ����¼��ķ���
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, Act2.class);// Ҫ��MainAct��ת��Act2��
				// ����Activity�ķ���
				startActivity(i);
			}
		});
		
	}

}
