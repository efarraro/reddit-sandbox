package com.example.efarraro.readit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.example.efarraro.readit.presentation.ListingPresenter;
import com.example.efarraro.readit.presentation.PresenterHost;

public class MainActivity extends AppCompatActivity {

    private PresenterHost presenterHost;

    //@Inject
    private ListingPresenter listingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenterHost = (PresenterHost) getFragmentManager().findFragmentByTag("presenter");
        if (presenterHost == null) {
            listingPresenter = new ListingPresenter();
            presenterHost = new PresenterHost();
            presenterHost.setPresenter(listingPresenter);
            getFragmentManager().beginTransaction().add(presenterHost, "presenter").commit();

            presenterHost.getPresenter().create();
        }

        listingPresenter.setView(findViewById(R.id.content));
        ((RecyclerView)findViewById(R.id.post_list)).setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
