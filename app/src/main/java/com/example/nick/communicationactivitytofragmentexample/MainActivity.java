package com.example.nick.communicationactivitytofragmentexample;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DataLoadedListener mDataLoadedListener;
    FrameLayout flContainer;
    ArrayList<String> myStrings;
    Fragment mExampleFragment;
    Button btLoadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flContainer = findViewById(R.id.flContainer);
        btLoadData = findViewById(R.id.btLoadData);
        // Create new fragment and transaction
        mExampleFragment = new ExampleFragment();
        // setting mExampleFragment as data load listener
        mDataLoadedListener = (DataLoadedListener) mExampleFragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack if needed
        transaction.replace(R.id.flContainer, mExampleFragment);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();

        // load data after click
        btLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
                // notify attached fragment
                mDataLoadedListener.onDataLoaded(myStrings);
            }
        });

    }

    private void loadData() {
        myStrings = new ArrayList<>();
        myStrings.add("one");
        myStrings.add("two");
        myStrings.add("three");
    }

    public interface DataLoadedListener {
        public void onDataLoaded(ArrayList<String> data);
    }
}
