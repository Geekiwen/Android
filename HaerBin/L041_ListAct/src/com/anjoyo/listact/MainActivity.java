package com.anjoyo.listact;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	private ArrayAdapter<String> adapter;
	private String data[]={"1","2","3","4"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
		setListAdapter(adapter);
		
	}

}
