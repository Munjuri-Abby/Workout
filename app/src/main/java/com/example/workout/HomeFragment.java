package com.example.workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;

public class HomeFragment extends Fragment
{

    ListView listView;
    DBHelper dbHelper;
    BmiAdapter bmiAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        listView =getView().findViewById(R.id.listview);
        dbHelper = new DBHelper(getContext());
        ArrayList bmiList;
        ArrayList timeList;

        bmiList = dbHelper.getAllBMis();
        timeList = dbHelper.getAllTimestamps();

        // reverses the order of each day of calories
        Collections.reverse(bmiList);
        Collections.reverse(timeList);

        //link everything and display to the user
        bmiAdapter = new BmiAdapter(getActivity(), bmiList, timeList);
        listView.setAdapter(bmiAdapter);
    }


}
