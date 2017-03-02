package com.example.deepak.cars;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] name;
    private final String[] address;
    public ListAdapter(Activity context, String[] name, String[] address){
        super(context,R.layout.dealers_view,name);
        this.context = context;
        this.name = name;
        this.address = address;
    }
    public View getView(int position, View view, ViewGroup parent){
        //inflate the view and populate the list with texts and images.
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.dealers_view, null, false);
        TextView dealerName = (TextView) rowView.findViewById(R.id.name);
        TextView dealerAddress = (TextView) rowView.findViewById(R.id.address);
        dealerName.setText(name[position]);
        dealerAddress.setText(address[position]);
        return rowView;
    }

}
