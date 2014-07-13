package com.bslee.ui.drawable;

import com.bslee.R;

import android.graphics.PixelFormat;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class InsetDrawableFragmentActivity extends FragmentActivity {

	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawableinsertfragment);
		text = (TextView) findViewById(R.id.text);

		text.setText("InsetDrawable 表示一个drawable嵌入到另外一个d"
				+ "rawable内部，并且在内部留一些间距，这一点很像drawable的padding属性"
				+ "，区别在于 padding表示drawable的内容与drawable本身的边距，in"
				+ "setDrawable表示两个drawable和容器之间的边距。当控件需要的背景比实际"
				+ "的边框小的时候比较适合使用InsetDrawable。");

		// 代码定义
		InsetDrawable insetDrawable = new InsetDrawable(getResources()
				.getDrawable(R.drawable.w01), 20, 30, 30, 20);

	}
}
