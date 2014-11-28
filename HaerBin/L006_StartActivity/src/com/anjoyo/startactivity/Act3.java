package com.anjoyo.startactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Act3 extends Activity {
	private Button btn;
	public static final int RESULT_ACT2 = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act3);
		btn = (Button) findViewById(R.id.bt2);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.putExtra("act3", "Œ“ «Act3");
				setResult(RESULT_ACT2, i);
				finish();
			}
		});
	}
}
