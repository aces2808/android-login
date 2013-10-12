package com.sudocode.login.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 8:26 AM
 */
public class LoginService extends Service {

    private static final Logger logger = Logger.getLogger(LoginService.class);
    private IBinder mIBinder = new LoginBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    private class LoginBinder extends Binder {
        LoginService getLocalService() {
            return LoginService.this;
        }
    }
}
