package com.example.workout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//Bridge for the view
public class BmiAdapter extends BaseAdapter
{
    private ArrayList<String> bmi_list;

    private ArrayList<String> time_list;
    public LayoutInflater inflater;
    public Activity context;

    public BmiAdapter(Activity context, ArrayList<String> bmi_list, ArrayList<String> time_list)
    {
        super();
        this.bmi_list = bmi_list;
        this.time_list = time_list;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {

        return bmi_list.size();

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    public class ViewHolder
    {
        TextView bmi;
        TextView time;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.bmi_list,null);
            holder.bmi = convertView.findViewById(R.id.bmi);
            holder.time = convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.bmi.setText(bmi_list.get(position));
        holder.time.setText(time_list.get(position));
        return convertView;
    }
}
