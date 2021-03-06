package com.example.diandiantv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ChannelViewHolder> {
    private List<Channel> channels;
    private OnClick listener;
    private Context context;

   public ChannelListAdapter(List<Channel> channels, OnClick listener) {
        this.listener = listener;
        this.channels = channels;
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.channel, parent,false);
        ChannelViewHolder holder = new ChannelViewHolder(row);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, holder.getLayoutPosition());

            }
        });
        return holder;
    }

   @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, int position) {
        holder.bind(context, channels.get(position));
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    public class ChannelViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView quality;
        private ImageView logo;

        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            quality = itemView.findViewById(R.id.quality);
            logo = itemView.findViewById(R.id.imageView);
        }

        public void bind(Context context, Channel c) {
            title.setText(c.getTitle());
            quality.setText(c.getQuality());
            Glide.with(context)
                    .load(c.getImage())
                    .override(320, 320)
                    .placeholder(R.drawable.pig)
                    .into(logo);
        }
    }
}
