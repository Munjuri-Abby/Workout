package com.example.workout;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyExpandableListAdapter extends BaseExpandableListAdapter
{
    Context context;
    private Map<String, List<String>> workoutCollection;
    private  List<String> groupList;
    public View view;



    public MyExpandableListAdapter(Context context, List<String> groupList, Map <String, List<String>> workoutCollection)
    {
        this.context = context;
        this.workoutCollection = workoutCollection;
        this.groupList = groupList;
    }


    @Override
    public int getGroupCount()
    {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return workoutCollection.get(groupList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return workoutCollection.get(groupList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent)
    {
        String workoutName = getGroup(groupPosition).toString();
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.parent_item, null);
        }

        TextView item = view.findViewById(R.id.workoutName);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(workoutName);

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent)
    {
        String workoutType = getChild(groupPosition,childPosition).toString();
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_item, null);
        }

        TextView item = view.findViewById(R.id.workoutType);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(workoutType);


        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }
}
