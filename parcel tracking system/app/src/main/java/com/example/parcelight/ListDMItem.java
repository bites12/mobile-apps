package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v7.widget.CardView;

public class ListDMItem extends AppCompatActivity implements View.OnClickListener{
    CardView delivery, admin;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listcustdm);

        delivery = (CardView) findViewById(R.id.card_delivery);
        admin = (CardView) findViewById(R.id.card_cust);

        delivery.setOnClickListener(this);
        admin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.card_delivery: i = new Intent(this, RecordDM.class);
                startActivity(i);
                break;
            case R.id.card_cust: i = new Intent(this, RecordItem.class);
                startActivity(i);
                break;

        }
    }


}
