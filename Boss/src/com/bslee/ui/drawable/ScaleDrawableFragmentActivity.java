package com.bslee.ui.drawable;

import com.bslee.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScaleDrawableFragmentActivity extends FragmentActivity {

	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("基于当前的level，进行尺寸变换的drawable。");

		img.setImageDrawable(getResources().getDrawable(
				R.drawable.drawable_scale));

		// 默认是0,不显示,在代码里设置
		ScaleDrawable scaleDrawable = (ScaleDrawable) img.getDrawable();
		scaleDrawable.setLevel(1); // level 1的时候就是50%
		// // level 0的时候就是不可见

	}

	private void useScaledImage() {
		Resources res = getResources();
		BitmapDrawable bd = (BitmapDrawable) res.getDrawable(R.drawable.w01);
		Bitmap b = Bitmap.createScaledBitmap(bd.getBitmap(),
				(int) (bd.getIntrinsicHeight() * 0.7),
				(int) (bd.getIntrinsicWidth() * 0.7), false);

		LinearLayout l = new LinearLayout(this);
		ImageView iv = new ImageView(this);

		iv.setImageDrawable(new BitmapDrawable(b));
		iv.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));

		l.addView(iv);

		setContentView(l);
	}
}
