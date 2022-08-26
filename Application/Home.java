package com.example.chemwood;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.Model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

public class Home extends AppCompatActivity {
    RecyclerView recyclerView;
    List<FetchData> fetchDataList;
    DatabaseReference databaseReference;
    HelperAdapter helperAdapter;
    private Object MenuItem;

//    Intent intent = getIntent();
//    String CurrentUser1 = intent.getStringExtra("currentUser");
//    String Currentphone = intent.getStringExtra("currentPhone");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_homeview );
        recyclerView = findViewById( R.id.recycle_view );
        fetchDataList = new ArrayList<>();
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        databaseReference=FirebaseDatabase.getInstance().getReference("Category");
        databaseReference.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    FetchData fetchData=ds.getValue(FetchData.class);
                    fetchDataList.add( fetchData);
                }
                helperAdapter = new HelperAdapter(fetchDataList);
                recyclerView.setAdapter(helperAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        } );

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation1:
                Intent nextActivity1 = new Intent(Home.this, Home.class);
                startActivity(nextActivity1);
                return true;
            case R.id.navigation2:
                Intent nextActivity2 = new Intent(Home.this, Admin_Activity.class);
                startActivity(nextActivity2);
                return true;
            case R.id.navigation3:
                Intent nextActivity3 = new Intent(Home.this, Admin_Activity.class);
                startActivity(nextActivity3);
                return true;
            case R.id.navigation4:
                Toast.makeText( Home.this, "Logout Sucess", Toast.LENGTH_SHORT ).show();
                Intent nextActivity4 = new Intent(Home.this, signin.class);
                startActivity(nextActivity4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

/*
public class Home extends AppCompatActivity {
    RecyclerView recyclerView;
    private DatabaseReference myref;
    private ArrayList<Category> categoryList;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_homeview );

        recyclerView = findViewById( R.id.recycle_view );

        LinearLayoutManager layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize( true );

        myref = FirebaseDatabase.getInstance().getReference();
        categoryList = new ArrayList<>();
        //ClearAll();
        if(categoryList !=null){categoryList.clear();}
        if(recyclerAdapter !=null){
            recyclerAdapter.notifyDataSetChanged();
        }
        categoryList = new ArrayList<>();

        // GetDataFromFirebase();
        Query query = myref.child( "Category" );
        query.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //ClearAll();
                if(categoryList !=null){categoryList.clear();}
                if(recyclerAdapter !=null){
                    recyclerAdapter.notifyDataSetChanged();
                }
                categoryList = new ArrayList<>();

                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Category category = new Category();

                    category.setPhoto( snapshot.child( "Photo" ).getValue().toString() );
                    category.setTitle( snapshot.child( "Tittle" ).getValue().toString() );

                    categoryList.add( category );
                }
                recyclerAdapter=new RecyclerAdapter( getApplicationContext(),categoryList );
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();

                recyclerAdapter.OnRecycleViewClickListener( new RecyclerAdapter.OnRecycleViewClickListener() {
                    @Override
                    public void OnItemClick(int position) {
                        Toast.makeText( Home.this,"posistion"+position,Toast.LENGTH_SHORT );
                    }
                } );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        } );
    }
    // private void GetDataFromFirebase(){

    //  }
    // private void ClearAll(){
    // }

}

 */

/*#######################################former code worked but onclick doesn't work #############################
 @Override
    public void onItemClick(View view, int position) {
        Context context=view.getContext();
        Intent intent=new Intent();
        switch (position){
            case 0: intent = new Intent(context, ChildActivity.class);
            context.startActivity(intent);
            break;
            case 1: intent = new Intent(context, ChildActivity2.class);
            context.startActivity(intent);
            break; }
    }

 ######################## End of code ####################################################*/

/*
// ######################################### Menu display ##########################################################
    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
            return true;
        }

        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation1:
                    Intent nextActivity1 = new Intent(Home.this, Admin_Activity.class);
                    startActivity(nextActivity1);
                    return true;
                case R.id.navigation2:
                    Intent nextActivity2 = new Intent(Home.this, Admin_Activity.class);
                    startActivity(nextActivity2);
                    return true;
                case R.id.navigation3:
                    Intent nextActivity3 = new Intent(Home.this, Admin_Activity.class);
                    startActivity(nextActivity3);
                    return true;
                case R.id.navigation4:
                    Intent nextActivity4 = new Intent(Home.this, Admin_Activity.class);
                    startActivity(nextActivity4);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

##########################################################################################################

 */








