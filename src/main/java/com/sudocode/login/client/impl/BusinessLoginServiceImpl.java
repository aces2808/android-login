package com.sudocode.login.client.impl;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import com.sudocode.login.client.service.BusinessLoginService;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/27/13
 * Time: 6:57 AM
 */
public class BusinessLoginServiceImpl extends AsyncQueryHandler implements BusinessLoginService {

    private static final Logger logger = Logger.getLogger(BusinessLoginServiceImpl.class);

    private ContentResolver mContentResolver;

    public BusinessLoginServiceImpl(ContentResolver mContentResolver) {
        super(mContentResolver);
        this.mContentResolver = mContentResolver;
    }

    /**
     * Validates if user exist on the login table
     *
     * @param userName User name to check against the login table
     * @param password Password of the current user to login.
     */
    @Override
    public boolean isUserExist(String userName, String password) {
        return false;
    }

    /**
     * If user does not exist, user may have the option to add record on the login table.
     *
     * @param contentValues
     */
    @Override
    public void insertUserAccount(ContentValues contentValues) {
    }
}
