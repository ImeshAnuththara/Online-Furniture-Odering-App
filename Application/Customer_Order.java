package com.example.chemwood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Customer_Order extends AppCompatActivity {

        RecyclerView recyclerView;
        List<CustomerFetchData> adminfetchDataList;
        DatabaseReference databaseReference;
        CustomerHelperAdapter adminhelperAdapter;
        private Object MenuItem;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_customer__order );
            recyclerView = findViewById( R.id.Customer_recycle_view );
            adminfetchDataList = new ArrayList<>();
            recyclerView.setLayoutManager( new LinearLayoutManager(this));

            DatabaseReference table = FirebaseDatabase.getInstance().getReference("Order");

            // String request_key=table.getKey();
            table.addListenerForSingleValueEvent( new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    //   Iterable<DataSnapshot>ds=dataSnapshot.getChildren();
                    for(DataSnapshot ds:dataSnapshot.getChildren()){

                        CustomerFetchData adminfetchData=ds.getValue(CustomerFetchData.class);
                        adminfetchDataList.add( adminfetchData);
                    }
                    adminhelperAdapter = new CustomerHelperAdapter(adminfetchDataList);
                    recyclerView.setAdapter(adminhelperAdapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            } );

        }
}