package com.example.chemwood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HelperAdapter extends RecyclerView.Adapter {

    List<FetchData> fetchDataList;
  //  private ItemClickListener listener;

    public HelperAdapter(List<FetchData> fetchDataList) {
        this.fetchDataList=fetchDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.view_items,parent,false);
        ViewHolderClass viewHolderClass=new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public int getItemCount() {
        return fetchDataList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );
            imageView = itemView.findViewById( R.id.photo_recycle );
            textView = itemView.findViewById( R.id.title_recycle );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass = (ViewHolderClass) holder;
        FetchData fetchData = fetchDataList.get( position );
        viewHolderClass.textView.setText(fetchData.getTittle());
        Glide.with( viewHolderClass.imageView.getContext()).load(fetchData.getPhoto()).into( viewHolderClass.imageView);
        viewHolderClass.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText( v.getContext(),"position is "+ position,Toast.LENGTH_SHORT ).show();
             //   Intent intent= new Intent(v.getContext(),HomeMenu.class);
             //   intent.putExtra( "categoryId",fetchData.getId());
             //   v.getContext().startActivity( intent );
                switch (position){
                    case 0: Intent intent = new Intent(v.getContext(), HomeMenu.class);
                        v.getContext().startActivity(intent);
                        break;
                    case 1: intent = new Intent(v.getContext(), Table.class);
                        v.getContext().startActivity(intent);
                        break;
                    case 2: intent = new Intent(v.getContext(), HomeMenuCupboard.class);
                        v.getContext().startActivity(intent);
                        break;
                    case 3: intent = new Intent(v.getContext(), HomeMenuBabyCots.class);
                        v.getContext().startActivity(intent);
                        break;
                    case 4: intent = new Intent(v.getContext(), HomeMenuBed.class);
                        v.getContext().startActivity(intent);
                        break;
                    case 5: intent = new Intent(v.getContext(), HomeMenuConerStand.class);
                        v.getContext().startActivity(intent);
                        break;
                    case 6: intent = new Intent(v.getContext(), HomeMenuChest.class);
                        v.getContext().startActivity(intent);
                        break;
                    case 7: intent = new Intent(v.getContext(), HomeMenuPlay.class);
                        v.getContext().startActivity(intent);
                        break;
                }

                }
        } );
    }
}




/*
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static  final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<Category> categoryList;
    private OnRecycleViewClickListener listener;

    public interface OnRecycleViewClickListener{
        void OnItemClick(int position);
    }

    public void OnRecycleViewClickListener(OnRecycleViewClickListener listener) {
        this.listener = listener;
    }

    public RecyclerAdapter(Context mContext, ArrayList<Category> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.view_items,parent,false );
        return  new ViewHolder( view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText( categoryList.get( position ).getTitle());
        Glide.with(mContext).load( categoryList.get( position ).getPhoto()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView,OnRecycleViewClickListener listener) {
            super( itemView );

            imageView = itemView.findViewById( R.id.photo_recycle );
            textView = itemView.findViewById( R.id.title_recycle );

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null && getAdapterPosition()!= RecyclerView.NO_POSITION){
                        listener.OnItemClick(getAdapterPosition());
                    }
                }
            } );
        }


    }
}

 */
/* ################################## code #######################################


################################ End ############################## */
/*
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_items, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String category = mData.get(position);
        holder.myTextView.setText(category);
      //  holder.myImageView.setImageDrawable(images);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageView myImageView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.title_recycle);
            myImageView = itemView.findViewById( R.id.photo_recycle );
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

##########################################################################################################

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textView;
    public ImageView imageView;

    private ItemClickListener itemClickListener;

    public MenuViewHolder(@NonNull View itemView) {
        super( itemView );
        imageView = (ImageView) itemView.findViewById( R.id.photo_recycle );
        textView = (TextView) itemView.findViewById( R.id.title_recycle );

        itemView.setOnClickListener( this );
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick( view,getAdapterPosition(),false );
    }
}

*/
