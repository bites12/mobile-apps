package com.example.parcelight;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class KeyinItem extends AppCompatActivity{
    EditText editPhone, editCust, editTracking,editAddress,editPostcode, editDM;
    Button btnSubmit;

    CardView add;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyinitem);
        add = (CardView) findViewById(R.id.card_add);

        editTracking =  (EditText)findViewById(R.id.track_num);
        editDM = (EditText)findViewById(R.id.dm_name);
        editCust =  (EditText)findViewById(R.id.cust_name);
        editAddress =  (EditText)findViewById(R.id.cust_address);
        editPostcode =  (EditText)findViewById(R.id.cust_postcode);
        editPhone =  (EditText)findViewById(R.id.cust_number);

        btnSubmit =  (Button)findViewById(R.id.btn_admin);

        FirebaseApp.initializeApp(this);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_item = database.getReference("Item");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(KeyinItem.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_item.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //Check if tracking already exist
                        if (dataSnapshot.child(editTracking.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(KeyinItem.this, "Tracking Number already registered.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDialog.dismiss();
                            Item item = new Item(editTracking.getText().toString(), editDM.getText().toString(), editCust.getText().toString(),editAddress.getText().toString(), editPostcode.getText().toString(),editPhone.getText().toString());
                            table_item.child(editTracking.getText().toString()).setValue(item);
                            Toast.makeText(KeyinItem.this, "succesfull!", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(KeyinItem.this,AdminActivity.class);
                            startActivity(homeIntent);
                            finish();
                        }
                    }   @Override
                    public void onCancelled(DatabaseError databaseError){

                    }
                });
            }
        });
    }
}
