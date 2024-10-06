package admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import com.example.krushi_project.R;

import employee.EmployeeAttendanceFragment;
import employee.EmployeeNavigationActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerRole;
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerRole = findViewById(R.id.spinner_role);
    }

    public void nextClick(View view) {
        role = spinnerRole.getSelectedItem().toString();

        Log.d("roleee", "" + role);
        Intent intent;
        if(role.equals("Admin")){
            intent = new Intent(MainActivity.this, adminLoginActivity.class);

        }else{
            intent = new Intent(MainActivity.this, EmployeeNavigationActivity.class);

        }
        startActivity(intent);
    }
}