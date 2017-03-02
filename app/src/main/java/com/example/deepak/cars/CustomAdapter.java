package com.example.deepak.cars;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] car;
    private final Integer[] imgId;
    public CustomAdapter(Activity context, String[] car, Integer[] imgId){
        super(context,R.layout.cars_view,car);
        this.context = context;
        this.car = car;
        this.imgId = imgId;
    }
    public View getView(int position, View view, ViewGroup parent){
        //inflate the view and populate the list with texts and images.
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.cars_view,null,false);
        TextView carName = (TextView) rowView.findViewById(R.id.carName);
        ImageView thumbNail = (ImageView) rowView.findViewById(R.id.thumbnail);
        carName.setText(car[position]);
        thumbNail.setImageResource(imgId[position]);
        return rowView;
    }

}
