package com.sudocode.login.exceptions;

import android.net.Uri;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 7:22 AM
 */
public class LoginProviderExceptions extends IllegalArgumentException {


    private static final long serialVersionUID = 6494380431651743504L;

    public LoginProviderExceptions() {
        super("Unknown URI");
    }

    public LoginProviderExceptions(Uri uri) {
        super("Unknown URI: " + uri.toString());
    }

    public LoginProviderExceptions(String message) {
        super(message);
    }

    public LoginProviderExceptions(String message, Throwable cause) {
        super(message);
        _cause = cause;
    }

    @Override
    public Throwable getCause() {
        return (_cause);
    }

    protected Throwable _cause = null;
}
