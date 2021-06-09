package com.example.workout;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class              DiaryFragment extends Fragment implements RemoveClickListner
{
    private RecyclerView mRecyclerView,mRecyclerViewLunch,mRecyclerViewDinner,mRecyclerViewExercise,mRecyclerViewSnacks;
    private RecyclerAdapter mRecyclerAdapter,mRecyclerAdapterLunch,mRecyclerAdapterDinner,mRecyclerAdapterSnacks,mRecyclerAdapterExcercise;
    private RecyclerView.LayoutManager mLayoutManager;

    TextView btnAddItem,btnAddItemLunch,btnAddItemDinner,btnAddItemSnacks,btnAddItemExcercise,btnAdd;

    ArrayList<RecyclerViewData> myList = new ArrayList<>();
    ArrayList<RecyclerViewData> myListLunch = new ArrayList<>();
    ArrayList<RecyclerViewData> myListDinner = new ArrayList<>();
    ArrayList<RecyclerViewData> myListExcercise = new ArrayList<>();
    ArrayList<RecyclerViewData> myListSnacks= new ArrayList<>();


    TextView textViewGoal,textViewFood,textViewExcercise,textViewRemaining;
    EditText etTitle, etDescription;
    String title = "", description = "";
    ImageView crossImage;
    Dialog builder;
    int totalFood=0,totalExcercise=0,totalGoal=0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);
        mRecyclerView = (RecyclerView)view. findViewById(R.id.recyclerbreakfast_view);
        mRecyclerViewDinner = (RecyclerView)view. findViewById(R.id.recyclerDinner_view);
        mRecyclerViewExercise = (RecyclerView)view. findViewById(R.id.recyclerExcercise_view);
        mRecyclerViewSnacks = (RecyclerView)view. findViewById(R.id.recyclerSnacks_view);
        mRecyclerViewLunch = (RecyclerView)view. findViewById(R.id.recyclerLunch_view);

        textViewGoal=view.findViewById(R.id.textGoal);
        textViewFood=view.findViewById(R.id.textFood);
        textViewExcercise=view.findViewById(R.id.textExcercise);
        textViewRemaining=view.findViewById(R.id.textTotal);

        //Attach Linear Layout with mRecyclerView Breakfest
        mRecyclerAdapter = new RecyclerAdapter(myList, this::OnRemoveClick,"1");
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        //Attach Linear Layout with mRecyclerViewLunch
        mRecyclerAdapterLunch = new RecyclerAdapter(myListLunch, this::OnRemoveClick,"2");
        final LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewLunch.setLayoutManager(layoutManager1);
        mRecyclerViewLunch.setAdapter(mRecyclerAdapterLunch);

        //Attach Linear Layout with mRecyclerViewDinner
        mRecyclerAdapterDinner = new RecyclerAdapter(myListDinner, this::OnRemoveClick,"3");
        final LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewDinner.setLayoutManager(layoutManager2);
        mRecyclerViewDinner.setAdapter(mRecyclerAdapterDinner);

        //Attach Linear Layout with mRecyclerViewExercise
        mRecyclerAdapterExcercise = new RecyclerAdapter(myListExcercise, this::OnRemoveClick,"5");
        final LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewExercise.setLayoutManager(layoutManager3);
        mRecyclerViewExercise.setAdapter(mRecyclerAdapterExcercise);

        //Attach Linear Layout with mRecyclerViewExercise
        mRecyclerAdapterSnacks = new RecyclerAdapter(myListSnacks, this::OnRemoveClick,"4");
        final LinearLayoutManager layoutManager4= new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewSnacks.setLayoutManager(layoutManager4);
        mRecyclerViewSnacks.setAdapter(mRecyclerAdapterSnacks);


        btnAdd = (TextView)view. findViewById(R.id.btnAdd);
        btnAddItem = (TextView)view. findViewById(R.id.btnAddItemBreakfast);
        btnAddItemLunch = (TextView)view. findViewById(R.id.btnAddItemLunch);
        btnAddItemDinner = (TextView)view. findViewById(R.id.btnAddItemDinner);
        btnAddItemSnacks = (TextView)view. findViewById(R.id.btnAddItemSnacks);
        btnAddItemExcercise = (TextView)view. findViewById(R.id.btnAddItemExcercise);

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AddGoal();
            }
        });
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            //Here i am sending the category id from here , like if it is 1 in the parameter
            //Opening the view for adding calories for Breakfast and rest
            @Override
            public void onClick(View v)
            {
                AddProduct("1");
            }
        });
        btnAddItemLunch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AddProduct("2");
            }
        });
        btnAddItemDinner.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AddProduct("3");
            }
        });btnAddItemSnacks.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AddProduct("4");
            }
        });
        btnAddItemExcercise.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AddProduct("5");
            }
        });

        return view;

    }

    //Remove Calories category based
    @Override
    public void OnRemoveClick(int index,ArrayList<RecyclerViewData> myList,String value)
    {
        if(value.equals("1"))
        {
            //Removes food/calories for Breakfast
            totalFood=totalFood-Integer.valueOf(myList.get(index).getDescription());
            textViewFood.setText(String.valueOf(totalFood));
            textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
            myList.remove(index);

            mRecyclerAdapter.notifyData(myList);

        } else if(value.equals("2"))
        {
            //Removes food/Calories for lunch
            totalFood=totalFood-Integer.valueOf(myList.get(index).getDescription());
            textViewFood.setText(String.valueOf(totalFood));
            textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
            myList.remove(index);

            mRecyclerAdapterLunch.notifyData(myList);
        }
        else if(value.equals("3"))
        {
            //Removes food/calories for Dinner
            totalFood=totalFood-Integer.valueOf(myList.get(index).getDescription());
            textViewFood.setText(String.valueOf(totalFood));
            textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
            myList.remove(index);

            mRecyclerAdapterDinner.notifyData(myList);
        }

        else if(value.equals("4"))
        {
            //Removes food/calories for Snacks
            Toast.makeText(getActivity(), ""+String.valueOf(totalFood), Toast.LENGTH_SHORT).show();
            totalFood=totalFood-Integer.valueOf(myList.get(index).getDescription());
            textViewFood.setText(String.valueOf(totalFood));
            textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
            myList.remove(index);
            mRecyclerAdapterSnacks.notifyData(myList);
        }
        else if(value.equals("5"))
        {
            //Removes workout/calories for Exercise
            totalExcercise=totalExcercise-Integer.valueOf(myList.get(index).getDescription());

            textViewExcercise.setText(String.valueOf(totalExcercise));
            textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
            myList.remove(index);
            mRecyclerAdapterExcercise.notifyData(myList);
        }


    }

    //Add Total Calories for each Categories
    public void AddProduct(String btn)
    {
        builder = new Dialog(getActivity());
        builder.setContentView(R.layout.add_food);
        builder.setCancelable(false);
        builder.setCanceledOnTouchOutside(false);
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        EditText etTitle = builder.findViewById(R.id.etTitle);
        etTitle.setHint("Add Your Food");
        EditText etDescription=builder.findViewById(R.id.etDescription);
        Button tvDone = builder.findViewById(R.id.btnAddItem);
        ImageView imageView=builder.findViewById(R.id.close);

        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                builder.dismiss();
            }

        });


        tvDone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                title = etTitle.getText().toString();
                description = etDescription.getText().toString();

                if (title.matches(""))
                {
                    Toast.makeText(getActivity(), "You did not enter a Title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (description.matches(""))
                {
                    Toast.makeText(getActivity(), "You did not enter a description", Toast.LENGTH_SHORT).show();
                    return;
                }

                RecyclerViewData mLog = new RecyclerViewData();
                mLog.setTitle(title);
                mLog.setDescription(description);

                if(btn.equalsIgnoreCase("1"))
                {
                    //Add calories/food for Breakfast
                    totalFood=Integer.valueOf(description)+totalFood;
                    textViewFood.setText(String.valueOf(totalFood));
                    textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
                    myList.add(mLog);
                    mRecyclerAdapter.notifyData(myList);
                    etTitle.setText("");
                    etDescription.setText("");
                }
                else  if(btn.equalsIgnoreCase("2"))
                {
                    //Add calories/food for Lunch
                    totalFood=Integer.valueOf(description)+totalFood;
                    textViewFood.setText(String.valueOf(totalFood));
                    textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
                    myListLunch.add(mLog);
                    mRecyclerAdapterLunch.notifyData(myListLunch);
                    etTitle.setText("");
                    etDescription.setText("");
                }
                else  if(btn.equalsIgnoreCase("3"))
                {
                    //Add calories/food for Dinner
                    totalFood=Integer.valueOf(description)+totalFood;
                    textViewFood.setText(String.valueOf(totalFood));
                    textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
                    myListDinner.add(mLog);
                    mRecyclerAdapterDinner.notifyData(myListDinner);
                    etTitle.setText("");
                    etDescription.setText("");
                }
                else  if(btn.equalsIgnoreCase("4"))
                {
                    //Add calories/food for Snack
                    totalFood=Integer.valueOf(description)+totalFood;
                    textViewFood.setText(String.valueOf(totalFood));
                    textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
                    myListSnacks.add(mLog);
                    mRecyclerAdapterSnacks.notifyData(myListSnacks);
                    etTitle.setText("");
                    etDescription.setText("");
                }
                else  if(btn.equalsIgnoreCase("5"))
                {
                    //Add calories/Workout for Exercise
                    totalExcercise=Integer.valueOf(description)+totalExcercise;
                    textViewExcercise.setText(String.valueOf(totalExcercise));

                    textViewFood.setText(String.valueOf(totalFood));
                    textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
                    myListExcercise.add(mLog);
                    mRecyclerAdapterExcercise.notifyData(myListExcercise);
                    etTitle.setText("");
                    etDescription.setText("");
                }

                //Refreshes Recyclerviews with the updated Data
                mRecyclerAdapter.notifyDataSetChanged();
                mRecyclerAdapterLunch.notifyDataSetChanged();
                mRecyclerAdapterDinner.notifyDataSetChanged();
                mRecyclerAdapterSnacks.notifyDataSetChanged();
                mRecyclerAdapterExcercise.notifyDataSetChanged();

                builder.dismiss();

            }
        });
        builder.show();
    }
    //Adds Calories Goal here
    public void AddGoal()
    {
        //Opens alert dialog/box to enter
        builder = new Dialog(getActivity());
        builder.setContentView(R.layout.add_goal);
        builder.setCancelable(false);
        builder.setCanceledOnTouchOutside(false);
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Button tvDone = builder.findViewById(R.id.btnAddItem);

        EditText etTitle = builder.findViewById(R.id.etGoal);
        etTitle.setHint("Goal");
        ImageView imageView=builder.findViewById(R.id.close);

        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                builder.dismiss();
            }
        });

        //After adding calories goal, adding button to submit
        tvDone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {


                title = etTitle.getText().toString();
                if (title.matches(""))
                {
                    Toast.makeText(getActivity(), "You did not enter your Goal", Toast.LENGTH_SHORT).show();
                    return;
                }

                //set Goal in textview
                btnAdd.setText(title);
                totalGoal=Integer.valueOf(title);
                textViewGoal.setText(String.valueOf(title));
                //Calculate Remaining Calories
                textViewRemaining.setText(String.valueOf(totalGoal-(totalFood+totalExcercise)));
                //Remove alert Dialog
                builder.dismiss();

            }
        });
        builder.show();
    }

}

