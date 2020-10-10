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

public class SignupCust extends AppCompatActivity {

    EditText editPhone, editName, editPassword, editAddress,  editPostcode;
    Button SignUp;
    CardView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.signupcust);

        signup = (CardView) findViewById(R.id.card_signup);

        editName =  (EditText)findViewById(R.id.cust_name);
        editPhone =  (EditText)findViewById(R.id.cust_number);
        editPassword =  (EditText)findViewById(R.id.cust_password);
        editAddress =  (EditText)findViewById(R.id.cust_address);
        editPostcode =  (EditText)findViewById(R.id.cust_postcode);

        SignUp =  (Button)findViewById(R.id.btn_signup);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_customer = database.getReference("Customer") ;

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(SignupCust.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_customer.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Check if user phone already exist
                        if (dataSnapshot.child(editPhone.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(SignupCust.this, "Phone number already registered.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDialog.dismiss();
                            Customer customer = new Customer(editName.getText().toString(),editAddress.getText().toString(),editPostcode.getText().toString(),editPhone.getText().toString(),editPassword.getText().toString());
                            table_customer.child(editPhone.getText().toString()).setValue(customer);
                            Toast.makeText(SignupCust.this, "Sign Up succesfull!", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(SignupCust.this, HomepageCust.class);
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
        });*/
    }
}