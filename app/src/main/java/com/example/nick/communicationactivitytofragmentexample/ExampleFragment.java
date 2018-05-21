package com.example.nick.communicationactivitytofragmentexample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nick on 21/05/18.
 */

public class ExampleFragment extends Fragment implements MainActivity.DataLoadedListener {
    TextView tvStringList;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvStringList = view.findViewById(R.id.tvStringList);
    }

    @Override
    public void onDataLoaded(ArrayList<String> data) {
        for (String s : data){
            tvStringList.append(s + "\n");
        }
    }
}
