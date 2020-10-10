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

public class LoginDM extends AppCompatActivity {

    EditText editDeliveryID,editPassword;
    Button SignIn;
    CardView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logindm);

        signin = (CardView) findViewById(R.id.card_sigin);

        editPassword = (EditText)findViewById(R.id.dm_password);
        editDeliveryID =  (EditText)findViewById(R.id.dm_id);
        SignIn = (Button)findViewById(R.id.btn_signin);
//Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_deliveryman = database.getReference("DeliveryMan") ;

        SignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final ProgressDialog mDialog = new ProgressDialog(LoginDM.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_deliveryman.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //Check if user not exits in database
                        if (dataSnapshot.child(editDeliveryID.getText().toString()).exists()) {
                            //Get User information
                            mDialog.dismiss();
                            DeliveryMan deliveryMan = dataSnapshot.child(editDeliveryID.getText().toString()).getValue(DeliveryMan.class);
                            if (deliveryMan.getPassword().equals(editPassword.getText().toString()))
                            {
                                Intent homeIntent = new Intent(LoginDM.this, TrackingDM.class);
                                //Common.currentDeliveryMan = deliveryMan;
                                startActivity(homeIntent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(LoginDM.this, "Wrong Password!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText(LoginDM.this, "User not exist in Database", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

        });

    }
}