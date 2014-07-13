package com.bslee.ui.drawable;

import com.bslee.R;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ClipDrawableFragmentActivity extends FragmentActivity {

	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("ClipDrawable 是对一个Drawable进行剪切操作，"
				+ "可以控制这个drawable的剪切区域，以及相相对于容器的对齐方式"
				+ "，android中的进度条就是使用一个ClipDrawable实现效果的，"
				+ "它根据level的属性值，决定剪切区域的大小。"
				+ "        需要注意的是ClipDrawable是根据level的大小控制图片"
				+ "剪切操作的，官方文档的note中提到：The drawable is clipp"
				+ "ed completely and not visible when the level is 0 and fully re"
				+ "vealed when the level is 10,000。也就是level的大小从0到1000"
				+ "0，level为0时完全不显示，为10000时完全显示。是用Drawable提供"
				+ "的setLevel（int level）方法来设置剪切区域。");

		img.setImageDrawable(getResources().getDrawable(
				R.drawable.drawable_clip));

		img.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ClipDrawable drawable = (ClipDrawable) img.getDrawable();
				drawable.setLevel(drawable.getLevel() + 1000);
			}
		});

	}
}
