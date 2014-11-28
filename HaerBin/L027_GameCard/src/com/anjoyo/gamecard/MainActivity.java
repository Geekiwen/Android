package com.anjoyo.gamecard;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {

	private RelativeLayout layout;
	private RelativeLayout.LayoutParams rl;
	private List<Point> points = new ArrayList<Point>();
	private Card card;
	public List<Card> cards = new ArrayList<Card>();
	private int index = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		layout = new RelativeLayout(this);
		setContentView(layout);
		startGame();

	}

	/**
	 * 开始游戏
	 */
	public void startGame() {
		pointCard();
		addCard();
	}

	// 得到每一个卡片的位置
	public void pointCard() {
		points.clear();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				points.add(new Point(i * 50, j * 50));
			}
		}
	}

	// 添加卡片
	public void addCard() {
		Point p;
		for (int i = 1; i <= 5; i++) {
			card = new Card(this, i);
			p = points.remove((int) (Math.random() * points.size()));
			
			System.out.println(points.remove((int) (Math.random() * points
					.size())) + ">>>>>>>");
			// 创建卡片的位置
			rl = new RelativeLayout.LayoutParams(40, 40);
			rl.leftMargin = p.x;
			rl.topMargin = p.y;
			layout.addView(card, rl);
			card.setOnClickListener(this);
			cards.add(card);
		}
	}

	@Override
	public void onClick(View v) {
		if (v instanceof Card) {
			card = (Card) v;
			for (Card c : cards) {
				c.showB();
			}
		}

		/**
		 * 移除卡片
		 * 
		 */
		if (card.getNumber() == index) {
			index++;
			layout.removeView(card);
			cards.remove(card);
		} else {
			clearPoint();
		}
	}

	public void clearPoint() {
		cards.clear();
	}

}
