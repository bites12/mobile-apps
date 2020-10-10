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

public class RecordItem extends AppCompatActivity{
    CardView record;
    DatabaseReference table_item;
    List<Item> item;
    ListView listViewItem;
    private ArrayAdapter<Item> ItemAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recorditem);
        record = (CardView) findViewById(R.id.card_list);
        table_item = FirebaseDatabase.getInstance().getReference("Item");
        item = new ArrayList<>();
        listViewItem = (ListView) findViewById(R.id.listViewItem);

        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Send data to another activity when click the listview
                Intent intent = new Intent(getApplicationContext(), ViewItem.class);
                Item items = item.get(position);
                intent.putExtra("Tracking number", items.getTracking());
                intent.putExtra("Name of sender", items.getDMName());
                intent.putExtra("Name of receiver", items.getCustName());
                intent.putExtra("Address", items.getAddress());
                intent.putExtra("Postcode", items.getPostcode());
                intent.putExtra("Phone", items.getPhone());



                startActivity(intent);


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        table_item.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                item.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Item stall = postSnapshot.getValue(Item.class);

                    String id = String.valueOf(postSnapshot.getKey());
                    stall.setTracking(id);
                    item.add(stall);
                }
                //creating adapter
                ListItem ItemAdapter = new ListItem(RecordItem.this, item);
                //attaching adapter to the listview
                listViewItem.setAdapter(ItemAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

}
