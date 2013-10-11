package com.sudocode.login.db.helper;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import java.lang.ref.WeakReference;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 10/11/13
 * Time: 5:15 PM
 */
public class LoginQueryHelper extends AsyncQueryHandler {

    public LoginQueryHelper(ContentResolver cr, NotifyQueryListener queryListener) {
        super(cr);
        mAsyncQueryListener = (queryListener != null) ? new WeakReference<NotifyQueryListener>(queryListener) : null;
    }

    private WeakReference<NotifyQueryListener> mAsyncQueryListener;


    public interface NotifyQueryListener {

        int QUERY_PK_COMPLETE = 0x2808;

        void onRetrieveComplete(Cursor cursor);
    }


    @Override
    protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
        super.onQueryComplete(token, cookie, cursor);
        final NotifyQueryListener mNotifyQueryListener = (mAsyncQueryListener == null) ? null : mAsyncQueryListener.get();

        if (mNotifyQueryListener != null) {
            mNotifyQueryListener.onRetrieveComplete(cursor);
        } else {
            cursor.close();
        }
    }

    public void startQuery(Uri uri, String[] projection, String selection, String[] selectionArgs) {
        startQuery(NotifyQueryListener.QUERY_PK_COMPLETE, null, uri, projection, selection, selectionArgs, null);
    }
}
