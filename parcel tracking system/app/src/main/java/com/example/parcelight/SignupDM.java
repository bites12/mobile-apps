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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignupDM extends AppCompatActivity {

    EditText editDeliveryID,editPhone, editName, editPassword, editAddress,  editPostcode;
    Button SignUp;
    CardView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupdm);

        signup = (CardView) findViewById(R.id.card_signup);

        editDeliveryID =  (EditText)findViewById(R.id.dm_id);
        editName =  (EditText)findViewById(R.id.dm_name);
        editPhone =  (EditText)findViewById(R.id.dm_num);
        editPassword =  (EditText)findViewById(R.id.dm_password);
        editAddress =  (EditText)findViewById(R.id.dm_address);
        editPostcode =  (EditText)findViewById(R.id.dm_postcode);

        SignUp =  (Button)findViewById(R.id.btn_signup);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_deliveryman = database.getReference("DeliveryMan") ;

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(SignupDM.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_deliveryman.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Check if user phone already exist
                        if (dataSnapshot.child(editDeliveryID.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(SignupDM.this, "Phone number already registered.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDialog.dismiss();
                            DeliveryMan deliveryMan = new DeliveryMan(editDeliveryID.getText().toString(),editName.getText().toString(),editPassword.getText().toString(),editPhone.getText().toString(),editAddress.getText().toString(),editPostcode.getText().toString());
                            table_deliveryman.child(editDeliveryID.getText().toString()).setValue(deliveryMan);
                            Toast.makeText(SignupDM.this, "Sign Up succesfull!", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(SignupDM.this, HomepageDM.class);
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