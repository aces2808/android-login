package com.sudocode.login.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.sudocode.login.R;
import com.sudocode.login.client.impl.BusinessLoginServiceImpl;
import com.sudocode.login.client.service.BusinessLoginService;
import com.sudocode.login.constants.Login;
import com.sudocode.maximus.logger.Logger;

public class LoginActivity extends Activity {

    private static final Logger logger = Logger.getLogger(LoginActivity.class);

    private BusinessLoginService mLoginService;

    private EditText mUserName;
    private EditText mPassword;

    /**
     * Called when the login is first created.
     *
     * @param savedInstanceState If the login is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginService = BusinessLoginServiceImpl.getInstance();
        initWidgets();
    }

    private void initWidgets() {
        mUserName = (EditText) findViewById(R.id.etUserName);
        mPassword = (EditText) findViewById(R.id.etPassword);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.sudocode.login.R.menu.main, menu);
        return true;
    }


    /**
     * This method is bind from the callback method defined in the layout xml.
     */
    public void onLogin(View view) {

        if (TextUtils.isEmpty(mUserName.getText()) ||
                TextUtils.isEmpty(mPassword.getText())) {

            Toast.makeText(getApplicationContext(),
                    "Please enter user name and password", Toast.LENGTH_SHORT).show();
        } else {

            logger.debug(" user name:: " + mUserName.getText().toString()
                    + " password:: " + mPassword.getText().toString());

            if (mLoginService.isUserExist(mUserName.getText().toString(),
                    mPassword.getText().toString())) {

                Toast.makeText(this, "You have successfully logged in!!!",
                        Toast.LENGTH_SHORT).show();

                final Intent mIntent = new Intent();
                mIntent.setAction(Login.LOGIN_SUCCESS);
                sendBroadcast(mIntent);
                finish();

            } else {

                Toast.makeText(this, "User does not exist/ password is invalid",
                        Toast.LENGTH_SHORT).show();

            }
        }


    }

    /**
     * This method is bind from the callback method defined in the layout xml.
     */
    public void onSignUp(View view) {

        logger.debug("login service:: sign-up screen :: " + getApplicationContext().getResources().getString(view.getId()));

        Intent mUserListIntent = new Intent(getApplicationContext(), SignUpActivity.class);
        mUserListIntent.putExtra("userName", mUserName.getText());
        mUserListIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(mUserListIntent);

    }

}

