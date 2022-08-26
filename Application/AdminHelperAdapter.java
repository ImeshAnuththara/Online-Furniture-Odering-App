package com.example.chemwood;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdminHelperAdapter extends RecyclerView.Adapter {

    List<AdminFetchData> adminfetchDataList;

    public AdminHelperAdapter(List<AdminFetchData> adminfetchDataList) {
        this.adminfetchDataList=adminfetchDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.activity_admin_order_displaytemplate,parent,false);
        AdminHelperAdapter.ViewHolderClass viewHolderClass=new AdminHelperAdapter.ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public int getItemCount() {
        return adminfetchDataList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{
      //  ImageView imageView;
        TextView textView,textView1;

        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );
          //  imageView = itemView.findViewById( R.id.menu_photo_recycle );
            textView = itemView.findViewById( R.id.order_display);
            textView1 = itemView.findViewById( R.id.order_display_phone);
/*          textView = itemView.findViewById( R.id.order_phone1 );
            textView = itemView.findViewById( R.id.order_address1 );
            textView = itemView.findViewById( R.id.order_furnitureName1 );
            textView = itemView.findViewById( R.id.order_furnitureId1 );
            textView = itemView.findViewById( R.id.order_unitPrice1 );
            textView = itemView.findViewById( R.id.order_units1 );
            textView = itemView.findViewById( R.id.order_totprice1 );
    */
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AdminHelperAdapter.ViewHolderClass viewHolderClass = (AdminHelperAdapter.ViewHolderClass) holder;
        AdminFetchData adminfetchData = adminfetchDataList.get( position );
        viewHolderClass.textView.setText(adminfetchData.getPhone());
        viewHolderClass.textView1.setText(adminfetchData.getName());
/*      viewHolderClass.textView.setText(adminfetchData.getPhone());
        viewHolderClass.textView.setText(adminfetchData.getAddress());
        viewHolderClass.textView.setText(adminfetchData.getFurnitureName());
        viewHolderClass.textView.setText(adminfetchData.getFurnitureID());
        viewHolderClass.textView.setText(adminfetchData.getUnitPrice());
        viewHolderClass.textView.setText(adminfetchData.getUnits());
        viewHolderClass.textView.setText(adminfetchData.getTotalPrice());

 */
       // Glide.with( viewHolderClass.imageView.getContext()).load(fetchMenuData.getPhoto()).into( viewHolderClass.imageView);

        viewHolderClass.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Toast.makeText( v.getContext(),"complete ",Toast.LENGTH_SHORT ).show();
                Intent intent= new Intent(v.getContext(),AdminOrderTemplate.class);
                intent.putExtra( "Name",adminfetchData.getName());
                intent.putExtra( "Phone",adminfetchData.getPhone());
                intent.putExtra( "Address",adminfetchData.getAddress());
                intent.putExtra( "FName",adminfetchData.getFurnitureName());
                intent.putExtra( "FId",adminfetchData.getFurnitureID());
                intent.putExtra( "UPrice",adminfetchData.getUnitPrice());
                intent.putExtra( "Units",adminfetchData.getUnits());
                intent.putExtra( "Total",adminfetchData.getTotalPrice());
                v.getContext().startActivity( intent );
            }
        } );
    }
}
