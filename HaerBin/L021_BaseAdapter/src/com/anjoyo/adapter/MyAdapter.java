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
	 * 1.��չ��BaseAdapter 2.��д4�����������Ҵ�����ط���ֵ 3.getView�����м�����ͼ 4.
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

	// ���ص�ǰ����Դ�������������������ݣ�
	@Override
	public int getCount() {
		return data.length;
	}

	// ���ص�ǰ��һ��
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data[position];
	}

	// ���ص�ǰÿһ���ID
	@Override
	public long getItemId(int position) {

		return position;
	}

	/**
	 * ********* ����һ����ͼ
	 */

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// // ������ͼ
		// LayoutInflater inflater = (LayoutInflater) context
		// .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//
		// LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.cell,
		// null);
		// TextView tv = (TextView) layout.findViewById(R.id.myadapter_tv);
		// ImageView iv = (ImageView) layout.findViewById(R.id.imageView1);
		// tv.setText(data[position]);
		// iv.setBackgroundResource(image[position]);

		// convertView���Ż�LIstView
		// ViewHolder��listViwe����
		
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
