package com.example.moviehive.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviehive.R;
import com.example.moviehive.Service.Model.Result;

import java.util.List;

import retrofit2.Call;

public class TopRatedMovieAdapter extends RecyclerView.Adapter<TopRatedMovieAdapter.MyViewHolder> {

    private Context context;
    private List<Result> mList;

    public TopRatedMovieAdapter(Context context, List<Result> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item,parent,false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mTitle.setText(mList.get(position).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+mList.get(position).getPosterPath())
                .into(holder.mImageView);


    }

    @Override
    public int getItemCount() {

        if (mList!=null)
        {
            return mList.size();
        }else {
            return 0;
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.avatar);
            mTitle = itemView.findViewById(R.id.movieTitle);
        }
    }
}
