package com.sudocode.login.app;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.sudocode.login.R;
import com.sudocode.maximus.logger.Logger;

public class LoginActivity extends Activity {

    private static final Logger logger = Logger.getLogger(LoginActivity.class);

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


    public void onLogin(View view) {
        if (TextUtils.isEmpty(mUserName.getText()) || TextUtils.isEmpty(mPassword.getText())) {
            Toast.makeText(getApplicationContext(), "Please enter user name and password", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSignUp(View view) {
        logger.debug("Call sign-up screen");
    }
}

