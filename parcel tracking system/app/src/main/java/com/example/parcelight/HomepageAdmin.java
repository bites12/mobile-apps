package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomepageAdmin extends AppCompatActivity {

    CardView admin;
    EditText adminName, adminPass;
    Button login,logout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepageadmin);

        admin = (CardView) findViewById(R.id.card_admin);
        adminName = (EditText) findViewById(R.id.admin_name);
        adminPass = (EditText) findViewById(R.id.admin_pass);
        login = (Button) findViewById(R.id.login_admin);
        logout = (Button) findViewById(R.id.logout_admin);

        ClickLogin();
    }


    private void ClickLogin() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String admin_name = adminName.getText().toString();
                String admin_pass = adminPass.getText().toString();

                if (admin_name.equals("admin") && admin_pass.equals("ad1234")) {
                    startActivity(new Intent(HomepageAdmin.this, AdminActivity.class));
                } else {
                    Toast.makeText(HomepageAdmin.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

