package com.sudocode.login.client.service;

import android.content.ContentValues;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/27/13
 * Time: 6:52 AM
 */
public interface LoginService {


    /**
     * Validates if user exist on the login table
     *
     * @param userName User name to check against the login table
     * @param password Password of the current user to login.
     */
    boolean isUserExist(final String userName, final String password);

    /**
     * If user does not exist, user may have the option to add record on the login table.
     *
     * @param contentValues
     */
    void insertUserAccount(ContentValues contentValues);

}
