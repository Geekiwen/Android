package com.anjoyo.usingring;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn1, btn2, btn3;
	private AudioManager am;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			break;

		case R.id.button2:
			am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			break;
		case R.id.button3:
			am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
			break;
		}
	}

}
