package com.example.deepak.cars;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView img = (ImageView)findViewById(R.id.carImage);
        img.setClickable(true);
        Bundle extras = getIntent().getExtras();
        final int position = extras.getInt("position");
        img.setImageResource(MainActivity.thumbNailId[position]);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(MainActivity.carPageUrl[position]));
                startActivity(i);
            }
        });
    }

}
