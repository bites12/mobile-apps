package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DMNotes extends AppCompatActivity {
    EditText tracking, status,notes;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dmnotes);

        Submit = (Button) findViewById(R.id.btn_submit);
        tracking =  (EditText)findViewById(R.id.tracking);
        status =  (EditText)findViewById(R.id.status);
        notes =  (EditText)findViewById(R.id.note);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_addnote = database.getReference("AddNotes") ;

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                table_addnote.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Check if user phone already exist
                        if (dataSnapshot.child(tracking.getText().toString()).exists())
                        {
                            Toast.makeText(DMNotes.this, "Phone number already registered.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            AddNotes addnotes = new AddNotes(tracking.getText().toString(),status.getText().toString(),notes.getText().toString());
                            table_addnote.child(tracking.getText().toString()).setValue(addnotes);
                            Toast.makeText(DMNotes.this, "Sign Up succesfull!", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(DMNotes.this, TrackingDM.class);
                            //Common.currentDeliveryMan = deliveryMan;
                            startActivity(homeIntent);
                            finish();
                        }

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError){

                    }
                });
            }


        });
    }
}
