package com.anjoyo.l024_button;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private LinearLayout layout;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		layout = new LinearLayout(this);
		setContentView(layout);
		btn = new Button(this);
		btn.setText("动态创建的按钮");
		btn.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

		layout.setGravity(Gravity.BOTTOM);
		layout.addView(btn);

	}

}
