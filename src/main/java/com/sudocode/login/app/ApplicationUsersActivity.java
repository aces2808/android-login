package com.sudocode.login.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.sudocode.login.R;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 9:38 AM
 */
public class ApplicationUsersActivity extends Activity {

    private static final Logger logger = Logger.getLogger(ApplicationUsersActivity.class);
    private TextView mTextView;
    private Bundle mBundle;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);

        mTextView = (TextView) findViewById(R.id.tvTempTitle);

        if (getIntent().getExtras() != null) {
            mBundle = getIntent().getExtras();
            final String userName = mBundle.get("userName").toString();

            logger.debug("Check user name field:: " + userName);
            mTextView.setText("Hello " + userName);

        }
    }


}