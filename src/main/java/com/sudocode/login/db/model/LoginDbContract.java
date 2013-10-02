package com.sudocode.login.db.model;

import android.net.Uri;
import android.provider.BaseColumns;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/26/13
 * Time: 5:51 AM
 */
public final class LoginDbContract {

    public static final String AUTHORITY = "com.login.db.provider.contract.login";
    private static final String BASE_PATH = "base-login";

    public static interface LoginTable extends BaseColumns {

        final Logger logger = Logger.getLogger(LoginDbContract.class);

        String TABLE_NAME = "LoginTable";
        String USER_COL = "UserName";
        String FNAME_COL = "FirstName";
        String LNAME_COL = "LastName";
        String PASSWD_COL = "Password";


        String CREATE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + _ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_COL + " TEXT, " + FNAME_COL
                + " TEXT );";

        String DROP_SQL = "DROP TABLE IF EXISTS " + TABLE_NAME;

        Uri LOGIN_URI = Uri.parse("content://" + AUTHORITY + BASE_PATH);

        String[] LOGIN_COL = {_ID, USER_COL, FNAME_COL};
        String WHERE_LOGIN = USER_COL + " = ?";

    }

}
