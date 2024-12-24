package com.example.NETRAController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ImageViewHolder> {

    Context context;
    List<Integer> imagelist;

    public imageAdapter(List<Integer> imagelist, Context context) {
        this.imagelist = imagelist;
        this.context = context;
    }

    @NonNull
    @Override
    public imageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.imagelist,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull imageAdapter.ImageViewHolder holder, int position) {
        holder.image.setImageResource(imagelist.get(position));
    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);

        }
    }
}