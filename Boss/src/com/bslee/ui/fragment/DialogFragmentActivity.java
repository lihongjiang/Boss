package com.bslee.ui.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bslee.boss.R;

//使用DialogFragment类来显示和管理一个AlertDialog对话框

public class DialogFragmentActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		// 把布局文件填充到Activity中
		setContentView(R.layout.dialogfragment_main);
		// 查找布局中的text元素，并设置要显示的文本。
		View tv = findViewById(R.id.text);
		((TextView) tv)
				.setText("Example of displaying an alert dialog with a DialogFragment");
		// 查找布局中的show按钮，并设置点击事件监听器。用户点击时该按钮时，显示一个Fragment对话框。
		Button button = (Button) findViewById(R.id.show);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog();
			}
		});

		Button button2 = (Button) findViewById(R.id.show2);
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog2();
			}
		});
	}

	/**********************/

	public void showDialog() {
		// 获取Fragment对话框实例，在获取实例的时候，设置这个对话框的标题。
		DialogFragment newFragment = MyAlertDialogFragment
				.newInstance(R.string.app_name);
		newFragment.show(getSupportFragmentManager(), "dialog1");
	}

	public void showDialog2() {
		// 获取Fragment对话框实例，在获取实例的时候，设置这个对话框的标题。
		MyDialogFragment mdf = new MyDialogFragment();
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		mdf.show(ft, "dialog2");
	}

	public void doPositiveClick() {

		Log.i("FragmentAlertDialog", "Positive click!");

	}

	public void doNegativieClick() {

		Log.i("FragmentAlertDialog", "Negative click");

	}

	public static class MyAlertDialogFragment extends DialogFragment {

		public static MyAlertDialogFragment newInstance(int title) {

			MyAlertDialogFragment frag = new MyAlertDialogFragment();
			Bundle args = new Bundle();
			args.putInt("title", title);
			frag.setArguments(args);
			return frag;
		}

		public Dialog onCreateDialog(Bundle saveInstanceState) {
			// 获取对象实例化时传入的窗口标题。
			int title = getArguments().getInt("title");
			// 返回提醒对话框。
			return new AlertDialog.Builder(getActivity())
					// 设置标题图标
					.setIcon(R.drawable.ic_drawer)
					// 设置标题
					.setTitle(title)
					.setMessage("你确定退出系统吗?")
					// 设置确定按钮的标题和点击事件监听器。
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									((DialogFragmentActivity) getActivity())
											.doPositiveClick();
								}
							})
					// 设置取消按钮的标题和点击事件监听器。
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									((DialogFragmentActivity) getActivity())
											.doNegativieClick();
								}
							})
					// 创建对话框
					.create();
		}
	}

	/********* */
	@SuppressLint("ValidFragment")
	public class MyDialogFragment extends DialogFragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View v = inflater.inflate(R.layout.dialog, container, false);
			return v;
		}
	}
}