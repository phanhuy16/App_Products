package com.example.nguyenphanhuy.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.nguyenphanhuy.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ConstraintLayout btnNext = findViewById(R.id.btnNext);
        ConstraintLayout createRegiter = findViewById(R.id.createRegiter);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                EditText objUser = findViewById(R.id.user);
                String dataUser = objUser.getText().toString();
                it.putExtra("user", dataUser);

                EditText objPassword = findViewById(R.id.password);
                String dataPassword = objPassword.getText().toString();
                it.putExtra("password", dataPassword);

                String user = "huy";
                String password = "123456";
                if (dataUser.equals(user) && dataPassword.equals(password)) {
                    startActivity(it);
                } else {
                    CharSequence text = "Erorr login";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(LoginActivity.this, text, duration);
                    toast.show();
                }
            }
        });


        createRegiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegiterActivity.class));
            }
        });
    }
}