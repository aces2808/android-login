package com.sudocode.login.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sudocode.login.db.model.LoginDbContract;
import com.sudocode.maximus.logger.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: aces28
 * Date: 9/26/13
 * Time: 5:44 AM
 */
public class LoginDbHelper extends SQLiteOpenHelper {

    private static final Logger logger = Logger.getLogger(LoginDbHelper.class);

    private static final int DB_VER = 0x02;
    private static final String DB_NAME = "login.sqlite";

    public LoginDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        logger.debug("login service:: " + LoginDbContract.LoginTable.CREATE_SQL);
        logger.debug("login service:: login Uri:: " + LoginDbContract.LoginTable.LOGIN_URI);

        sqLiteDatabase.execSQL(LoginDbContract.LoginTable.CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL(LoginDbContract.LoginTable.DROP_SQL);
    }
}
