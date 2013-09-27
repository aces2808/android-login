package com.sudocode.login.engine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sudocode.login.db.helper.LoginDbHelper;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/26/13
 * Time: 6:10 AM
 */
public class LoginDbEngine {

    private static LoginDbEngine mLoginDbEngine;
    private LoginDbHelper mLoginDbHelper;
    private SQLiteDatabase mLiteDatabase;

    public LoginDbEngine(Context mContext) {
        mLoginDbHelper = new LoginDbHelper(mContext);
    }

    public static void init(Context mContext) {
        if (mLoginDbEngine == null) {
            mLoginDbEngine = new LoginDbEngine(mContext);
        }
    }

    public static LoginDbEngine getInstance() {
        return mLoginDbEngine;
    }

    /**
     * Opens a writable database
     */
    public void open() {
        if (mLiteDatabase == null || (mLiteDatabase != null && !mLiteDatabase.isOpen())) {
            mLiteDatabase = mLoginDbHelper.getWritableDatabase();
        }
    }

    /**
     * Closes the current database used.
     */
    public void close() {
        mLoginDbHelper.getWritableDatabase().close();
        mLoginDbHelper.close();
    }

    public LoginDbHelper getmLoginDbHelper() {
        return mLoginDbHelper;
    }
}
