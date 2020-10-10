package com.example.parcelight;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListDM extends ArrayAdapter<DeliveryMan> {

    private Activity context;
    List<DeliveryMan> deliveryman;

    public ListDM(Activity context, List<DeliveryMan> deliveryman) {
        super(context, R.layout.layout_deliveryman, deliveryman);
        this.context = context;
        this.deliveryman = deliveryman;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_deliveryman, null, true);

        TextView tvName = (TextView) listViewItem.findViewById(R.id.tvName);
        TextView tvAddress = (TextView) listViewItem.findViewById(R.id.tvAddress);
        TextView tvPostcode=(TextView) listViewItem.findViewById(R.id.tvPostcode);


        DeliveryMan deliverymans = deliveryman.get(position);
        tvName.setText(deliverymans.getName());
        tvAddress.setText(deliverymans.getAddress());
        tvPostcode.setText(deliverymans.getPostcode());

        return listViewItem;
    }
}
