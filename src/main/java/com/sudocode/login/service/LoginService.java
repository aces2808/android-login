package com.sudocode.login.service;

import android.app.Service;
import android.content.Intent;
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

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
