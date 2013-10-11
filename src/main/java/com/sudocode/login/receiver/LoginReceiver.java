package com.sudocode.login.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sudocode.login.R;
import com.sudocode.login.constants.Login;
import com.sudocode.maximus.logger.Logger;
import com.sudocode.maximus.util.SmsUtil;
import com.sudocode.maximus.util.TextUtil;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 8:29 AM
 */
public class LoginReceiver extends BroadcastReceiver {


    private static final Logger logger = Logger.getLogger(LoginReceiver.class);

    @Override
    public void onReceive(Context context, Intent intent) {

        String remoteAddr = context.getResources().getString(R.string.remote_address);
        String message = context.getResources().getString(R.string.default_sms_message);

        if (!TextUtil.isNullOrEmpty(intent.getAction())) {

            logger.debug("login service:: action:: " + intent.getAction());

            if (Login.LOGIN_SUCCESS.equals(intent.getAction())) {
                SmsUtil.sendSms(context, remoteAddr, message);
            }
        }
    }
}
