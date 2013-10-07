package com.sudocode.login.db.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.SparseArray;
import com.sudocode.login.db.model.LoginDbContract;
import com.sudocode.login.engine.LoginDbEngine;
import com.sudocode.login.exceptions.LoginProviderExceptions;
import com.sudocode.maximus.logger.Logger;

import java.util.Arrays;
import java.util.IllegalFormatConversionException;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 7:00 AM
 */
public class LoginProvider extends LoginBaseProvider {

    private static final Logger logger = Logger.getLogger(LoginProvider.class);

    private static UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static SparseArray<String[]> mAvailableCol;

    static {
        mUriMatcher.addURI(LoginDbContract.AUTHORITY, LoginDbContract.LoginTable.TABLE_NAME, LoginDbContract.LoginTable.LOGIN_TABLE_ID);
        mAvailableCol = new SparseArray<String[]>(1);
        mAvailableCol.put(LoginDbContract.LoginTable.LOGIN_TABLE_ID, LoginDbContract.LoginTable.LOGIN_COL);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] args, String sort) {

        SQLiteDatabase mLiteDatabase = LoginDbEngine.getInstance().getmLoginDbHelper().getWritableDatabase();
        SQLiteQueryBuilder mQueryBuilder = new SQLiteQueryBuilder();
        Cursor mCursor;

        int matchUri = mUriMatcher.match(uri);

        logger.debug("login service:: uri :: " + uri + " uri matching:: " + matchUri);
        logger.debug("login service:: projection:: " + Arrays.toString(projection) + " selection:: " + selection + " args:: " + Arrays.toString(args));
        logger.debug("login service:: columns:: " + Arrays.toString(projection) + " current:: " + Arrays.toString(mAvailableCol.get(matchUri)));

        if (mAvailableCol.get(matchUri, null) != null && !validProjections(projection, mAvailableCol.get(matchUri))) {
            throw new LoginProviderExceptions("Invalid columns!!!");
        }

        switch (matchUri) {
            case LoginDbContract.LoginTable.LOGIN_TABLE_ID:


                mQueryBuilder.setTables(LoginDbContract.LoginTable.TABLE_NAME);
                mCursor = mQueryBuilder.query(mLiteDatabase, projection, selection, args, null, null, sort);
                break;
            default:
                throw new LoginProviderExceptions("Unknown uri:: " + uri);
        }

        if (mCursor != null) {
            mCursor.setNotificationUri(getContext().getContentResolver(), uri);
        }

        return mCursor;
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
            case LoginDbContract.LoginTable.LOGIN_TABLE_ID:
                rowId = mLiteDatabase.insertOrThrow(LoginDbContract.LoginTable.TABLE_NAME, null, contentValues);
                break;
            default:
                throw new LoginProviderExceptions("Unknown uri:: " + uri);
        }

        logger.debug("login service :: row Id :: " + rowId);

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
