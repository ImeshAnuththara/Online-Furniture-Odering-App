package com.example.chemwood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

public class Details_view extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.details_view );

        ImageView display_photo = findViewById( R.id.detail_photo );
        TextView display_tittle = findViewById( R.id.detail_title );
        TextView display_id = findViewById( R.id.detail_Id);
        TextView display_price = findViewById( R.id.detail_price);
        TextView display_des = findViewById( R.id.detail_description);
        Button display_btn = findViewById( R.id.detail_order_btn );

        Intent intent = getIntent();
        SharedPreferences mySharedPreferences = this.getSharedPreferences("MYPREFERENCENAME", Context.MODE_PRIVATE);
    //     String Photo = mySharedPreferences.getString("PHOTO", "");
     //   Bundle bundle = getIntent().getExtras();
     /*  if(bundle !=null){
            int photo1=bundle.getInt("photo");
            Toast.makeText( this,"position is ",Toast.LENGTH_SHORT ).show();
            display_photo.setImageResource(photo1);
        }
      */
        String tittle = intent.getStringExtra("Tittle");
        String id = intent.getStringExtra("Id");
        String photo = getIntent().getStringExtra("photo");
        String description = intent.getStringExtra("description");
        String price = intent.getStringExtra("price");
        Glide.with( this ).load( photo ).into( display_photo );
       // int i1 = Integer.parseInt( photo );

        display_id.setText(id);
        display_tittle.setText(tittle);
        display_price.setText(price);
        display_des.setText(description);
       // display_photo.setTooltipText( Photo  );


     //   textView.setText( id );
        display_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fid = display_id.getText().toString();
                String Ftittle = display_tittle.getText().toString();
                String Fprice = display_price.getText().toString();
                Intent intent= new Intent(Details_view.this,Order.class);
                intent.putExtra("Id", Fid );
                intent.putExtra( "Tittle", Ftittle);
                intent.putExtra( "price",Fprice);
                startActivity( intent );
            }
        } );

        //Intent intent= new Intent(v.getContext(),Admin_Activity.class);
        // v.getContext().startActivity( intent );


    }
}
