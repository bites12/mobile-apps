package com.example.parcelight;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListItem extends ArrayAdapter <Item> {
    private Activity context;
    List<Item> item;

    public ListItem(Activity context, List<Item> item) {
        super(context, R.layout.layout_item, item);
        this.context = context;
        this.item = item;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_item, null, true);

        TextView tvTracking = (TextView) listViewItem.findViewById(R.id.tvTracking);
        TextView tvDMName = (TextView) listViewItem.findViewById(R.id.tvDMName);
        TextView tvCustName = (TextView) listViewItem.findViewById(R.id.tvCustName);
        TextView tvAddress = (TextView) listViewItem.findViewById(R.id.tvAddress);
        TextView tvPostcode=(TextView) listViewItem.findViewById(R.id.tvPostcode);
        TextView tvPhone=(TextView) listViewItem.findViewById(R.id.tvPhone);


        Item items = item.get(position);
        tvTracking.setText(items.getTracking());
        tvDMName.setText(items.getDMName());
        tvCustName.setText(items.getCustName());
        tvAddress.setText(items.getAddress());
        tvPostcode.setText(items.getPostcode());
        tvPhone.setText(items.getPhone());



        return listViewItem;
    }
}
