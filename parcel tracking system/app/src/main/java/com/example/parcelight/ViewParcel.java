package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewParcel extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference table_dm = database.getReference("Deliveryman");

    Button Back, Update ;
    TextView tracking,name, phone, address, postcode;
    DeliveryMan deliveryman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewparcel);

        Back = (Button) findViewById(R.id.btn_back);
        Update = (Button) findViewById(R.id.btn_update);


        Intent intent = getIntent();

        String Tracking = intent.getStringExtra("Tracking number");
        String Name = intent.getStringExtra("Name");
        String Phone = intent.getStringExtra("Phone");
        String Address = intent.getStringExtra("Address");
        String Postcode = intent.getStringExtra("Postcode");

        tracking = (TextView) findViewById(R.id.tracking);
        name = (TextView) findViewById(R.id.name);
        phone = (TextView) findViewById(R.id.phone);
        address = (TextView) findViewById(R.id.address);
        postcode = (TextView) findViewById(R.id.postcode);

        tracking.setText("Tracking number: " + Tracking);
        name.setText("Name: " + Name);
        phone.setText("Phone: " + Phone);
        address.setText("Address: " + Address);
        postcode.setText("Postcode: " + Postcode);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ViewParcel.this, ListDMItem.class));
            }
        });

}
}
