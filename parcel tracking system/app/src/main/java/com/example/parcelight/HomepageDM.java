package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomepageDM extends AppCompatActivity implements View.OnClickListener {

    CardView signin, signup;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepagedm);

        signin = (CardView) findViewById(R.id.card_sigin);
        signup = (CardView) findViewById(R.id.card_signup);

        signin.setOnClickListener(this);
        signup.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.card_sigin: i = new Intent(this, LoginDM.class);
                startActivity(i);
                break;
            case R.id.card_signup: i = new Intent(this, SignupDM.class);
                startActivity(i);
                break;

        }
    }
}
