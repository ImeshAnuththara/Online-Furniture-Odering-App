package com.example.chemwood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HelperMenuAdapter extends RecyclerView.Adapter {

    List<FetchMenuData> fetchMenuDataList;
    //  private ItemClickListener listener;
    String categoryId="";

    private void LoadMenu(String categoryId) {
    }

    public HelperMenuAdapter(List<FetchMenuData> fetchMenuDataList) {
        this.fetchMenuDataList=fetchMenuDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.menu_items,parent,false);
        HelperMenuAdapter.ViewHolderClass viewHolderClass=new HelperMenuAdapter.ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public int getItemCount() {
        return fetchMenuDataList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );
            imageView = itemView.findViewById( R.id.menu_photo_recycle );
            textView = itemView.findViewById( R.id.menu_title_recycle );
          //  ImageView img =itemView.findViewById( R.id.menu_photo_recycle);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HelperMenuAdapter.ViewHolderClass viewHolderClass = (HelperMenuAdapter.ViewHolderClass) holder;
        FetchMenuData fetchMenuData = fetchMenuDataList.get( position );
        viewHolderClass.textView.setText(fetchMenuData.getTittle());
        Glide.with( viewHolderClass.imageView.getContext()).load(fetchMenuData.getPhoto()).into( viewHolderClass.imageView);
        //  String photo1 = fetchMenuData.getPhoto();
       // ImageView photodisplay=img.getText;
      //  int i1 = Integer.parseInt(photo1);

      //  int photodisplay1= int.parseDouble
        viewHolderClass.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText( v.getContext(),"position is "+ position,Toast.LENGTH_SHORT ).show();
                Intent intent= new Intent(v.getContext(),Details_view.class);
                intent.putExtra( "Id",fetchMenuData.getId());
                intent.putExtra( "Tittle",fetchMenuData.getTittle());
                intent.putExtra( "photo",fetchMenuData.getPhoto());
                intent.putExtra( "description",fetchMenuData.getDescription());
                intent.putExtra( "price",fetchMenuData.getPrice());
                v.getContext().startActivity( intent );
            }
        } );
    }
}