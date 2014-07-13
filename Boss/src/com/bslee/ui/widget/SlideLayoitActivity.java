package com.bslee.ui.widget;

import com.bslee.R;
import com.bslee.ui.widget.BookMarkerFragment.BookmarkListener;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SlideLayoitActivity extends FragmentActivity implements
		BookmarkListener {

	Fragment bookmarkerFragment;
	Fragment showFragment;
	SlidingPaneLayout spl = null;
	ActionBar actionBar = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slidelayout_main);
		actionBar = this.getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);// 不显示标题
		actionBar.setDisplayHomeAsUpEnabled(true);// 显示返回
		spl = (SlidingPaneLayout) this.findViewById(R.id.slidingpanellayout);
		spl.setPanelSlideListener(new PanelSlideListener() {
			@Override
			public void onPanelClosed(View view) {
				SlideLayoitActivity.this.getFragmentManager()
						.findFragmentById(R.id.leftfragment)
						.setHasOptionsMenu(false);
			}

			@Override
			public void onPanelOpened(View viw) {
				SlideLayoitActivity.this.getFragmentManager()
						.findFragmentById(R.id.leftfragment)
						.setHasOptionsMenu(true);
			}

			@Override
			public void onPanelSlide(View arg0, float arg1) {

			}
		});
	}

	@Override
	public void onChangeBookmark(String bookmark) {
		ShowFragment sf = (ShowFragment) SlideLayoitActivity.this
				.getFragmentManager().findFragmentById(R.id.rightfragment);
		WebView webView = sf.getWebView();
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		WebViewClient client = new WebViewClient();
		webView.setWebViewClient(client);
		webView.loadUrl(bookmark);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}

		return super.onOptionsItemSelected(item);
	}

}