package com.example.efarraro.readit.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.efarraro.readit.R;
import com.example.efarraro.readit.data.model.Post;
import java.util.List;

public class PostListAdapater extends RecyclerView.Adapter<PostViewHolder> {

    public List<Post> posts;

    public PostListAdapater(List<Post> posts) {
        this.posts = posts;
    }

    @Override public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        return new PostViewHolder(view);
    }

    @Override public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.title.setText(posts.get(position).data.title);
    }

    @Override public int getItemCount() {
        return posts.size();
    }
}
