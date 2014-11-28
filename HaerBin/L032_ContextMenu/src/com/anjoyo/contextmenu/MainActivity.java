package com.anjoyo.contextmenu;
import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		registerForContextMenu(tv);// 出发上下文菜单
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(Menu.NONE, 1, Menu.NONE, "菜单1");
		menu.add(Menu.NONE, 2, Menu.NONE, "菜单2");
		SubMenu subMenu = menu.addSubMenu("子菜单");
		subMenu.setHeaderTitle("小写");
		subMenu.setIcon(R.drawable.ic_launcher);
		subMenu.add(Menu.NONE, 3, Menu.NONE, "菜单3");
		subMenu.add(Menu.NONE, 4, Menu.NONE, "菜单4");
		subMenu.add(Menu.NONE, 5, Menu.NONE, "菜单5");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			
			break;

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}

}
