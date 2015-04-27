package com.bslee.ui.drawable;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.TextView;

import com.bslee.boss.R;

public class StateListDrawableFragmentActivity extends FragmentActivity {

	TextView text;
	Button img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_button);
		text = (TextView) findViewById(R.id.text);
		img = (Button) findViewById(R.id.img);

		text.setText("一个StateListDrawable就是一个在xml文件中定义，"
				+ "根据该对象不同的状态，用几张不同的图片来代表相同的图形。比如，"
				+ "一个按钮，有多种状态，获取焦点，失去焦点，点击等等，使用"
				+ "StateListDrawable可以根据不同的状态提供不同的背景。"
				+ "在XML文件中描述这些状态列表。在唯一的一个<selector>标签下，"
				+ "使用<item>标签来代表一个图形。每个<item>标签使用各种属性来"
				+ "描述它所代表的状态所需要的drawable资源。再次状态发生改变的时候，"
				+ "都会从上到下遍历这个状态列表，第一个和它匹配的将会被使用-------而不是去选择最适合的匹配。");

		img.setBackgroundResource(R.drawable.drawable_selector);

		// StateListDrawable drawable=new StateListDrawable();
		// //如果要设置莫项为false，在前面加负号
		// ，比如android.R.attr.state_focesed标志true，-android.R.attr.state_focesed就标志false
		// drawable.addState(new int[]{android.R.attr.state_focused},
		// this.getResources().getDrawable(R.drawable.bitmap));
		// drawable.addState(new int[]{android.R.attr.state_pressed},
		// this.getResources().getDrawable(R.drawable.bitmap_press));
		// drawable.addState(new int[]{android.R.attr.state_selected},
		// this.getResources().getDrawable(R.drawable.bitmap));
		// drawable.addState(new int[]{},
		// this.getResources().getDrawable(R.drawable.bitmap));//默认
		// img.setBackgroundDrawable(drawable);

	}
}
