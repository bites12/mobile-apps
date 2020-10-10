package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v7.widget.CardView;

public class MainPage extends AppCompatActivity implements View.OnClickListener{
    CardView delivery, admin;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        delivery = (CardView) findViewById(R.id.card_delivery);
        admin = (CardView) findViewById(R.id.card_admin);

        delivery.setOnClickListener(this);
        admin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.card_delivery: i = new Intent(this, HomepageDM.class);
                startActivity(i);
                break;
            case R.id.card_admin: i = new Intent(this, HomepageAdmin.class);
                startActivity(i);
                break;

        }
    }


}
