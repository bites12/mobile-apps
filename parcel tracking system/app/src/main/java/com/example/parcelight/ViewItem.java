package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewItem extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference table_item = database.getReference("Item");

    Button Back, Update ;
    TextView tracking,dmname,custname,address,postcode,phone;
    Item item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewitem);

        Back = (Button) findViewById(R.id.btn_back);
        Update = (Button) findViewById(R.id.btn_update);


        Intent intent = getIntent();

        String Tracking = intent.getStringExtra("Tracking number ");
        String DMName = intent.getStringExtra("Name of sender ");
        String CustName = intent.getStringExtra("Name of receiver ");
        String Address = intent.getStringExtra("Address ");
        String Postcode = intent.getStringExtra("Postcode");
        String Phone = intent.getStringExtra("Phone");

        tracking = (TextView) findViewById(R.id.tracking);
        dmname = (TextView) findViewById(R.id.dmname);
        custname = (TextView) findViewById(R.id.custname);
        address = (TextView) findViewById(R.id.address);
        postcode = (TextView) findViewById(R.id.postcode);
        phone = (TextView) findViewById(R.id.phone);


        tracking.setText("Tracking number : " + Tracking);
        dmname.setText("Deliveryman : " + DMName);
        custname.setText("Customer : " + CustName);
        address.setText("Address: " + Address);
        postcode.setText("Postcode: " + Postcode);
        phone.setText("Phone: " + Phone);


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ViewItem.this, ListDMItem.class));
            }
        });

    }
}
