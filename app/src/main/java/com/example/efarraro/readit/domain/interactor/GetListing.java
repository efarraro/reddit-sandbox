package com.example.efarraro.readit.domain.interactor;

import android.os.AsyncTask;
import com.example.efarraro.readit.data.OnTaskCompleteListener;
import com.example.efarraro.readit.data.model.Listing;
import com.example.efarraro.readit.domain.repository.SubredditRepository;
import retrofit.RestAdapter;

public class GetListing extends AsyncTask<String, Void, Listing>{

    private OnTaskCompleteListener<Listing> taskCompleteListener;

    @Override protected Listing doInBackground(String... strings) {
        RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("https://api.reddit.com")
            .build();
        SubredditRepository service = restAdapter.create(SubredditRepository.class);
        return service.getHotTopicListing("hearthstone");
    }

    @Override protected void onPostExecute(Listing listing) {
        super.onPostExecute(listing);

        if (taskCompleteListener != null) {
            taskCompleteListener.taskCompleted(listing);
        }
    }

    public void setTaskCompleteListener(OnTaskCompleteListener<Listing> taskCompleteListener) {
        this.taskCompleteListener = taskCompleteListener;
    }
}
