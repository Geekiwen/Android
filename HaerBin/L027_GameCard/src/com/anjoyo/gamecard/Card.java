package com.anjoyo.gamecard;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Card extends RelativeLayout {

	private int number;
	private TextView tv;
	private boolean visiable = true;

	public Card(Context context, int number) {
		super(context);
		this.number = number;
		tv = new TextView(getContext());
		tv.setTextSize(20);
		tv.setText(number + "");
		addView(tv);
		showA();
	}

	// 正面
	public void showA() {
		visiable = true;
		tv.setVisibility(View.VISIBLE);
		setBackgroundColor(Color.RED);
	}

	// 反面
	public void showB() {
		visiable = false;
		tv.setVisibility(View.GONE);
		setBackgroundColor(Color.BLUE);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isVisiable() {
		return visiable;
	}

	public void setVisiable(boolean visiable) {
		this.visiable = visiable;
	}
	
	
}
