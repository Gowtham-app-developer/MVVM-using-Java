package com.gowtham.mvvmapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gowtham.mvvmapplication.R;
import com.gowtham.mvvmapplication.pojo.NewsResponse;
import com.gowtham.mvvmapplication.pojo.UserListResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private Context context;
    private ArrayList<UserListResponse> articles;
    private UserItemClickListener mItemClickListener;

    public UserListAdapter(Context context, ArrayList<UserListResponse> articles, UserItemClickListener mItemClickListener) {
        this.context = context;
        this.articles = articles;
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public UserListAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_news_item, parent, false);
        return new  UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.UserViewHolder holder, int position) {
        holder.ivNews.setVisibility(View.GONE);
        holder.tvName.setText(articles.get(position).getName().toString());
        holder.tvDescription.setText(articles.get(position).getBody().toString());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvName;
        TextView tvDescription;
        ImageView ivNews;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDesCription);
            ivNews = itemView.findViewById(R.id.ivNews);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }

    public interface UserItemClickListener {
        void onItemClick(int position);
    }
}
