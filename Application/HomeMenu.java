package com.example.chemwood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeMenu extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FetchMenuData> fetchMenuDataList;
    DatabaseReference databaseReference;
    HelperMenuAdapter helperMenuAdapter;
    private Object MenuItem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SharedPreferences mySharedPreferences = this.getSharedPreferences("MYPREFERENCENAME", Context.MODE_PRIVATE);
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu_view );
        recyclerView = findViewById( R.id.menu_recycle_view1 );
        fetchMenuDataList = new ArrayList<>();
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
       // if(position == 0)
        databaseReference=FirebaseDatabase.getInstance().getReference("Chair");
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        MenuItem menuItem = menu.findItem( R.id.navigation3 );
/*       SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint( "Type here to Search" );
        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
             //   fetchMenuDataList.getFilter.filter(newText);
                return false;
            }
        } );

 */
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation1:
                Intent nextActivity1 = new Intent(HomeMenu.this, Admin_Activity.class);
                startActivity(nextActivity1);
                return true;
            case R.id.navigation2:
                Intent nextActivity2 = new Intent(HomeMenu.this, Admin_Activity.class);
                startActivity(nextActivity2);
                return true;
      /*      case R.id.navigation3:
                Intent nextActivity3 = new Intent(HomeMenu.this, Admin_Activity.class);
                startActivity(nextActivity3);
                return true;

       */
            case R.id.navigation4:
                Intent nextActivity4 = new Intent(HomeMenu.this, Admin_Activity.class);
                startActivity(nextActivity4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}