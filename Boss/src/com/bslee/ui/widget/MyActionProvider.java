package com.bslee.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

import com.bslee.boss.R;

@SuppressLint("NewApi")
public class MyActionProvider extends ActionProvider {
	private ContextWrapper mContextWrapper;
	private OnMenuItemClickListener mOnMenuItemClickListener;

	public MyActionProvider(Context context) {
		super(context);
		mContextWrapper = (ContextWrapper) context;
	}

	@Override
	public View onCreateActionView() {
		LayoutInflater layoutInflater = LayoutInflater.from(mContextWrapper);
		View view = layoutInflater.inflate(R.layout.myactionprovider, null);
		ImageView popupView = (ImageView) view.findViewById(R.id.button);
		popupView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showPopup(v);
			}
		});
		mOnMenuItemClickListener = new OnMenuItemClickListener() {
			private String TAG = "mOnMenuItemClickListener";

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch (item.getItemId()) {
				case R.id.Settings1:
					Toast.makeText(mContextWrapper, "单击了Settings1",
							Toast.LENGTH_SHORT).show();
					break;
				case R.id.Settings2:
					Toast.makeText(mContextWrapper, "单击了Settings2",
							Toast.LENGTH_SHORT).show();
					break;

				default:
					break;
				}
				return false;
			}
		};
		return view;
	}

	protected void showPopup(View v) {
		PopupMenu popup = new PopupMenu(mContextWrapper, v);
		MenuInflater inflater = popup.getMenuInflater();
		inflater.inflate(R.menu.popmenu, popup.getMenu());
		popup.setOnMenuItemClickListener(mOnMenuItemClickListener);
		popup.show();
	}

}