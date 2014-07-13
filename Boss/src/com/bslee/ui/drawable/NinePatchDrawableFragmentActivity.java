package com.bslee.ui.drawable;

import com.bslee.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class NinePatchDrawableFragmentActivity extends FragmentActivity {

	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("一、创建NinePatchDrawable\n"
				+ "一个NinePatch也是一个PNG的图片，不过不同的是可以为这种格式的图片定义可伸缩的区域，"
				+ "当某个视图的内容超过了正常的尺寸的时候，这种格式的图片会自动拉伸以适应不同的尺寸。"
				+ "一般这种图片是作为视图的背景，并且视图至少有一个尺寸（layout_width或者layout_height）"
				+ "是设置为\"warp_content\"。当视图自增长来适应内容的时候，Nine-Patch格式的图片也会相应的"
				+ "进行缩放来匹配视图的尺寸." + "\n" + "二、创建一个.9.png格式的图片"
				+ "\n在androidsdk的tools目录下，"
				+ "有这样一个工具draw9patch.bat。使用这个工具，可以很快速的绘制一个.9.png格式的图片。"
				+ "这种格式的图片在android 环境下具有自适应调节大小的能力。");

		img.setBackgroundResource(R.drawable.drawable_ninepatch);
		img.setImageDrawable(getWallpaper());
		
	}
}
