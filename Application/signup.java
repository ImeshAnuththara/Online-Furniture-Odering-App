package com.example.chemwood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView( R.layout.sign_up);

        EditText phoneNo = findViewById( R.id.enterPhone );
        EditText user_name = findViewById( R.id.enterPersonName );
        EditText Enter_NIC = findViewById( R.id.enterNIC);
        EditText Enter_password = findViewById( R.id.enterPassword);
        Button sign_up = findViewById( R.id.sign_up2 );

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("User");


            sign_up.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String phone = phoneNo.getText().toString();
                    String Name = user_name.getText().toString();
                    String NIC = Enter_NIC.getText().toString();
                    String password = Enter_password.getText().toString();

                    if (Name.isEmpty()) {
                        user_name.setError( "Required" );
                        user_name.requestFocus();
                        return;}
                    if(phone.isEmpty())  {
                        phoneNo.setError( "Required" );
                        phoneNo.requestFocus();
                        return;}
                    if(phone.length()< 10)  {
                        phoneNo.setError( "Phone Number not valid" );
                        phoneNo.requestFocus();
                        return;}
                    if(phone.length()> 10)  {
                        phoneNo.setError( "Phone Number not valid" );
                        phoneNo.requestFocus();
                        return;}
                    if(NIC.isEmpty()){
                        Enter_NIC.setError( "Required" );
                        Enter_NIC.requestFocus();
                        return;}
                    if(password.isEmpty()){
                        Enter_password.setError( "Required" );
                        Enter_password.requestFocus();
                        return;}
                    ProgressDialog mydialog = new ProgressDialog( signup.this );
                    mydialog.setMessage( "Please wait..." );
                    mydialog.show();
                    table.addValueEventListener( new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                                User user = new User( user_name.getText().toString(), Enter_NIC.getText().toString(), Enter_password.getText().toString() );
                            //if((Name.length()>0) && (phone.length()==10) && (NIC.length()>0) && (password.length()>0)) {

                                if ((datasnapshot.child( phoneNo.getText().toString() ).exists())) {
                                    mydialog.dismiss();
                                    Toast.makeText( signup.this, "Phone number already registered", Toast.LENGTH_SHORT ).show();
                                }
                               // else {
                            if (!(datasnapshot.child( phoneNo.getText().toString() ).exists())) {
                                    table.child( phoneNo.getText().toString() ).setValue( user );
                                    mydialog.dismiss();
                                    Intent intent2 = new Intent(signup.this,Home.class);
                                    startActivity( intent2 );
                                //    Toast.makeText( signup.this, "User registered sucessfully", Toast.LENGTH_SHORT ).show();
                                 }

                          //  }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    } );
                }
            });

        }

}
