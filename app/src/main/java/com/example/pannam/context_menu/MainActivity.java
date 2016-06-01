package com.example.pannam.context_menu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Item itemHandler;
    private ItemSelectedAdapter adapter;
    private ArrayList itemList;
    private ListView mListView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mListView = (ListView)findViewById(R.id.listview);
        button = (Button)findViewById(R.id.printbtn);
        setWidget();

    }

    private void setWidget() {
        itemList = new ArrayList<Item>();
        itemList.add(new Item("pannam", false));
        itemList.add(new Item("bbsingh", false));
        itemList.add(new Item("pravesh", false));
        itemList.add(new Item("shreya", false));
        itemList.add(new Item("ashish", false));
        itemList.add(new Item("jeetu", false));
        itemList.add(new Item("pushkar", false));
        itemList.add(new Item("wangle", false));
        itemList.add(new Item("mamu", false));
        itemList.add(new Item("amir", false));

        //setup adapter
        adapter = new ItemSelectedAdapter(MainActivity.this,itemList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Item is selected from the list
                adapter.setCheckBox(position);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Display All Item Selected
                String countries = "";
                for(Item hold: adapter.getAllData()){
                    if(hold.isCheckbox()){
                        countries += " "  + hold.getName();
                    }
                }
                Toast.makeText(MainActivity.this,"Names: " + countries,Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
