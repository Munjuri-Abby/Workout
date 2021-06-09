package com.example.workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutFragment extends Fragment
{


//  created ExpandableListView so that I can use listview inside scrollview
    private ExpandableListView expandableListView;
    private ExpandableListAdapter listAdapter;
    private List<String> groupList;

    Map<String, List<String>> workoutCollection;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view;
        view = inflater.inflate(R.layout.fragment_workout, null);
        expandableListView = view.findViewById(R.id.elv_workout);
        createGroup();
        listAdapter = new MyExpandableListAdapter(WorkoutFragment.this.getActivity(), groupList, workoutCollection);
        expandableListView.setAdapter(listAdapter);

        return view;
    }

    public void createGroup()
    {
        groupList = new ArrayList<>();
        workoutCollection = new HashMap<>();

        groupList.add("Weight Loss College Edition");
        groupList.add("Build Muscle");
        groupList.add("Get in shape");

        List<String> weightLoss = new ArrayList<>();
        List<String> buildMuscle = new ArrayList<>();
        List<String> getShape = new ArrayList<>();

        //Weight Loss extended view workout list
        weightLoss.add("Day 1" +
                "\n Warmup:\n 10 min bike\n (3x Next Three Exercises)\n Pad Squats (6-8 reps) \n Pad Press (6-8) \n row (45 sec) " +
                "\n ---------------\n Main: \nA1:Decline Bench (10x10) A2:Sup Lat Pulldown (10x10) \nB1:Incline DB Flies (3x10-12) B2:DB Rows (3x10-12) \nC:Pushups (5x30 sec) "
                + "----------------\n Core: \nSwiss Ball Tucks(4x20)\nRussian Twist(4x20)"
                + "\n-----------------\n Cardio: (15-20 mins)");
        weightLoss.add("Day 2" +
                "\n Warmup:\n 10 min bike\n (3x Next Three Exercises)\n Band Pull Apart (10-12 reps) \n Band Good Morning (10-12) \n row (45 sec) " +
                "\n ---------------\n Main: \nA:Deadlift (3x5)\nB1:DB Front Squat (10x10) \nB2:DB RDL (10x10)\nC1:Alt Rev Lunges (3x10-12) \nC2:Leg EXT (3x10-12) "
                + "----------------\n Core: \nSupermans(3-4x20)\nPallof Press(3-4x8)"
                + "\n-----------------\n Cardio: (15-20 mins)");
        weightLoss.add("Day 3" +
                "\n Warmup:\n 10 min bike\n (3x Next Three Exercises)\n Face Pulls (10-12 reps) \n OH Pad Bar Squat (6-8) \n row (45 sec) " +
                "\n ---------------\n Main: \nA1:Dips 10x6) \nA2:DB Hammer Curls (10x8) \nB1:DB Lat Raise (3x10-12) B2:Face Pulls (3x10-12) "
                + "----------------\n Core: \nSupermans(3-4x20)\nPallof Press(3-4x8)"
                + "\n-----------------\nCardio: (15-20 mins)");


//Build Muscle Section for Extended view tab list
        buildMuscle.add("Chest Workout" +
                "\n Warmup:\n 10 min bike" +
                "\n ---------------\n Main: \nA:Cable Fly(5x12-15)\nB:Incline Barbell Press(3x8-12)(Last drop Fail) \nC:Flat DB Press(3x8-12) D:Flat BarBell Bench (3x8-10) \nE1:Incline Cable Fly (3x12-15) \nE2:Decline Cable Fly (3x12-15) "
                + "\n----------------\nCore Circuit(3 Rounds): \nBarbell/Ab Wheel Roll Out\nReverse Crunch Bench(12)\nPlank(30-60 sec)"
                + "\n-----------------\nCardio: (15 mins)");
        buildMuscle.add("Back Workout" +
                "\n Warmup:\n 10 min bike" +
                "\n ---------------\n Main: \nA:Cable Pullovers(3x12-15) B:Pull Ups(30 reps) \nC:Barbell Row(1x8-10 & 2x10-12)(Drop Last)\nD:Rack Pulls(1x6-8 & 2x10-12) \nE:Meadow Rows (4x8-12) \nF1:DB Pullovers (3x12)\nF2:Cable Pullovers(3x Fail) "
                + "\n-----------------\nCardio: (15 mins)");
        buildMuscle.add("Arms Workout" +
                "\n Warmup:\n 10 min bike" +
                "\n ---------------\n Main: \nA:Barbell Curls(5x12)\nB:Cable Skull Crushers(5x12) \nC1:Pushdowns(2x8-10 & 1x15+)\nC2:Wide Grip Cable Curl(2x8-10 & 1x15+) \nD1:Seated Incline Curls(3x10-12) \nD2:Overhead DB Ext (3x10-12)\nE:Standing Single Cable Curl(2x15-20)\nF:Single Arm Cross Tricep Ext(2x15-20) "
                + "\n-----------------\nCardio: (15 mins)");
        buildMuscle.add("Shoulders/Traps Workout" +
                "\n Warmup:\n 10 min bike" +
                "\n ---------------\n Main: \nA:DB Lateral Raise(5x12-15)\nB:DB Shoulder Press(5x10-12) \nC:DB Rear Delt Flyes(3x12)\nD:Cable Side Laterals(3x10* 5 Partials at end) \nE:Rope Front Raises(3x12) \nF1:Barbell Shrugs (4x10)\nF2:High Cable Rear Delt Flyes(4x10)"
                + "\n-----------------\nCardio: (15 mins)");
        buildMuscle.add("Legs Workout" +
                "\n Warmup:\n 10 min bike" +
                "\n ---------------\n Main: \nA:Lying Hamstring Curls(6x12)\nB:Back Squat(4x8) \nC1:Leg Press(High & Wide)(3x10)\nC2:Leg Press(Low & Close)(3x10) \nD:DB Romanian Deadlifts(1x6-8 & 2x10-12) \nE:Leg Extensions (3x25)\nF:Seated Calf Raise(4x25)"
                + "\n-----------------\nCardio: (15 mins)");

//Get In Shape Section for Extended view tab list
        getShape.add("Monday");
        getShape.add("Tuesday");
        getShape.add("Wednesday");

        workoutCollection.put(groupList.get(0), weightLoss);
        workoutCollection.put(groupList.get(1), buildMuscle);
        workoutCollection.put(groupList.get(2), getShape);


    }
    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        String[] workout = {"One lost", "Build muscle", "Get in shape"};
        firstview = view.findViewById(R.id. firstview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,workout);
        firstview.setAdapter(adapter);
        firstview.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        if (position==0)
        {
            Toast.makeText(getActivity(), "You have clicked one lost", Toast.LENGTH_SHORT).show();
        }
        if (position==1)
        {
            Toast.makeText(getActivity(),"Build muscle", Toast.LENGTH_SHORT).show();;
        }
        if (position==2){
            Toast.makeText(getActivity(), "Get in shape", Toast.LENGTH_SHORT).show();
        }
    }*/
}



