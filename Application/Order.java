package com.example.chemwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Unit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Order extends AppCompatActivity {

    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order );

        TextView phoneNo = findViewById(R.id.order_phone);
        TextView user_name = findViewById(R.id.order_name);
        EditText address = findViewById( R.id.order_address);
        TextView FId = findViewById( R.id.order_furnitureId);
        TextView totpriceclick = findViewById( R.id.order_totprice1);
        TextView Fname = findViewById( R.id.order_furnitureName);
        TextView Unitprice = findViewById( R.id.order_unitPrice);
        EditText Units = findViewById( R.id.order_units);
        TextView Totprice = findViewById( R.id.order_totprice);
        Button order = findViewById( R.id.Order_id );

        SharedPreferences mySharedPreferences = this.getSharedPreferences("MYPREFERENCENAME", Context.MODE_PRIVATE);
        String UserphoneNo = mySharedPreferences.getString("USERPHONE", "");
        String UserName = mySharedPreferences.getString("USERNAME", "");

        Intent intent = getIntent();
        String tittle = intent.getStringExtra("Tittle");
        String id = intent.getStringExtra("Id");
        String price = intent.getStringExtra("price");


        user_name.setText(UserName);
        phoneNo.setText(UserphoneNo);
        FId.setText(id);
        Fname.setText(tittle);
        Unitprice.setText(price);

  /*    String NumUnit = Units.getText().toString();
        String F_UnitPrice = Unitprice.getText().toString();
   */
        totpriceclick.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double i2 = Double.parseDouble(Unitprice.getText().toString());
                Double i1 = Double.parseDouble(Units.getText().toString());
                ProgressDialog mydialog = new ProgressDialog( Order.this );
                mydialog.setMessage( "Please wait..." );
                mydialog.show();
                Double Tot = i1 * i2;
                mydialog.dismiss();
                Totprice.setText( "Rs: "+Tot.toString()+" + Delivery charge");
            }
        } );


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("Order");

        String request_key=table.push().getKey(); //.toString();

        order.setOnClickListener( new View.OnClickListener() {
          //  order= new Order();
            @Override
            public void onClick(View v) {
                String phone = phoneNo.getText().toString();
                String Name = user_name.getText().toString();
                String Furn_Id = FId.getText().toString();
                String Furn_Name = Fname.getText().toString();
                String OrderUnit = Units.getText().toString();
                String Address = address.getText().toString();
                String UnitPrice = Unitprice.getText().toString();
                String TotPrice = Totprice.getText().toString();

                if (Address.isEmpty()) {
                    address.setError( "Required" );
                    address.requestFocus();
                    return;}
                if(OrderUnit.isEmpty()){
                    Fname.setError( "Required" );
                    Fname.requestFocus();
                    return;}
                if(TotPrice.isEmpty()){
                    Toast.makeText( Order.this, "Please click Show Total Price to Confirm Order", Toast.LENGTH_SHORT ).show();
                  //  Fname.setError( "" );
                 //   Fname.requestFocus();
                    return;}
                DatabaseReference table1 = database.getReference("Order");
                ProgressDialog mydialog = new ProgressDialog( Order.this );
                mydialog.setMessage( "Please wait..." );
                mydialog.show();
                table1.addValueEventListener( new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                        UserOrder userOrder = new UserOrder( phone,Name,Address,Furn_Id,Furn_Name,UnitPrice, OrderUnit,TotPrice);
                        // else {
                      //  if ((datasnapshot.child( phoneNo.getText().toString() ).exists())) {

                            table1.child( request_key ).setValue( userOrder );
                            mydialog.dismiss();
                            Toast.makeText( Order.this, "Order Confirm", Toast.LENGTH_SHORT ).show();
                            Intent intent2 = new Intent(Order.this,Home.class);
                            startActivity( intent2 );
                     //   }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                } );
            }
        });

    }
}