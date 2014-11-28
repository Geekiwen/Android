package com.anjoyo.testnet;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo networkInfo = cm.getActiveNetworkInfo();
				if (networkInfo != null) {
					Toast.makeText(MainActivity.this,
							"����״̬:" + networkInfo.getTypeName(),
							Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(MainActivity.this, "δ����״̬",
							Toast.LENGTH_LONG).show();

				}
			}
		});
	}

}
