package com.bslee.ui.drawable;

import com.bslee.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class LayerDrawableFragmentActivity extends FragmentActivity {

	TextView text;
	ImageView img;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.drawable_bitmap);
		text = (TextView) findViewById(R.id.text);
		img = (ImageView) findViewById(R.id.img);

		text.setText("一、创建LayerDrawable和使用" +
				"一个LayerDrawable是一个可以管理一组drawable对象的drawable。" +
				"在LayerDrawable的drawable资源按照列表的顺序绘制，列表的最后一个drawable绘制在最上层。" +
				"它所包含的一组drawable资源用多个<item>元素表示，一个<item>元素代表一个drawable资源。");

	
		       img.setImageDrawable(getResources().getDrawable(R.drawable.drawable_layerlist));
	
//		        Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.logo);
//		        Drawable[] drawables=new Drawable[3];
//		        
//		        drawables[0]=new BitmapDrawable(bitmap);
//		        drawables[1]=new BitmapDrawable(bitmap);
//		        drawables[2]=new BitmapDrawable(bitmap);
//		        LayerDrawable layer=new LayerDrawable(drawables);
//		        layer.setLayerInset(0, 20, 20, 0, 0);
//		        layer.setLayerInset(1, 40, 40, 0, 0);
//		        layer.setLayerInset(2, 60, 60, 0, 0);
//	
//		        img.setImageDrawable(layer);
	
	}
}
