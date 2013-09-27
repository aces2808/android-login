package com.sudocode.login.db.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.sudocode.login.db.model.LoginDbContract;
import com.sudocode.login.engine.LoginDbEngine;
import com.sudocode.login.exceptions.LoginProviderExceptions;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 7:00 AM
 */
public class LoginProvider extends LoginBaseProvider {

    private static final Logger logger = Logger.getLogger(LoginProvider.class);

    public static final Uri URI = Uri.parse("content://" + LoginDbContract.AUTHORITY + "/" + LoginDbContract.LoginTable.TABLE_NAME);

    private static UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int LOGIN_CODE = 0x2808;

    static {
        mUriMatcher.addURI(LoginDbContract.AUTHORITY, LoginDbContract.LoginTable.TABLE_NAME, LOGIN_CODE);
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        SQLiteDatabase mLiteDatabase = LoginDbEngine.getInstance().getmLoginDbHelper().getWritableDatabase();

        long rowId = 0;

        switch (mUriMatcher.match(uri)) {
            case LOGIN_CODE:
                rowId = mLiteDatabase.insert(LoginDbContract.LoginTable.TABLE_NAME, null, contentValues);
                break;
            default:
                throw new LoginProviderExceptions("Unknown uri:: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(LoginDbContract.LoginTable.TABLE_NAME + "/" + rowId);
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
