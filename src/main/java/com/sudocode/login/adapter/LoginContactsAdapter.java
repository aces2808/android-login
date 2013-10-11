package com.sudocode.login.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 10/10/13
 * Time: 8:51 PM
 */
public class LoginContactsAdapter extends CursorAdapter {

    private static final Logger logger = Logger.getLogger(LoginContactsAdapter.class);

    private LayoutInflater mLayoutInflater;

    public LoginContactsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
    }

    static class ViewHolder {
        TextView mContactView;
    }
}
