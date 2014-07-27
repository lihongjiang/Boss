package com.bslee.ui;

import com.bslee.R;
import com.bslee.ui.activity.ActivityMainFragment;
import com.bslee.ui.animation.AnimationMainFragment;
import com.bslee.ui.atv.AtvMainFragemnt;
import com.bslee.ui.bn.BroadNotiMainFragemnt;
import com.bslee.ui.drawable.DrawableMainFragment;
import com.bslee.ui.fragment.FragmentMainFragment;
import com.bslee.ui.intent.IntentMainFragment;
import com.bslee.ui.io.FileSqlMainFragement;
import com.bslee.ui.jqm.JqmMainFragement;
import com.bslee.ui.net.NetMainFragement;
import com.bslee.ui.provider.ProviderMainFragement;
import com.bslee.ui.sdk.SdkMainFragment;
import com.bslee.ui.sensor.SensorMainFragement;
import com.bslee.ui.service.ServiceMainFragement;
import com.bslee.ui.widget.FirstFragment;
import com.bslee.ui.widget.SecondFragment;
import com.bslee.ui.widget.ViewWidgetFragment;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.AdapterView.OnItemClickListener;

//抽屉导航实现侧滑菜单
public class DrawerLayoutActivity extends FragmentActivity {

	private DrawerLayout mDrawer_layout;// DrawerLayout容器
	private RelativeLayout mMenu_layout_left;// 左边抽屉
	private RelativeLayout mMenu_layout_right;// 右边抽屉
	ActionBarDrawerToggle mDrawerToggle;
	String title = "路吃";

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawerlayout_main);

		mDrawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
		// /////////////////////////
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setTitle(title);// 显示当前标题

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawer_layout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
		R.string.app_name, /* "open drawer" description for accessibility */
		R.string.app_name /* "close drawer" description for accessibility */
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(title);// 显示当前标题
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(R.string.app_name);// 显示app名字
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};
		mDrawer_layout.setDrawerListener(mDrawerToggle);

		// 自定义阴影效果
		mDrawer_layout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		mMenu_layout_left = (RelativeLayout) findViewById(R.id.menu_layout_left);
		mMenu_layout_right = (RelativeLayout) findViewById(R.id.menu_layout_right);
		ListView menu_listview_l = (ListView) mMenu_layout_left
				.findViewById(R.id.menu_listView_l);
		ListView menu_listview_r = (ListView) mMenu_layout_right
				.findViewById(R.id.menu_listView_r);

		menu_listview_l.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, LTITLES));
		menu_listview_r.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, RTITLES));

		// 监听菜单
		menu_listview_l
				.setOnItemClickListener(new DrawerItemClickListenerLeft());
		menu_listview_r
				.setOnItemClickListener(new DrawerItemClickListenerRight());

		// 使用
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

		 fragment = new MainPageFragment();
		ft.replace(R.id.fragment_layout, fragment);
		ft.commit();
	}
	Fragment fragment;
	public static final String[] LTITLES = { "Fragment", "Sdk", "Widget",
			"Drawable", "Service", "I/O", "Broadcast Notifi",
			"Content Provider", "Activity", "Intent", "Animation", "Sensor" };

	/**
	 * 左侧列表点击事件
	 * 
	 * @author busy_boy
	 * 
	 */
	public class DrawerItemClickListenerLeft implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// 使用
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			 fragment = null;

			// 根据item点击行号判断启用哪个Fragment
			switch (position) {
			case 0:
				title = "Fragment";
				fragment = new FragmentMainFragment();
				break;
			case 1:
				title = "Sdk";
				fragment = new SdkMainFragment();
				break;
			case 2:
				title = "Widget";
				fragment = new ViewWidgetFragment();
				break;
			case 3:
				title = "Drawable";
				fragment = new DrawableMainFragment();
				break;
			case 4:
				title = "Service";
				fragment = new ServiceMainFragement();
				break;
			case 5:
				title = "I/O";
				fragment = new FileSqlMainFragement();
				break;
			case 6:
				title = "Broadcast Notifi";
				fragment = new BroadNotiMainFragemnt();
				break;
			case 7:
				title = "Content Provider";
				fragment = new ProviderMainFragement();
				break;
			case 8:
				title = "Activity";
				fragment = new ActivityMainFragment();
				break;
			case 9:
				title = "Intent";
				fragment = new IntentMainFragment();
				break;
			case 10:
				title = "Animation";
				fragment = new AnimationMainFragment();
				break;
			case 11:
				title = "Sensor";
				fragment = new SensorMainFragement();
				break;
			default:
				break;
			}

			ft.replace(R.id.fragment_layout, fragment);
			ft.commit();
			mDrawer_layout.closeDrawer(mMenu_layout_left);// 关闭mMenu_layout
		}

	}

	public static final String[] RTITLES = { "跨平台开发", "网络操作" ,"路吃App","ATV"};

	/**
	 * 右侧列表点击事件
	 * 
	 * @author busy_boy
	 * 
	 */
	private class DrawerItemClickListenerRight implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			 fragment = null;
			// 根据item点击行号判断启用哪个Fragment
			switch (position) {
			case 0:
				title = "跨平台开发";
				fragment = new JqmMainFragement();
				break;
			case 1:
				title = "网络操作";
				fragment = new NetMainFragement();
				break;
			case 2:
				title = "路吃";
				fragment = new MainPageFragment();
				break;
			case 3:
				title = "ATV";
				fragment = new AtvMainFragemnt();
				break;
			default:
				break;
			}
			// 更换布局
			ft.replace(R.id.fragment_layout, fragment);
			ft.commit();
			mDrawer_layout.closeDrawer(mMenu_layout_right);// 关闭mMenu_layout
		}
	}

	/******************************************/

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/* Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// If the nav drawer is open, hide action items related to the content
		// view
		// boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		// menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action buttons
		switch (item.getItemId()) {
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}