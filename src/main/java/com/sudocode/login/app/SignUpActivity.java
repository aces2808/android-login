package com.sudocode.login.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.sudocode.login.R;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 9:38 AM
 */
public class SignUpActivity extends Activity {

    private static final Logger logger = Logger.getLogger(SignUpActivity.class);
//    private TextView mTextView;
//    private Bundle mBundle;

    private EditText mUserName;
    private EditText mFname;
    private EditText mLname;
    private EditText mPassword;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_layout);
        initComponents();

//        mTextView = (TextView) findViewById(R.id.tvTempTitle);
//
//        if (getIntent().getExtras() != null) {
//            mBundle = getIntent().getExtras();
//            final String userName = mBundle.get("userName").toString();
//
//            logger.debug("Check user name field:: " + userName);
////            mTextView.setText("Hello " + userName);
//
//        }
    }

    private void initComponents() {
        mUserName = (EditText) findViewById(R.id.etSignUpUserName);
        mFname = (EditText) findViewById(R.id.etFname);
        mLname = (EditText) findViewById(R.id.etLname);
        mPassword = (EditText) findViewById(R.id.etPassword);
    }

    public void onSubmit(View view) {
        logger.debug("Login :: First name:: " + mFname.getText() + " Last name:: " + mLname.getText() + " User name:: " + mUserName.getText() + " Password:: " + mPassword.getText());
    }

}