package com.sudocode.login.db.model;

import android.content.Context;
import android.provider.BaseColumns;
import com.sudocode.login.R;
import com.sudocode.login.engine.LoginEngine;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/26/13
 * Time: 5:51 AM
 */
public final class LoginDbContract {

    public static final String AUTHORITY = "com.login.provider.contract";
    private static final String BASE_PATH = "login";


    public static interface LoginTable extends BaseColumns {

        Context mContext = LoginEngine.getmContext();
        String TABLE_NAME = mContext.getString(R.string.tableName);

        String CREATE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + _ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + mContext.getString(R.string.columnFname) + " TEXT, " + mContext.getString(R.string.columnUserName)
                + " TEXT );";

        String DROP_SQL = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
