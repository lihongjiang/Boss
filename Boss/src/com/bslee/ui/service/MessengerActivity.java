package com.bslee.ui.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.widget.TextView;
import android.widget.Toast;

import com.bslee.R;

public class MessengerActivity extends Activity {
	/** Called when the activity is first created. */
	private Messenger mService = null;

	private boolean mIsBound;

	private TextView mCallbackText;

	class IncomingHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MessengerService.MSG_SET_VALUE:
				mCallbackText.setText("Received from service: " + msg.arg1);
				break;
			default:
				super.handleMessage(msg);
			}
		}
	}

	final Messenger mMessenger = new Messenger(new IncomingHandler());

	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// 当进程崩溃时将被调用，因为运行在同一程序，如果是崩溃将所以永远不会发生
			// 当解除绑定时也被调用
			mService = null;
			mCallbackText.setText("Disconnected.");

			Toast.makeText(MessengerActivity.this,
					R.string.remote_service_disconnected, Toast.LENGTH_SHORT)
					.show();

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// service连接建立时将调用该方法
			// 返回IBinder接口以便我们可以跟service关联。
			// 我们可通过IDL接口来交流
			mService = new Messenger(service);
			mCallbackText.setText("Attached.");

			// 只有我们连接着都监听着服务
			try {
				// 注册
				Message msg = Message.obtain(null,
						MessengerService.MSG_REGISTER_CLIENT);
				msg.replyTo = mMessenger;
				mService.send(msg);

				// 例子
				msg = Message.obtain(null, MessengerService.MSG_SET_VALUE,
						11111111, 0);
				mService.send(msg);
			} catch (RemoteException e) {
				// In this case the service has crashed before we could even
				// do anything with it; we can count on soon being
				// disconnected (and then reconnected if it can be restarted)
				// so there is no need to do anything here.
			}
			Toast.makeText(MessengerActivity.this,
					R.string.remote_service_connected, Toast.LENGTH_SHORT)
					.show();
		}
	};

	void doBindService() {
		bindService(new Intent(MessengerActivity.this, MessengerService.class),
				mConnection, Context.BIND_AUTO_CREATE);
		mIsBound = true;
		mCallbackText.setText("Binding.");

	}

	void doUnbindService() {
		if (mIsBound) {
			if (mService != null) {
				try {
					// 取消注册
					Message msg = Message.obtain(null,
							MessengerService.MSG_UNREGISTER_CLIENT);
					msg.replyTo = mMessenger;
					mService.send(msg);
				} catch (RemoteException e) {
					// There is nothing special we need to do if the service
					// has crashed.
				}
			}

			// Detach our existing connection.
			unbindService(mConnection);
			mIsBound = false;
			mCallbackText.setText("Unbinding.");

		}
	}

	@Override
	protected void onDestroy() {
		doUnbindService();
		super.onDestroy();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.messenger);
		mCallbackText = (TextView) findViewById(R.id.text);
		doBindService();
	}
}