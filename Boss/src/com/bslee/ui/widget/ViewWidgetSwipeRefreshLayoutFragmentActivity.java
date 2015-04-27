package com.bslee.ui.widget;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bslee.boss.R;

/**
 * 
 * @author 李洪江
 * @description 下拉刷新组件应用
 */
public class ViewWidgetSwipeRefreshLayoutFragmentActivity extends
		FragmentActivity implements SwipeRefreshLayout.OnRefreshListener {
	private SwipeRefreshLayout swipeLayout;
	private ListView listView;
	private boolean isRefresh = false;// 是否
	public ArrayList<String> data = new ArrayList<String>();
	public ArrayAdapter<String> adapter;

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_swipe_refresh_layut);
		getActionBar().setDisplayHomeAsUpEnabled(true);// 开启返回导航功能
		getActionBar().setLogo(R.drawable.logo);
		getActionBar().setTitle("下拉刷新控件测试");
		// 下拉控件初始化
		swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
		swipeLayout.setOnRefreshListener(this);
		// 加载颜色是循环播放的，只要没有完成刷新就会一直循环，color1>color2>color3>color4
		swipeLayout.setColorScheme(android.R.color.white,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light);

		data.add("初始化数据1");
		data.add("初始化数据2");
		data.add("初始化数据3");

		listView = (ListView) findViewById(R.id.list);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data);
		listView.setAdapter(adapter);

	}

	// 下拉刷新方法
	@Override
	public void onRefresh() {
		// 检查是否刷新结束
		if (!isRefresh) {
			isRefresh = true;
			new Handler().postDelayed(new Runnable() {
				public void run() {
					swipeLayout.setRefreshing(false);
					data.add("下拉添加数据1");
					data.add("下拉添加数据1");
					data.add("下拉添加数据1");
					adapter.notifyDataSetChanged();
					isRefresh = false;
				}
			}, 3000);
		}
	}

	//菜单选项事件
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// 点击应用程序图标,返回上一级或者主界面
			//Intent intent = new Intent(this, MainActivity.class);
			//intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			//startActivity(intent);
			// 点击应用程序图标,返回上一级
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}