package admin.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import employee.models.attendanceModel;

/**
 * Created by Darshan Soni on 04-05-2023.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "piggybank.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your admin.database tables here

        String SQL_CREATE_ATTENDANCE_TABLE = "CREATE TABLE " + attendanceModel.AttendanceEntry.TABLE_NAME + " ("
                + attendanceModel.AttendanceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + attendanceModel.AttendanceEntry.COLUMN_IMAGE + " BLOB NOT NULL, "
                + attendanceModel.AttendanceEntry.COLUMN_ATTENDANCE_ID + " TEXT NOT NULL, "
                + attendanceModel.AttendanceEntry.COLUMN_EMPLOYEE_ID + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_ATTENDANCE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade your admin.database tables here
    }

}
