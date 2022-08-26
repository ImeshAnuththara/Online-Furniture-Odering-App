package com.example.chemwood;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeMenuConerStand extends AppCompatActivity {
    RecyclerView recyclerView;
    List<FetchMenuData> fetchMenuDataList;
    DatabaseReference databaseReference;
    HelperMenuAdapter helperMenuAdapter;
    private Object MenuItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu_view );
        recyclerView = findViewById( R.id.menu_recycle_view1 );
        fetchMenuDataList = new ArrayList<>();
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        // if(position == 0)
        databaseReference= FirebaseDatabase.getInstance().getReference("ConerStands");
        databaseReference.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    FetchMenuData fetchMenuData=ds.getValue(FetchMenuData.class);
                    fetchMenuDataList.add( fetchMenuData);
                }
                helperMenuAdapter = new HelperMenuAdapter(fetchMenuDataList);
                recyclerView.setAdapter(helperMenuAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        } );

    }
}
