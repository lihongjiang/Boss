package com.bslee.ui.drawable;

import com.bslee.R;

import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class GradientDrawableFragmentActivity extends FragmentActivity {
	
	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("GradientDrawable的作用在于定于各种样式的渐变。在XML文件中使用<shape>元素定义。" +
				"<shape>定义这是一个GradientDrawable，必须作为根元素。");

		img.setBackgroundResource(R.drawable.drawable_gradient_box);
		//Resources res = getResources();
		//Drawable shape = res. getDrawable(R.drawable.drawable_gradient_box);
		//img.setBackgroundDrawable(shape);
	}

}
