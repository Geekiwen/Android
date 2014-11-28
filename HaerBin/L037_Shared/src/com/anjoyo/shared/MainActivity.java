package com.anjoyo.shared;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et1, et2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et2 = (EditText) findViewById(R.id.et2);
		et1 = (EditText) findViewById(R.id.et1);

		// ´´½¨SharedPreferences
		SharedPreferences sp = getSharedPreferences("hs", Activity.MODE_PRIVATE);
		et1.setText(sp.getString("username", ""));
		et2.setText(sp.getString("userpassword", ""));
	}

	@Override
	protected void onStop() {

		SharedPreferences sp = getSharedPreferences("hs", Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("username", et1.getText().toString());
		editor.putString("userpassword", et2.getText().toString());
		// ±£´æ
		editor.commit();
		super.onStop();
	}

}
