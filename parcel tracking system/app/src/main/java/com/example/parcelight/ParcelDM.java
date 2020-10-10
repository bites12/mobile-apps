package com.example.parcelight;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ParcelDM extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference table_item = database.getReference("Item");

    Button Back, Update, buttonUpdate;
    TextView tracking,dmname,custname,address,postcode,phone;
    EditText Status;
    Item item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parcel_dm);

        Back = (Button) findViewById(R.id.btn_back);
        Update = (Button) findViewById(R.id.btn_update);


        Intent intent = getIntent();

        String Tracking = intent.getStringExtra("Tracking number");
        String DMName = intent.getStringExtra("Name of sender");
        String CustName = intent.getStringExtra("Name of receiver");
        String Address = intent.getStringExtra("Address");
        String Postcode = intent.getStringExtra("Postcode");
        String Phone = intent.getStringExtra("Phone number");


        tracking = (TextView) findViewById(R.id.tracking);
        dmname = (TextView) findViewById(R.id.dmname);
        custname = (TextView) findViewById(R.id.custname);
        address = (TextView) findViewById(R.id.address);
        postcode = (TextView) findViewById(R.id.postcode);
        phone = (TextView) findViewById(R.id.phone);

        tracking.setText("Tracking number: " + Tracking);
        dmname.setText("Deliveryman: " + DMName);
        custname.setText("Customer: " + CustName);
        address.setText("Address: " + Address);
        postcode.setText("Postcode: " + Postcode);
        phone.setText("Phone: " + Phone);


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ParcelDM.this, TrackingDM.class));
            }


        });


        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showUpdateDialog(item.getItemID(),item.getStatusID());
                startActivity(new Intent(ParcelDM.this, DMNotes.class));


            }
        });
    }

   /*private boolean updateItem(TextView itemId, String idstatus) {

        DatabaseReference table_item = FirebaseDatabase.getInstance().getReference("Item").child(itemId);

        //updating item
        Item item = new Item(itemId,idstatus);
        table_item.setValue(item);
        Toast.makeText(getApplicationContext(), "Item Updated", Toast.LENGTH_LONG).show();
        return true;
    }


    public void showUpdateDialog(String ItemID,String StatusID) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.updateitem, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextStatus = (EditText) dialogView.findViewById(R.id.editTextStatus);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.btn_update);

        dialogBuilder.setTitle("Updating Status" +ItemID);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = editTextStatus.getText().toString().trim();
                if (!TextUtils.isEmpty(status)) {
                    updateItem(itemId,status);
                    b.dismiss();
                }
            }
        });

    }*/
}


