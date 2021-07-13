package com.anjitha.nytimesdemoapp.newslist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anjitha.nytimesdemoapp.R;
import com.anjitha.nytimesdemoapp.models.Result;
import com.bumptech.glide.Glide;
import java.util.List;

public class NewsListAdapter  extends RecyclerView.Adapter<NewsListAdapter.NewsResultHolder>{

    private List<Result> results;


    @NonNull
    @Override
    public NewsResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_news_list_item, parent, false);

        return new NewsResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsResultHolder holder, int position) {
        Result newsItem = results.get(position);
       if(null != newsItem) {
           holder.titleTV.setText(newsItem.getTitle());
           holder.subTitleTv.setText(newsItem.getByline());
           holder.dateTV.setText(newsItem.getPublishedDate());
           holder.nameTV.setText(newsItem.getSource());
           if (null != newsItem.getMedia() && newsItem.getMedia().size() > 0 && null != newsItem.getMedia().get(0)
                   && null != newsItem.getMedia().get(0).getMediaMetadata() && null != newsItem.getMedia().get(0).getMediaMetadata().get(0).getUrl()) {
               String imageUrl = newsItem.getMedia().get(0).getMediaMetadata().get(0).getUrl();
               Glide.with(holder.itemView)
                       .load(imageUrl)
                       .circleCrop()
                       .into(holder.thumbnailIV);
           }

       }
    }

    @Override
    public int getItemCount() {
        if(null != results) {
            return results.size();
        }
        return 0;
    }

    public void setResults(List<Result> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class NewsResultHolder extends RecyclerView.ViewHolder {
        private TextView titleTV;
        private TextView subTitleTv;
        private TextView nameTV;
        private TextView dateTV;
        private ImageView thumbnailIV;

        public NewsResultHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.newsTitleTV);
            subTitleTv = itemView.findViewById(R.id.newsSubTitleTV);
            nameTV = itemView.findViewById(R.id.nameTV);
            dateTV = itemView.findViewById(R.id.dateTV);
            thumbnailIV = itemView.findViewById(R.id.newsIV);
        }
    }
}
