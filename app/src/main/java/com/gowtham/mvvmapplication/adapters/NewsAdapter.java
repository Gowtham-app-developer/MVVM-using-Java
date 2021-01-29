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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private ArrayList<NewsResponse.NewsArticle> articles;
    private UserItemClickListener mItemClickListener;

    public NewsAdapter(Context context, ArrayList<NewsResponse.NewsArticle> articles,
                       UserItemClickListener mItemClickListener) {
        this.context = context;
        this.articles = articles;
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_news_item, parent, false);
        return new  NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        holder.tvName.setText(articles.get(position).getTitle().toString());
        holder.tvDescription.setText(articles.get(position).toString());
        Picasso.get().load(articles.get(position).getUrlToImage()).into(holder.ivNews);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvName;
        private TextView tvDescription;
        private ImageView ivNews;
        private NewsResponse.NewsArticle mArticles;

        public NewsViewHolder(@NonNull View itemView) {
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
