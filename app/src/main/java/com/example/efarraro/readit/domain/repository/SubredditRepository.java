package com.example.efarraro.readit.domain.repository;

import com.example.efarraro.readit.data.model.Listing;
import retrofit.http.GET;
import retrofit.http.Path;

public interface SubredditRepository {
    @GET("/r/{subreddit}/hot") Listing getHotTopicListing(@Path("subreddit") String subreddit);
}
