package com.example.efarraro.readit.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.efarraro.readit.R;
import com.example.efarraro.readit.data.OnTaskCompleteListener;
import com.example.efarraro.readit.data.model.Listing;
import com.example.efarraro.readit.domain.interactor.GetListing;
import com.example.efarraro.readit.view.adapter.PostListAdapater;

public class ListingPresenter implements Presenter, OnTaskCompleteListener<Listing> {

    //@Inject
    public GetListing getListingUseCase;
    private View view;

    private RecyclerView postList;
    private PostListAdapater listAdapter;

    @Override public void create() {
        getListingUseCase = new GetListing();
        getListingUseCase.setTaskCompleteListener(this);
        getListingUseCase.execute("hearthstone");
    }

    public void setView(View view) {
        this.view = view;
        postList = (RecyclerView) view.findViewById(R.id.post_list);

        if (listAdapter != null) {
            postList.setAdapter(listAdapter);
        }
    }

    @Override public void taskCompleted(Listing result) {
        listAdapter = new PostListAdapater(result.data.children);
        postList.setAdapter(listAdapter);
    }
}
