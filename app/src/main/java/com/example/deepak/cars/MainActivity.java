package com.example.deepak.cars;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity {
    GridView carsView;
    String[] car;
    static Integer[] thumbNailId={
            R.drawable.audi,
            R.drawable.benz,
            R.drawable.bmw,
            R.drawable.jaguar,
            R.drawable.infiniti,
            R.drawable.lamborghini,
    };
    static String[] carPageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        car = getResources().getStringArray(R.array.carName);
        carPageUrl = getResources().getStringArray(R.array.carPage);
        CustomAdapter adapter=new CustomAdapter(this,car,thumbNailId);
        carsView=(GridView)findViewById(R.id.carsView);
        registerForContextMenu(carsView);
        carsView.setLongClickable(true);
        carsView.setAdapter(adapter);
        carsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplication(),ImageActivity.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.carsView) {
            MenuInflater inflater = getMenuInflater();
            menu.setHeaderTitle("Select an action to perform");
            inflater.inflate(R.menu.cars_menu, menu);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Intent i = new Intent(Intent.ACTION_VIEW);
        //determine which option is chosen by the user from the context menu and perform corresponding action
        switch(item.getItemId()) {
            case R.id.viewPic:
                Intent intent = new Intent(getApplication(),ImageActivity.class);
                intent.putExtra("position", info.position);
                startActivity(intent);
                return true;
            case R.id.showPage:
                i.setData(Uri.parse(carPageUrl[info.position]));
                startActivity(i);
                return true;
            case R.id.showDealers:
                Intent in = new Intent(getApplication(),ListActivity.class);
                in.putExtra("position", info.position);
                startActivity(in);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
