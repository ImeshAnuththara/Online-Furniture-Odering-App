package com.example.chemwood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AdminHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin_home );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Adminnavigation1:
                Intent nextActivity1 = new Intent(AdminHome.this, Admin_upload.class);
                startActivity(nextActivity1);
                return true;
            case R.id.Adminnavigation2:
                Intent nextActivity2 = new Intent(AdminHome.this, Admin_Order.class);
                startActivity(nextActivity2);
                return true;
            case R.id.Adminnavigation3:
                Intent nextActivity3 = new Intent(AdminHome.this, signin.class);
                startActivity(nextActivity3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}