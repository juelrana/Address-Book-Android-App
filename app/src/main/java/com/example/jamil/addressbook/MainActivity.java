package com.example.jamil.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   GridView listView;
    private AddressManager manager;
    AddressAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (GridView) findViewById(R.id.gridview);
        manager = new AddressManager(this);
        final ArrayList<Address> addressList = manager.getAllContacts();
        adapter = new AddressAdapter(this, addressList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AddressDetailsActivity.class);
                Address address= addressList.get(position);
                intent.putExtra("id", address.getId());
                startActivity(intent);
            }
        });

    }
    public void openAddAddressFormUI(View view){
        Intent intent=new Intent(MainActivity.this,AddAddressActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() { }

}
