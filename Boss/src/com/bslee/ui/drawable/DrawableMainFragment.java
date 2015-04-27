package com.bslee.ui.drawable;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bslee.boss.R;

public class DrawableMainFragment  extends Fragment {

	private ListView listView;

	private FragmentActivity activity;
	public ArrayList<String> data = new ArrayList<String>();
	public ArrayAdapter<String> adapter;

	/**
	 * 初始化一次
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		data.add("BitmapDrawable");
	    data.add("NinePatchDrawable");
	    data.add("LayerDrawable");
	    data.add("TransitionDrawable");
	    data.add("InsetDrawable ");
	    data.add("ClipDrawable");
	    data.add("ScaleDrawable");
	    data.add("ColorDrawable");
	    data.add("DrawableContainer");
	    data.add("LevelListDrawable");
	    data.add("StateListDrawable");
	    data.add("AnimationDrawable");//anim
	    data.add("PictureDrawable");//Graphics
         data.add("ShapeDrawable");//Graphics
	    data.add("PaintDrawable");//Graphics
	    data.add("RotateDrawable");
	    data.add("GradientDrawable");
	}
	/**
	 * 创建多次View
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		activity = getActivity();
		View rootView = inflater.inflate(R.layout.fragment_page, container,
				false);
		listView = (ListView) rootView.findViewById(R.id.list);
		adapter = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1, data);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
		   
			switch (arg2) {
			case 0:
				startActivity(new Intent(getActivity(), BitmapDrawableFragmentActivity.class));				
				break;
			case 1:	
				startActivity(new Intent(getActivity(), NinePatchDrawableFragmentActivity.class));
				break;
			case 2:
				startActivity(new Intent(getActivity(), LayerDrawableFragmentActivity.class));
				break;				
			case 3:
				startActivity(new Intent(getActivity(), TransitionDrawableFragmentActivity.class));
				break;
			case 4:
				startActivity(new Intent(getActivity(), InsetDrawableFragmentActivity.class));
				break;
			case 5:
				startActivity(new Intent(getActivity(), ClipDrawableFragmentActivity.class));
				break;
			case 6:
				startActivity(new Intent(getActivity(), ScaleDrawableFragmentActivity.class));
				break;
			case 7:
				startActivity(new Intent(getActivity(), ColorDrawableFragmentActivity.class));
				break;
			case 8:
				startActivity(new Intent(getActivity(),DrawableContainerFragmentActivity.class));
				break;
			case 9:
				startActivity(new Intent(getActivity(), LevelListDrawableFragmentActivity.class));
				break;
			case 10:
				startActivity(new Intent(getActivity(), StateListDrawableFragmentActivity.class));
				break;
			case 11:
				startActivity(new Intent(getActivity(),AnimationDrawableFragmentActivity.class));
				break;
			case 12:
				startActivity(new Intent(getActivity(), PictureDrawableFragmentActivity.class));
				break;
			case 13:
				startActivity(new Intent(getActivity(), ShapeDrawableFragmentActivity.class));
				break;
			case 14:
				startActivity(new Intent(getActivity(), PaintDrawableFragmentActivity.class));
				break;				
			case 15:
				startActivity(new Intent(getActivity(), RotateDrawableFragmentActivity.class));
				break;			
			case 16:
				startActivity(new Intent(getActivity(), GradientDrawableFragmentActivity.class));
				break;			
			default:
				break;
			}	
			}
		} );
		return rootView;
	}

}
