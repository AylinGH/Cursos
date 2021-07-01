package com.github.olegschwann.wearablerecyclerviewtest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.wear.widget.WearableLinearLayoutManager;
import android.support.wear.widget.WearableRecyclerView;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainMenuActivity extends WearableActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        WearableRecyclerView recyclerView = findViewById(R.id.main_menu_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setEdgeItemsCenteringEnabled(true);
        recyclerView.setLayoutManager(new WearableLinearLayoutManager(this));

        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(R.drawable.icon_1, "Desarrollador Fullstack"));
        menuItems.add(new MenuItem(R.drawable.icon_2, "Javascript"));
        menuItems.add(new MenuItem(R.drawable.icon_3, "Flutter"));
       // menuItems.add(new MenuItem(R.drawable.icon_4, "Item 4"));

        recyclerView.setAdapter(new MainMenuAdapter(this, menuItems, new MainMenuAdapter.AdapterCallback() {
            @Override
            public void onItemClicked(Integer menuPosition) {
                switch (menuPosition) {
                    case 0:
                        /**action_1(
                         );*/
                        Toast.makeText(MainMenuActivity.this,
                                "Seleccionaste Web FullStack",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(MainMenuActivity.this,
                                "Seleccionaste Javascript",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(MainMenuActivity.this,
                                "Seleccionaste Flutter",
                                Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }));
    }
/*
    public void moveToDescription(Integer menuPosition){
        Intent intent = new Intent(this, DescriptionActivity.class);
        Intent.putExtr("Integer",menuPosition);
        startActivity(intent);
*/


    public void action_1(){
        Log.i("ACTION", "action_1()");
    }

    public void action_2(){
        Log.i("ACTION", "action_2()");
    }

    public void action_3(){
        Log.i("ACTION", "action_3()");
    }

    public void action_4(){
        Log.i("ACTION", "action_4()");
    }

    public void cancelMenu(){
        Log.i("ACTION", "cancelMenu()");
    }

}

