package com.anjoyo.optionsmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, 1, Menu.NONE, "菜单1");
		menu.add(Menu.NONE, 2, Menu.NONE, "菜单2");
		SubMenu subMenu = menu.addSubMenu("子菜单");
		subMenu.setHeaderTitle("小写");
		subMenu.setIcon(R.drawable.ic_launcher);
		subMenu.add(Menu.NONE, 3, Menu.NONE, "菜单3");
		subMenu.add(Menu.NONE, 4, Menu.NONE, "菜单4");
		subMenu.add(Menu.NONE, 5, Menu.NONE, "菜单5");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this, "点击了菜单1", Toast.LENGTH_SHORT).show();
			break;
		case 5:
			Toast.makeText(this, "点击了菜单5", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
