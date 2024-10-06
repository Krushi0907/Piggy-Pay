package employee.models;

import android.provider.BaseColumns;

/**
 * Created by Darshan Soni on 04-05-2023.
 */
public class attendanceModel {


    public static abstract class AttendanceEntry implements BaseColumns {
        public static final String TABLE_NAME = "attendance";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_ATTENDANCE_ID = "attendance_id";
        public static final String COLUMN_EMPLOYEE_ID = "employee_id";
    }

}
