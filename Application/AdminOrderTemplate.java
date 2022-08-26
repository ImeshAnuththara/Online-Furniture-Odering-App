package com.example.chemwood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminOrderTemplate extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin_order_template );

        TextView orderCustomer = findViewById( R.id.order_name1 );
        TextView orderCustomerPhone = findViewById( R.id.order_phone1);
        TextView orderCustomerAddress = findViewById( R.id.order_address1 );
        TextView orderfname = findViewById( R.id.order_furnitureName1);
        TextView orderfId = findViewById( R.id.order_furnitureId1);
        TextView orderunitPrice = findViewById( R.id.order_unitPrice1);
        TextView orderunits = findViewById( R.id.order_units1);
        TextView ordertotal = findViewById( R.id.order_totprice1);
      //  Button display_btn = findViewById( R.id.order_totprice1 );


        Intent intent = getIntent();
        String CName = intent.getStringExtra("Phone");
        String CPhone = intent.getStringExtra("Name");
        String CAddress = intent.getStringExtra("Address");
        String FName = intent.getStringExtra("FId");
        String FId = intent.getStringExtra("FName");
        String UPrice = intent.getStringExtra("UPrice");
        String Units = intent.getStringExtra("Units");
        String Total = intent.getStringExtra("Total");



        orderCustomer.setText(CName);
        orderCustomerPhone.setText(CPhone);
        orderCustomerAddress.setText(CAddress);
        orderfname.setText(FName);
        orderfId.setText(FId);
        orderunitPrice.setText(UPrice);
        orderunits.setText(Units);
        ordertotal.setText(Total);
    }
}