package com.anjoyo.l009_bundle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Intent i = new Intent(MainActivity.this, Act2.class);
			// bundleÐ¯´øÊý¾Ý
			Bundle bundle = new Bundle();
			bundle.putString("name", "Helloword");
			i.putExtras(bundle);
			startActivity(i);
			break;

		default:
			break;
		}
	}

}
