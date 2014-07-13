package com.bslee.ui.widget;

import com.bslee.R;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.ShareActionProvider;
import android.widget.SpinnerAdapter;

public class ActionBarListNavActivity extends FragmentActivity {

	// 在这里配合Fragment，实现不同的页面导航
	@SuppressLint("NewApi")
	OnNavigationListener mOnNavigationListener = new OnNavigationListener() {

		@Override
		public boolean onNavigationItemSelected(int position, long itemId) {
			FirstFragment newFragment = null;
			switch (position) {
			case 0:
				newFragment = new FirstFragment();
				getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_layout, newFragment, "导航1")
				.commit();
				 getActionBar().setTitle("导航1");//设置标题

				break;
			case 1:
				newFragment = new FirstFragment();
				getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_layout, newFragment, "导航2")
				.commit();
				 getActionBar().setTitle("导航2");//设置标题

				break;
	
			default:
				break;
			}
		
			return true;
		}
	};

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actionbar_listnav_main);
	   getActionBar().setDisplayHomeAsUpEnabled(true);//返回按钮打开
		getActionBar().setHomeButtonEnabled(true);//主页按钮打开
		 getActionBar().setTitle("首页");//设置标题

		SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
				R.array.action_list,
				android.R.layout.simple_spinner_dropdown_item);
		// 设置下拉导航
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);// 导航模式必须设为NAVIGATION_MODE_LIST
		getActionBar().setListNavigationCallbacks(mSpinnerAdapter,
				mOnNavigationListener);

	}

	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.actionbar_menu, menu);

		// 搜索视窗
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search)
				.getActionView();
		searchView.setOnQueryTextListener(null);//设置搜素事件
		// 分享视窗
		ShareActionProvider mShareActionProvider = (ShareActionProvider) menu
				.findItem(R.id.menu_share).getActionProvider();
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("image/*");
		mShareActionProvider.setShareIntent(shareIntent);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, ActionBarListNavActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}