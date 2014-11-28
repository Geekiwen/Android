package com.anjoyo.actionbartab;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener {

	private ActionBar actionBar;
	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout = (LinearLayout) findViewById(R.id.layout);
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayHomeAsUpEnabled(true);

		TextFragMent textFragMent = new TextFragMent();
		Tab tab1 = actionBar.newTab();
		tab1.setIcon(R.drawable.ic_launcher);
		tab1.setText("选项卡·1");
		tab1.setTabListener(new TextLister(textFragMent));
		actionBar.addTab(tab1);
		layout.setOnTouchListener(this);

	}

	class TextLister implements TabListener {

		private TextFragMent textFragMent;

		public TextLister(TextFragMent textFragMent) {
			this.textFragMent = textFragMent;
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {

		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			ft.add(R.id.layout, textFragMent, null);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			ft.remove(textFragMent);
		}

	}

	// @Override
	// public boolean onTouchEvent(MotionEvent event) {
	// switch (event.getAction()) {
	// case MotionEvent.ACTION_UP:
	// if (actionBar.isShowing()) {
	// actionBar.hide();
	// } else {
	// actionBar.show();
	// }
	// break;
	//
	// default:
	// break;
	// }
	// return super.onTouchEvent(event);
	// }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:
			if (actionBar.isShowing()) {
				actionBar.hide();
			} else {
				actionBar.show();
			}
			break;

		default:
			break;
		}
		return true;
	}

}
