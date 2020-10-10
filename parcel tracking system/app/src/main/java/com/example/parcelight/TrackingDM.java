package com.example.parcelight;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TrackingDM extends AppCompatActivity {
    Button SignIn, Track, Add;
    EditText idtrack;
    TextView itemId, ManID, StatusID;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackingdm);

        SignIn = (Button) findViewById(R.id.btn_signin);
        Track = (Button) findViewById(R.id.btn_track);
        item = new Item();


        idtrack = (EditText) findViewById(R.id.tracking_number);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_item = database.getReference("Item");

        Track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(TrackingDM.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_item.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot:dataSnapshot.getChildren()) {
                            if (postSnapshot.getKey() !=null){
                                item =  postSnapshot.getValue(Item.class);
                                //if(postSnapshot.child("ItemID").getValue().equals("idtrack")){
                                if (item.getTracking().equals(idtrack.getText().toString())){

                                    Intent intent =new Intent(getApplicationContext(), ParcelDM.class);

                                    intent.putExtra("Tracking number", item.getTracking());
                                    intent.putExtra("Name of sender", item.getDMName());
                                    intent.putExtra("Name of receiver", item.getCustName());
                                    intent.putExtra("Address", item.getAddress());
                                    intent.putExtra("Postcode", item.getPostcode());
                                    intent.putExtra("Phone", item.getPhone());

                                    startActivity(intent);

                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }

}

