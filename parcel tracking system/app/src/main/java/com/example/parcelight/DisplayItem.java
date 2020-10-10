package com.example.parcelight;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayItem extends AppCompatActivity {
    /*Button Submit;
    EditText itemId,idman, idstatus;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_item = database.getReference("Item") ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_item);

        Submit = (Button)findViewById(R.id.btnSubmit);
        itemId =  (EditText)findViewById(R.id.itemId);
        idman =  (EditText)findViewById(R.id.idman);
        idstatus = (EditText) findViewById(R.id.statusID);


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(DisplayItem.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();


                table_item.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Check if user phone already exist
                        if (dataSnapshot.child(itemId.getText().toString()).exists()) {
                            mDialog.dismiss();
                            Toast.makeText(DisplayItem.this, "Tracking number already registered.", Toast.LENGTH_SHORT).show();
                        } else {
                            mDialog.dismiss();
                            Item item = new Item(itemId.getText().toString(), idman.getText().toString(), idstatus.getText().toString());
                            table_item.child(itemId.getText().toString()).setValue(item);
                            Toast.makeText(DisplayItem.this, "Sign Up succesfull!", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(DisplayItem.this, ItemActivity.class);

                            startActivity(homeIntent);
                            finish();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
    }*/
}

