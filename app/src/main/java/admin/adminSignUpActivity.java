package admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.krushi_project.R;

public class adminSignUpActivity extends AppCompatActivity {

    EditText editTextName;
    String name;

    EditText editTextEmail;
    String email;

    EditText editTextPassword;
    String password;

    EditText editTextAdminId;
    String adminId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        editTextName = findViewById(R.id.edit_text_name);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);
        editTextAdminId = findViewById(R.id.edit_text_admin_id);

        name = editTextName.getText().toString();
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        adminId = editTextAdminId.getText().toString();


    }

    public void adminSignUp(View view) {

        Intent intent = new Intent(adminSignUpActivity.this, adminLoginActivity.class);
        startActivity(intent);

    }
}