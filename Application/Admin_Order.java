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

public class Admin_Order extends AppCompatActivity {

    RecyclerView recyclerView;
    List<AdminFetchData> adminfetchDataList;
    DatabaseReference databaseReference;
    AdminHelperAdapter adminhelperAdapter;
    private Object MenuItem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin__order );
        recyclerView = findViewById( R.id.Admin_recycle_view );
        adminfetchDataList = new ArrayList<>();
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

      //  String request_key=table.getKey();
      //  databaseReference=FirebaseDatabase.getInstance().getReference("Order");
        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = FirebaseDatabase.getInstance().getReference("Order");

       // String request_key=table.getKey();
        table.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             //   Iterable<DataSnapshot>ds=dataSnapshot.getChildren();
                for(DataSnapshot ds:dataSnapshot.getChildren()){

                    AdminFetchData adminfetchData=ds.getValue(AdminFetchData.class);
                    adminfetchDataList.add( adminfetchData);
                }
                adminhelperAdapter = new AdminHelperAdapter(adminfetchDataList);
                recyclerView.setAdapter(adminhelperAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        } );
    }
}