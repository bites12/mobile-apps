package com.example.parcelight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class RecordDM extends AppCompatActivity{
    CardView record;
    DatabaseReference table_dm;
    List<DeliveryMan> deliveryman;
    ListView listViewDM;
    private ArrayAdapter<String> artistAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recorddm);
        record = (CardView) findViewById(R.id.card_list);
        table_dm = FirebaseDatabase.getInstance().getReference("DeliveryMan");
        deliveryman = new ArrayList<>();
        listViewDM = (ListView) findViewById(R.id.listViewDeliveryMan);

        listViewDM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Send data to another activity when click the listview
                Intent intent = new Intent(getApplicationContext(), ViewDM.class);
                DeliveryMan deliveryMan = deliveryman.get(position);
                intent.putExtra("Name", deliveryMan.getName());
                intent.putExtra("DeliveryID", deliveryMan.getDeliverymanID());
                intent.putExtra("Phone", deliveryMan.getPhone());
                intent.putExtra("Address", deliveryMan.getAddress());
                intent.putExtra("Postcode", deliveryMan.getPostcode());

                startActivity(intent);


            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        //Query queryRef = mReference.child("deliveryman").orderByChild("postcode").startAt(query).endAt(query + "\uf8ff");

        table_dm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                deliveryman.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    DeliveryMan stall = postSnapshot.getValue(DeliveryMan.class);

                    String id = String.valueOf(postSnapshot.getKey());
                    stall.setPhone(id);
                    deliveryman.add(stall);
                }
                //creating adapter
                ListDM artistAdapter = new ListDM(RecordDM.this, deliveryman);
                //attaching adapter to the listview
                listViewDM.setAdapter(artistAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

}
