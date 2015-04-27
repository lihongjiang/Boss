package com.bslee.ui.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.bslee.boss.R;

public class LocalActivity extends Activity {
    /** Called when the activity is first created. */
    private LocalService mBoundService;
    private boolean mIsBound;

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // 当进程崩溃时将被调用，因为运行在同一程序，如果是崩溃将所以永远不会发生
            // 当解除绑定时也被调用
            mBoundService = null;
            Toast.makeText(LocalActivity.this,
                    R.string.local_service_disconnected, Toast.LENGTH_SHORT)
                    .show();

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // service连接建立时将调用该方法
            mBoundService = ((LocalService.LocalBinder) service).getService();
            Toast.makeText(LocalActivity.this,
                    R.string.local_service_connected, Toast.LENGTH_SHORT)
                    .show();
        }
    };

    void doBindService() {
        // 建立service连接。因为我们知道程序会运行在本地里，因此使用显示的类名来实现service
        // （但是不支持跟其他程序交互）
        // 两种传递，一种是在manifest里写好intent-filter的action，一种是显示传递
        // bindService(new Intent("com.LocalService.LocalService"), mConnection,
        // Context.BIND_AUTO_CREATE);
//         bindService(new Intent(LocalActivity.this, LocalService.class),
//         mConnection, Context.BIND_AUTO_CREATE);
        
        //如果用这种方法将会调用onStartCommand方法
        startService(new Intent(LocalActivity.this, LocalService.class));
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) {
            // Detach our existing connection.
            stopService(new Intent(LocalActivity.this, LocalService.class));
//            unbindService(mConnection);
            mIsBound = false;
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

         doBindService();
    }
}