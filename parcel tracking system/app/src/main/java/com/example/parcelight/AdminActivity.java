package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener{
    Button login,logout;
    CardView add, update, record, assign;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminactivity);

        login = (Button) findViewById(R.id.login_admin);
        logout = (Button) findViewById(R.id.logout_admin);

        add = (CardView) findViewById(R.id.card_add);
        record = (CardView) findViewById(R.id.card_list);

        add.setOnClickListener(this);
        record.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.card_add: i = new Intent(this, KeyinItem.class);
                startActivity(i);
                break;
            case R.id.card_list: i = new Intent(this, ListDMItem.class);
                startActivity(i);
                break;
            case R.id.logout_admin: i = new Intent(this, HomepageAdmin.class);
                startActivity(i);
                break;

        }
    }


}
