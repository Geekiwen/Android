package com.anjoyo.usingasyntask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btn;
	private TextView tv;
	private ProgressBar pb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.textView1);
		pb = (ProgressBar) findViewById(R.id.progressBar1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				MyAsynTask myAsynTask = new MyAsynTask(tv, pb);
				myAsynTask.execute("", "i=","Helloword");// Æô¶¯·½·¨
			}
		});
	}

}
