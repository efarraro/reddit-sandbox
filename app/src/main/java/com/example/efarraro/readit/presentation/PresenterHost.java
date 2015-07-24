package com.example.efarraro.readit.presentation;

import android.app.Fragment;
import android.os.Bundle;

public class PresenterHost extends Fragment {

    private Presenter presenter;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
