package com.example.efarraro.readit.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.efarraro.readit.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView title;

    public PostViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.title);
    }
}
