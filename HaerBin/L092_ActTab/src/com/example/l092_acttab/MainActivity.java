package com.example.l092_acttab;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayHomeAsUpEnabled(true);// ����actionbar��ͼ���ǿ��Ե��״̬

		// ����һ��Tab����
		TextFragMent textFragMent = new TextFragMent();
		Tab tab1 = actionBar.newTab();
		tab1.setIcon(R.drawable.ic_launcher);
		tab1.setText("ѡ�1");
		tab1.setTabListener(new TextLitener(textFragMent));
		// ����ǩ��ӵ�actionbar��
		actionBar.addTab(tab1);

		ImageFragMent imageFragMent = new ImageFragMent();
		Tab tab2 = actionBar.newTab();
		tab2.setIcon(R.drawable.ic_launcher);
		tab2.setText("ѡ�2");
		tab2.setTabListener(new ImageLitener(imageFragMent));
		actionBar.addTab(tab2);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(MainActivity.this, "������", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// �����¼�
	@Override
	public boolean onTouchEvent(MotionEvent event) {
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

		return super.onTouchEvent(event);
	}

	class ImageLitener implements TabListener {
		private ImageFragMent imageFragMent;

		public ImageLitener(ImageFragMent imageFragMent) {
			this.imageFragMent = imageFragMent;
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			ft.add(R.id.layout, imageFragMent, null);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			ft.remove(imageFragMent);
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}
	}

	class TextLitener implements TabListener {
		private TextFragMent textFragMent;

		public TextLitener(TextFragMent textFragMent) {
			this.textFragMent = textFragMent;
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			ft.add(R.id.layout, textFragMent, null);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			ft.remove(textFragMent);
		}

		// ����������ѡ����ͼ��ʱ��ᴥ���˷���
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {

		}

	}
}
