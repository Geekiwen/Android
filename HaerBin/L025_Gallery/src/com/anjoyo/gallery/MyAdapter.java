package com.anjoyo.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {

	private Context context;
	private int imageids[];

	public MyAdapter(Context context, int imageids[]) {
		this.context = context;
		this.imageids = imageids;
	}

	@Override
	public int getCount() {
		return imageids.length;
	}

	@Override
	public Object getItem(int position) {
		return imageids[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView iv = new ImageView(context);
		iv.setImageResource(imageids[position]);
		iv.setLayoutParams(new Gallery.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		return iv;
	}

}
