package com.sudocode.login.db.provider;

import android.content.ContentProvider;
import android.net.Uri;
import com.sudocode.maximus.logger.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/25/13
 * Time: 7:19 AM
 */
public abstract class LoginBaseProvider extends ContentProvider {

    protected static final Logger logger = Logger.getLogger(LoginBaseProvider.class);

    @Override
    public boolean onCreate() {
        return true;
    }

    /**
     * Identify if provided columns are defined in the provider.
     *
     * @param actualProjections    columns that are being requested
     * @param availableProjections columns that are made available by the contracts
     */
    protected boolean validProjections(final String[] actualProjections, final String[] availableProjections) {
        if (actualProjections != null && actualProjections != null) {
            Set<String> requestedColumns = new HashSet<String>(Arrays.asList(actualProjections));
            Set<String> availableColumns = new HashSet<String>(Arrays.asList(availableProjections));

            return availableColumns.containsAll(requestedColumns);
        }

        return false;
    }

}
