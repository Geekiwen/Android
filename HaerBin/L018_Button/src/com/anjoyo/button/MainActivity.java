package com.anjoyo.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private Button btn;
	private RadioButton rb;
	private CheckBox ck;
	private ToggleButton tb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rb = (RadioButton) findViewById(R.id.r2);
		btn = (Button) findViewById(R.id.btn);
		btn.setVisibility(View.VISIBLE);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				if (rb.isChecked()) {
					Toast.makeText(MainActivity.this, "¹§Ï²Äã", Toast.LENGTH_LONG).show();
				}else {
					Toast.makeText(MainActivity.this, "ÄãÄãÄã£¡£¡£¡", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		
	}

	

}
