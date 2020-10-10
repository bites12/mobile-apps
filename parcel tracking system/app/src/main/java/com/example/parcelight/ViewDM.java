package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewDM extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference table_dm = database.getReference("Deliveryman");

    Button Back, Submit;
    TextView name, phone, address, postcode,dmid;
    EditText Status;
    DeliveryMan deliveryman;
    ListView listViewDM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdm);
        table_dm = FirebaseDatabase.getInstance().getReference("DeliveryMan");
        listViewDM = (ListView) findViewById(R.id.listViewDeliveryMan);
        Back = (Button) findViewById(R.id.btn_back);



        Intent intent = getIntent();

        String Name = intent.getStringExtra("Name");
        String DeliveryID = intent.getStringExtra("DeliveryID");
        String Phone = intent.getStringExtra("Phone");
        String Address = intent.getStringExtra("Address");
        String Postcode = intent.getStringExtra("Postcode");


        name = (TextView) findViewById(R.id.name);
        dmid = (TextView) findViewById(R.id.dmid);
        phone = (TextView) findViewById(R.id.phone);
        address = (TextView) findViewById(R.id.address);
        postcode = (TextView) findViewById(R.id.postcode);


        name.setText("Name: " + Name);
        dmid.setText("DeliveryID: " + DeliveryID);
        phone.setText("Phone: " + Phone);
        address.setText("Address: " + Address);
        postcode.setText("Postcode: " + Postcode);


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ViewDM.this, ListDMItem.class));
            }
        });

    }


}
