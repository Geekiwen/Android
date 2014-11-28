package com.example.l090_actionbar;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener {

	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBar = getActionBar();// ����һ��ActionBar
		actionBar.setDisplayHomeAsUpEnabled(true);
		// ɾ��actionbar
		// actionBar.hide();
		// actionBar.show();
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Act2.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem open = menu.add(0, 2, 0, "��");
		MenuItem del = menu.add(0, 1, 0, "ɾ��");
		MenuItem flg = menu.add(0, 1, 0, "��ʾ");
		MenuItem add = menu.add(0, 1, 0, "���");
		add.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		del.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		flg.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		open.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this, "��������", Toast.LENGTH_LONG).show();
			break;

		case 2:
			Toast.makeText(this, "����˴���", Toast.LENGTH_LONG).show();
			break;
		case android.R.id.home:

			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {

		return false;
	}

}
