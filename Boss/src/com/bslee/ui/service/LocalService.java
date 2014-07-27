package com.bslee.ui.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.bslee.R;
import com.bslee.ui.DrawerLayoutActivity;

public class LocalService extends Service {

    private NotificationManager mNM;

    // 通知唯一标示，在通知开始和结束使用
    private int NOTIFICATION = R.string.local_service_started;

    // 与界面交互的类，由于service跟界面总是运行在同一程序里，所以不用处理IPC
    public class LocalBinder extends Binder {
        LocalService getService() {
            return LocalService.this;
        }
    }

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
                getText(R.string.local_service_label), text, contentIntent);

        mNM.notify(NOTIFICATION, notification);
    }

    // 兼容2.0以前版本
    @Override
    public void onStart(Intent intent, int startId) {
    }

    // 在2.0以后的版本如果重写了onStartCommand，那onStart将不会被调用，注：在2.0以前是没有onStartCommand方法
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("Service", "Received start id " + startId + ": " + intent);
        // 如果服务进程在它启动后(从onStartCommand()返回后)被kill掉, 那么让他呆在启动状态但不取传给它的intent.
        // 随后系统会重写创建service，因为在启动时，会在创建新的service时保证运行onStartCommand
        // 如果没有任何开始指令发送给service，那将得到null的intent，因此必须检查它.
        // 该方式可用在开始和在运行中任意时刻停止的情况，例如一个service执行音乐后台的重放
        
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mNM.cancel(NOTIFICATION);
        Toast
                .makeText(this, R.string.local_service_stopped,
                        Toast.LENGTH_SHORT).show();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final IBinder mBinder = new LocalBinder();

}