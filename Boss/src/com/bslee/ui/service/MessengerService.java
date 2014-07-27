package com.bslee.ui.service;

import java.util.ArrayList;

import com.bslee.R;
import com.bslee.ui.DrawerLayoutActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

public class MessengerService extends Service {

	private NotificationManager mNM;

	// 保存所有跟服务连接的客户端
	ArrayList<Messenger> mClients = new ArrayList<Messenger>();
	// 保存最后一次跟服务连接的客户端的标志
	int mValue = 0;
	// 注册指令，Message's replyTo 字段值必须是client 的Messenger
	static final int MSG_REGISTER_CLIENT = 1;
	// 取消指令，Message's replyTo 字段值必须是先前給MSG_REGISTER_CLIENT的Messenger
	static final int MSG_UNREGISTER_CLIENT = 2;
	// 服务发送指令，可以在客户端和服务直接交流
	static final int MSG_SET_VALUE = 3;

	// 处理客户端传送过来的消息
	class IncomingHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case MSG_REGISTER_CLIENT:
				// Optional Messenger where replies to this message can be sent.
				// The semantics of exactly how this is used are up to the
				// sender and receiver.
				mClients.add(msg.replyTo);
				break;
			case MSG_UNREGISTER_CLIENT:
				mClients.remove(msg.replyTo);
				break;
			case MSG_SET_VALUE:
				mValue = msg.arg1;
				for (int i = mClients.size() - 1; i >= 0; i--) {
					try {
						mClients.get(i).send(
								Message.obtain(null, MSG_SET_VALUE, mValue, 0));

					} catch (RemoteException e) {
						// 远程客户端出错，从list中移除
						// 遍历列表以保证内部循环安全运行
						mClients.remove(i);
					}
				}
				break;
			default:
				super.handleMessage(msg);

			}
			Log.i("Service", "有" + mClients.size() + "客户端");
		}
	}

	// 创建一个新的Messenger跟已存在的Handler关联
	// 如果有任何消息发送到Messenger，将交给Handler处理
	final Messenger mMessenger = new Messenger(new IncomingHandler());

	@Override
	public void onCreate() {
		mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// 在service开始时，将icon图标放到通知任务栏
		showNotification();
	}

	//
	private void showNotification() {
		CharSequence text = getText(R.string.local_service_started);

		Notification notification = new Notification(R.drawable.logo, text,
				System.currentTimeMillis());

		// 当点击通知时，启动该contentIntent关联的activity
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				new Intent(this, DrawerLayoutActivity.class), 0);

		// 在通知栏上显示标题和内容
		notification.setLatestEventInfo(this,
				getText(R.string.remote_service_label), text, contentIntent);

		mNM.notify(R.string.remote_service_started, notification);
	}

	//
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("Service", "Received start id " + startId + ": " + intent);
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		mNM.cancel(R.string.remote_service_started);
		Toast.makeText(this, R.string.remote_service_stopped,
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public IBinder onBind(Intent intent) {
		return mMessenger.getBinder();
	}

}