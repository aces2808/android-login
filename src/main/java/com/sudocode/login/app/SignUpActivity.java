package com.sudocode.login.app;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.sudocode.login.R;
import com.sudocode.login.client.impl.BusinessLoginServiceImpl;
import com.sudocode.login.client.service.BusinessLoginService;
import com.sudocode.maximus.logger.Logger;
import com.sudocode.maximus.util.TextUtil;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 9:38 AM
 */
public class SignUpActivity extends Activity {

    private static final Logger logger = Logger.getLogger(SignUpActivity.class);

    private BusinessLoginService mLoginService;

    private EditText mUserName;
    private EditText mFname;
    private EditText mLname;
    private EditText mPassword;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_layout);

        mLoginService = BusinessLoginServiceImpl.getInstance();

        initComponents();
    }

    private void initComponents() {
        mUserName = (EditText) findViewById(R.id.etSignUpUserName);
        mFname = (EditText) findViewById(R.id.etFname);
        mLname = (EditText) findViewById(R.id.etLname);
        mPassword = (EditText) findViewById(R.id.etPassword);
    }

    public void onSubmit(View view) {

        logger.debug("login service:: :: First name:: " + mFname.getText() + " Last name:: " + mLname.getText() + " User name:: " + mUserName.getText() + " Password:: " + mPassword.getText());

        final ContentValues mContentValues = new ContentValues();

        String uname = mUserName.getText().toString();
        String fname = mFname.getText().toString();
        String lname = mLname.getText().toString();
        String passwd = mPassword.getText().toString();

        if (TextUtil.isNullOrEmpty(fname) || TextUtil.isNullOrEmpty(lname) || TextUtil.isNullOrEmpty(uname) || TextUtil.isNullOrEmpty(passwd)) {

            Toast.makeText(this, "Please fill-in all fields!!!", Toast.LENGTH_SHORT).show();

        } else {

            mContentValues.put(BusinessLoginService.FNAME, fname);
            mContentValues.put(BusinessLoginService.LNAME, lname);
            mContentValues.put(BusinessLoginService.UNAME, uname);
            mContentValues.put(BusinessLoginService.PASSWD, passwd);

        }


        mLoginService.insertUserAccount(mContentValues);
    }

}