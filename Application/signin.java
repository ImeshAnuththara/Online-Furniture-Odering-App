package com.example.chemwood;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

public class signin extends AppCompatActivity {
    final String TAG = "Database";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.sign_in );

        EditText phone = findViewById( R.id.editTextPhone );
        EditText password = findViewById( R.id.editTextPassword );
        Button sign_in = findViewById( R.id.sign_in2 );


        SharedPreferences mySharedPreferences = this.getSharedPreferences("MYPREFERENCENAME", Context.MODE_PRIVATE);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("User");
    //    DatabaseReference table1 = database.getReference("Admin");

        sign_in.setOnClickListener( new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String phoneNo = phone.getText().toString();
                String passwordNew = password.getText().toString();

                //set conditions for Input Values

                 if(phoneNo.isEmpty())  {
                     phone.setError( "Required" );
                     phone.requestFocus();
                        return;}

                if(phoneNo.length()< 10)  {
                    phone.setError( "Phone Number not valid" );
                    phone.requestFocus();
                    return;}

                if(phoneNo.length()> 10)  {
                    phone.setError( "Phone Number not valid" );
                    phone.requestFocus();
                    return;}

                if(passwordNew.isEmpty()){
                    password.setError( "Required" );
                    password.requestFocus();
                    return;}

               if(phoneNo.equals("0727098309") && passwordNew.equals("12345")){
                    Intent intent = new Intent(signin.this,AdminHome.class);
                    startActivity( intent );
                }//else{


                ProgressDialog mydialog = new ProgressDialog( signin.this );
                mydialog.setMessage( "Please wait..." );
                mydialog.show();
                table.addValueEventListener( new ValueEventListener() {
                @Override
                public void onDataChange( DataSnapshot dataSnapshot) {
                    // get user Information

                   if(dataSnapshot.child( phone.getText().toString()).exists()){
                       mydialog.dismiss();
                       User user = dataSnapshot.child( phone.getText().toString()).getValue(User.class) ;
                       if (user.getPassword().equals(password.getText().toString())){
                           mydialog.dismiss();
                          // Toast.makeText( signin.this,"Login Successfull",Toast.LENGTH_SHORT ).show();
                           String userName = user.getName();
                           SharedPreferences.Editor editor = mySharedPreferences.edit();
                           editor.putString("USERPHONE",phone.getText().toString());
                           editor.putString("USERNAME",userName);
                           editor.apply();
                           Intent intent1 = new Intent(signin.this,Home.class);
                           startActivity( intent1 );

                       }else{
                           Toast.makeText( signin.this,"Password is wrong. Enter Correct Password",Toast.LENGTH_SHORT ).show();
                       }
                   }else{
                       mydialog.dismiss();
                       Toast.makeText( signin.this,"User Invalid",Toast.LENGTH_SHORT ).show();
                   }
                }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.", databaseError.toException());
                    }
                });
//            }
               /* if(phone.getText().toString()=="0727098309"){

                table1.addValueEventListener( new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      //  if(dataSnapshot.child( phone.getText().toString()).exists()){
                            mydialog.dismiss();
                            User_Admin user1 = dataSnapshot.child( phone.getText().toString()).getValue(User_Admin.class) ;

                            if (user1.getPassword().equals(password.getText().toString())){
                                mydialog.dismiss();

                                Intent intent2 = new Intent(signin.this,Admin_Activity.class);
                                startActivity( intent2 );
                            }else{
                                Toast.makeText( signin.this,"Password is wrong. Enter Correct Password",Toast.LENGTH_SHORT ).show();
                            }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                } );
                }*/

            }
        });
    }
}
