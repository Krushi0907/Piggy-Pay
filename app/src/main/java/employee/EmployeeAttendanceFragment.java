package employee;

import static android.app.Activity.RESULT_OK;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.krushi_project.R;

import java.io.ByteArrayOutputStream;

import admin.database.DatabaseHelper;
import employee.models.attendanceModel;

public class EmployeeAttendanceFragment extends Fragment {

    private static final int CAMERA_REQUEST_CODE = 1;

    DatabaseHelper dbHelper = new DatabaseHelper(getContext());
    SQLiteDatabase db = dbHelper.getWritableDatabase();

    Bitmap photo;
    byte[] imageBytes;

    ImageView imageView;
    EditText attendanceIdEditText, employeeIdEditText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_attendance_employee, container, false);

        Button captureButton = root.findViewById(R.id.capture_button);
         imageView = root.findViewById(R.id.image_view);
         attendanceIdEditText = root.findViewById(R.id.attendance_id_edittext);
         employeeIdEditText = root.findViewById(R.id.employee_id_edittext);

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
            imageBytes = stream.toByteArray();
            // Do something with the photo (e.g. display it in an ImageView)
        }
    }

    public void sendAttendance(View view) {
        ContentValues values = new ContentValues();
        values.put(attendanceModel.AttendanceEntry.COLUMN_IMAGE, imageBytes);
        values.put(attendanceModel.AttendanceEntry.COLUMN_ATTENDANCE_ID, attendanceIdEditText.getText().toString());
        values.put(attendanceModel.AttendanceEntry.COLUMN_EMPLOYEE_ID, employeeIdEditText.getText().toString());

        long newRowId = db.insert(attendanceModel.AttendanceEntry.TABLE_NAME, null, values);

        db.close();

    }
}