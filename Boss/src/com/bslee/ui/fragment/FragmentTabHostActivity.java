package com.bslee.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.bslee.R;
import com.bslee.ui.widget.FirstFragment;

public class FragmentTabHostActivity extends FragmentActivity {


    private com.bslee.widget.FragmentTabHost mTabHost;

    private Class<?> fragmentArray[] = {
            FirstFragment.class,
            FirstFragment.class,
            FirstFragment.class,};
    private int iconArray[] = {
            R.drawable.icon_http,
            R.drawable.icon_database,
            R.drawable.icon_btimap};
    private String titleArray[] = {
            "Http",
            "db",
            "Bitmap"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmenttabhost);

        mTabHost=(com.bslee.widget.FragmentTabHost) findViewById(R.id.tabhost);
        setupTabView();
    }

    private void setupTabView() {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);

        int count = fragmentArray.length;

        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(titleArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_item);
        }

    }

    private View getTabItemView(int index) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.tab_bottom_nav, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
        imageView.setImageResource(iconArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.tv_icon);
        textView.setText(titleArray[index]);

        return view;
    }
}
