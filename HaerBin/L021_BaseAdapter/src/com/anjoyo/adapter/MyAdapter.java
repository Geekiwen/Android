package com.anjoyo.adapter;

import com.android.baseadapter.R;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	/**
	 * 1.扩展自BaseAdapter 2.覆写4个方法，并且传递相关返回值 3.getView方法中加载视图 4.
	 */
	private Context context;
	private String data[];
	private int image[];

	// private Cursor cursor;

	public MyAdapter(Context context, String data[], int image[]) {
		this.context = context;
		this.data = data;
		this.image = image;
		// this.cursor = cursor;
	}

	// 返回当前数据源的数据量（多少条数据）
	@Override
	public int getCount() {
		return data.length;
	}

	// 返回当前的一项
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data[position];
	}

	// 返回当前每一项的ID
	@Override
	public long getItemId(int position) {

		return position;
	}

	/**
	 * ********* 返回一个试图
	 */

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// // 加载视图
		// LayoutInflater inflater = (LayoutInflater) context
		// .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//
		// LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.cell,
		// null);
		// TextView tv = (TextView) layout.findViewById(R.id.myadapter_tv);
		// ImageView iv = (ImageView) layout.findViewById(R.id.imageView1);
		// tv.setText(data[position]);
		// iv.setBackgroundResource(image[position]);

		// convertView：优化LIstView
		// ViewHolder：listViwe缓存
		
		ViewHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.cell,
					null);
			holder = new ViewHolder();

			holder.tv = (TextView) convertView.findViewById(R.id.myadapter_tv);
			holder.iv = (ImageView) convertView.findViewById(R.id.imageView1);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();

		}
		holder.tv.setText(data[position]);
		holder.tv.setBackgroundResource(image[position]);
		// holder.iv.setBackgroundResource(image[position]);

		return convertView;
	}

	private static class ViewHolder {
		TextView tv;
		ImageView iv;
	}

}
