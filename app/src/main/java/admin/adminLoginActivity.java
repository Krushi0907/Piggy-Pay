package admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.krushi_project.R;

public class adminLoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


    }

    public void adminLogin(View view) {
        Intent intent = new Intent(adminLoginActivity.this, piggyBankActivity.class);
        startActivity(intent);
    }

    public void onSignUpTextClick(View view) {

        Intent intent = new Intent(adminLoginActivity.this, adminSignUpActivity.class);
        startActivity(intent);

    }
}