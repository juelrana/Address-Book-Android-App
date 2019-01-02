package com.example.jamil.addressbook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddressDetailsActivity extends AppCompatActivity {
    EditText nameEt;
    EditText phoneNoEt;
    EditText emailEt;
    EditText streetEt;
    EditText zipEt;
    EditText cityEt;
    private Address address;
    private AddressManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_details);

        nameEt = (EditText) findViewById(R.id.nameEditText);
        phoneNoEt = (EditText) findViewById(R.id.phoneEditText);
        emailEt = (EditText) findViewById(R.id.emailEditText);
        streetEt = (EditText) findViewById(R.id.streetEditText);
        zipEt = (EditText) findViewById(R.id.zipEditText);
        cityEt = (EditText) findViewById(R.id.cityEditText);

        manager = new AddressManager(this);
        int id = getIntent().getIntExtra("id", 0);

        nameEt.setText(manager.getContact(id).getName().toString());
        phoneNoEt.setText(manager.getContact(id).getPhoneNo());
        emailEt.setText(manager.getContact(id).getEmail());
        streetEt.setText(manager.getContact(id).getStreet());
        zipEt.setText(manager.getContact(id).getZip());
        cityEt.setText(manager.getContact(id).getCity());

    }
    public void updateAddressInDatabase(View view){
        int id = getIntent().getIntExtra("id", 0);
        address = new Address(nameEt.getText().toString(),phoneNoEt.getText().toString(),emailEt.getText().toString(),
                streetEt.getText().toString(),zipEt.getText().toString(),cityEt.getText().toString()
        );
        boolean updated=manager.updateContact(id, address);
        if (updated) {
            Toast.makeText(getApplicationContext(), "Update Successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(AddressDetailsActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Update Failed", Toast.LENGTH_LONG).show();
        }

    }
    public void deleteAddressFromDatabase(View view){
        int id = getIntent().getIntExtra("id", 0);
       boolean deleted= manager.deleteContact(id);
        if (deleted) {
            Toast.makeText(getApplicationContext(), "Delete Successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(AddressDetailsActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Delete Failed", Toast.LENGTH_LONG).show();
        }
    }
    public void dialCall(View view){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" +phoneNoEt.getText().toString()));
        startActivity(callIntent);

    }
    public void sendSMS(View view){
        Uri uri = Uri.parse("smsto:" +phoneNoEt.getText().toString());
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(smsIntent);
    }




}
