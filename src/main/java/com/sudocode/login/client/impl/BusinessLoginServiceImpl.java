package com.sudocode.login.client.impl;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import com.sudocode.login.client.service.BusinessLoginService;
import com.sudocode.login.db.model.LoginDbContract;
import com.sudocode.login.engine.LoginEngine;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/27/13
 * Time: 6:57 AM
 */
public class BusinessLoginServiceImpl extends AsyncQueryHandler implements BusinessLoginService {

    private static final Logger logger = Logger.getLogger(BusinessLoginServiceImpl.class);

    private static final int QUERY_USER = 0x0407;

    private ContentResolver mContentResolver;

    public BusinessLoginServiceImpl(ContentResolver mContentResolver) {
        super(mContentResolver);
        this.mContentResolver = mContentResolver;
    }

    public static BusinessLoginService getInstance() {
        return LoginService.getInstance();
    }

    /**
     * Validates if user exist on the login table
     *
     * @param userName User name to check against the login table
     * @param password Password of the current user to login.
     */
    @Override
    public boolean isUserExist(String userName, String password) {

        Cursor mCursor = null;

        if (mContentResolver != null) {

            logger.debug("login service:: START");

//            String[] mArgs = {userName};
            mCursor = mContentResolver.query(LoginDbContract.LoginTable.LOGIN_URI, LoginDbContract.LoginTable.LOGIN_COL, LoginDbContract.LoginTable.WHERE_LOGIN, null, null);

            if (mCursor != null) {

            }
        }

        return false;
    }

    /**
     * If user does not exist, user may have the option to add record on the login table.
     *
     * @param contentValues
     */
    @Override
    public void insertUserAccount(ContentValues contentValues) {

        if (contentValues != null) {
            logger.debug("login service:: insert values :: START :: " + contentValues.getAsString(UNAME));
//            mContentResolver.insert(LoginDbContract.LoginTable.LOGIN_URI, contentValues);
        }

    }

    /**
     * Thread safe initialization
     */
    private static class LoginService {

        private static BusinessLoginService instance;

        private static final BusinessLoginService getInstance() {
            if (instance == null)
                instance = new BusinessLoginServiceImpl(LoginEngine.getmContext().getContentResolver());
            return instance;
        }
    }
}
