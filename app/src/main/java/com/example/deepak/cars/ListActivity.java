package com.example.deepak.cars;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView dealers = (ListView)findViewById(R.id.dealersView);
        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");
        int nameId=0,addressId=0;
        switch(position){
            case 0: nameId=R.array.name1;
                    addressId=R.array.address1;
                    break;
            case 1: nameId=R.array.name2;
                    addressId=R.array.address2;
                    break;
            case 2: nameId=R.array.name3;
                    addressId=R.array.address3;
                    break;
            case 3: nameId=R.array.name4;
                    addressId=R.array.address4;
                    break;
            case 4: nameId=R.array.name5;
                    addressId=R.array.address5;
                    break;
            case 5: nameId=R.array.name6;
                    addressId=R.array.address6;
                    break;
        }
        String[] name = getResources().getStringArray(nameId);
        String[] address = getResources().getStringArray(addressId);
        ListAdapter adapter = new ListAdapter(this,name,address);
        dealers.setAdapter(adapter);
    }

}
