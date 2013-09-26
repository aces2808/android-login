package com.sudocode.login.engine;

import android.app.Application;
import android.content.Context;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 7:02 AM
 */
public class LoginEngine extends Application {

    private static final Logger logger = Logger.getLogger(LoginEngine.class);
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        logger.debug("start loading application services");

        LoginEngine.mContext = this;

        /*
         *  Initialize database
         */
        LoginDbEngine.init(this);
        LoginDbEngine.getInstance().open();


    }

    public static Context getmContext() {
        return mContext;
    }
}
