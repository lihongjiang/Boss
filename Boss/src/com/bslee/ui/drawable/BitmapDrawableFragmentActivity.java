package com.bslee.ui.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bslee.R;

public class BitmapDrawableFragmentActivity extends FragmentActivity {

	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("Bitmap，代表一个位图图像，Android支持三种格式的位图图像：.png (preferred)，.jpg (acceptable)， .gif (discouraged)."
				+ "\n1、通过Bitmap File\n一个bitmap文件就是一个.png、.jpg，.gif格式的文件。Android会对存储在res/drawable/目录下的这些文件创建一个Drawable资源。"
				+ " \n2、通过XML Bitmap\n一个XML bitmap是一个在XML文件中定义的指向一个bitmap文件的资源。其效果是作为一个原始位图文件的别名，并且可以指定一些额外的属性。");

		Resources res=getResources();
		Drawable drawable = res.getDrawable(R.drawable.drawable_bitmap);
		// 实际上这是一个BitmapDrawable对象
		BitmapDrawable bitmapDrawable=(BitmapDrawable)drawable;
		// 可以在调用getBitmap方法，得到这个位图
		 Bitmap bitmap=bitmapDrawable.getBitmap();
		 img.setImageBitmap(bitmap);
	}
}
