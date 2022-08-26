package com.example.chemwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class Admin_upload extends AppCompatActivity {

    UserOrder userOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin_upload );

        ImageView img = findViewById( R.id.upload_image );
        EditText Category = findViewById(R.id.upload_category);
        EditText FName = findViewById(R.id.upload_FurName);
        EditText FId = findViewById( R.id.upload_FurId);
        EditText price = findViewById( R.id.upload_FurPrice);
        EditText description = findViewById( R.id.upload_FurDescrip);

        Button SelectImage = findViewById( R.id.select_image);
        Button Upload = findViewById( R.id.upload_data );


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference table = database.getReference("Order");


        Upload.setOnClickListener( new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String category = Category.getText().toString();
            String Tittle = FName.getText().toString();
            String Photo = img.toString();
            String Id = FId.getText().toString();
            String Price = price.getText().toString();
            String Description = description.getText().toString();

            if (category.isEmpty()) {
                Category.setError( "Required" );
                Category.requestFocus();
                return;}
            if(Tittle.isEmpty())  {
                FName.setError( "Required" );
                FName.requestFocus();
                return;}
            if(Id.isEmpty()){
                FId.setError( "Required" );
                FId.requestFocus();
                return;}
            if(Price.isEmpty())  {
                price.setError( "Required" );
                price.requestFocus();
                return;}
            if(Description.isEmpty()){
                description.setError( "Required" );
                description.requestFocus();
                return;}

            ProgressDialog mydialog = new ProgressDialog( Admin_upload.this );
            mydialog.setMessage( "Please wait..." );
            mydialog.show();
            table.addValueEventListener( new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                    AdminUpload adminUpload = new AdminUpload(Tittle,Photo,Price,Id, Description);
                    // else {
                    //  if ((datasnapshot.child( phoneNo.getText().toString() ).exists())) {
                    mydialog.dismiss();
                  //  table.child(phoneNo.getText().toString()).setValue( adminUpload );
                    Toast.makeText( Admin_upload.this, "Order Confirm", Toast.LENGTH_SHORT ).show();
                    Intent intent2 = new Intent(Admin_upload.this,Home.class);
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