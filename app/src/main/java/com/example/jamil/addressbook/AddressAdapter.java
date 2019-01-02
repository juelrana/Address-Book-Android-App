package com.example.jamil.addressbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jamil on 3/17/2016.
 */
public class AddressAdapter extends ArrayAdapter<Address> {
    Context context;
    TextView nameTv;
    TextView phoneTv;
    TextView emailTv;
    TextView streetTv;
    TextView zipTv;
    TextView cityTv;
    ArrayList<Address> addressList;


    public AddressAdapter(Context context, ArrayList<Address> addressList) {
        super(context, R.layout.address_row_view, addressList);
        this.context = context;
        this.addressList = addressList;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.address_row_view, null);
        nameTv = (TextView) convertView.findViewById(R.id.nameTextView);
        streetTv = (TextView) convertView.findViewById(R.id.streetTextView);
        cityTv = (TextView) convertView.findViewById(R.id.cityTextView);

        nameTv.setText(addressList.get(position).getName().toString());
        streetTv.setText(addressList.get(position).getStreet().toString());
        cityTv.setText(addressList.get(position).getCity().toString());

        return convertView;
    }

}
