package com.anjoyo.l012_intent_call_sms;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn, btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn.setOnClickListener(this);
		btn2.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			// 打电话
			startActivity(new Intent(Intent.ACTION_CALL,
					Uri.parse("tel://10086")));
			break;

		case R.id.button2:
			// 发送短信
			startActivity(new Intent(Intent.ACTION_SENDTO,
					Uri.parse("smsto://010")));
			break;
		}
	}

}
