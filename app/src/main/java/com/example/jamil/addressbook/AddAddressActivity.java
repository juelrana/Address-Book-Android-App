package com.example.jamil.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddAddressActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_add_address);
        manager = new AddressManager(this);

        nameEt = (EditText) findViewById(R.id.nameEditText);
        phoneNoEt = (EditText) findViewById(R.id.phoneEditText);
        emailEt = (EditText) findViewById(R.id.emailEditText);
        streetEt = (EditText) findViewById(R.id.streetEditText);
        zipEt = (EditText) findViewById(R.id.zipEditText);
        cityEt = (EditText) findViewById(R.id.cityEditText);
    }

    public void saveAddress(View view) {
        if (nameEt.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter name", Toast.LENGTH_LONG).show();
        } else {
            address = new Address(nameEt.getText().toString(), phoneNoEt.getText().toString(), emailEt.getText().toString(),
                    streetEt.getText().toString(), zipEt.getText().toString(), cityEt.getText().toString()
            );
            boolean inserted = manager.addContact(address);
            if (inserted) {
                Toast.makeText(getApplicationContext(), "Save Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddAddressActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Insertion Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}
