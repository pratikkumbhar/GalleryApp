package com.example.galleryapp.Adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.galleryapp.Model.Photo;
import com.example.galleryapp.Model.Photos;
import com.example.galleryapp.R;

import java.util.List;

public class RecycleAdaptor extends RecyclerView.Adapter<RecycleAdaptor.viewHolder> {
    private Context context;
    private Photos photolist;


    public RecycleAdaptor(Context context, Photos photolist) {
        this.context = context;
        this.photolist = photolist;
    }

    public void setPhotolist(Photos photolist)
    {
        this.photolist = photolist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycle_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdaptor.viewHolder holder, int position) {
        String uri = this.photolist.getPhoto().get(position).getUrlS();
        Log.i("123",uri);
        Glide.with(context)
                .load(uri)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
if (this.photolist!=null)
{
    return this.photolist.getPhoto().size();
}
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImageView);
        }

    }
}
