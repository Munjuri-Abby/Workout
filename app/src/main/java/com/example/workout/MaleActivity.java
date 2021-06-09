package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MaleActivity extends AppCompatActivity
{

    EditText Weight;
    EditText Height;
    EditText Age;
    Button btncalulate;
    Button malenavigation;
    Double bmi;

    SQLiteDatabase sqLiteDatabase;

    public static TextView bmi_result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);

        Weight = findViewById(R.id.textWeight);
        Height = findViewById(R.id.editTextHeight);
        Age = findViewById(R.id.editTextAge);
        btncalulate = findViewById(R.id.btncalculate); //Button to calculate BMI
        malenavigation= (Button) findViewById(R.id.malenavigation);
        bmi_result = (TextView) findViewById(R.id.bmi_result);
        sqLiteDatabase = openOrCreateDatabase("bmi", MODE_PRIVATE, null);//open and creating database
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bmi_table(bmi_values VARCHAR, Insertion_date VARCHAR);");


        btncalulate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bmi = calculateBmi();
                String bmiString = String.valueOf(bmi);
                ArrayList bmiList = new ArrayList();
                sqLiteDatabase.execSQL("INSERT INTO bmi_table VALUES (" + bmiString + ", CURRENT_TIMESTAMP);");
                Cursor resultSet = sqLiteDatabase.rawQuery("Select * from bmi_table", null);
                resultSet.moveToFirst();
                //makeCalculations();

            }
        });

        malenavigation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent male_navigation = new Intent(MaleActivity.this, Male_navigation.class);
                male_navigation.putExtra("bmi", bmi.toString());
                MaleActivity.this.startActivity(male_navigation);


                //Trial



                //Bundle bundle = new Bundle();

                //bundle.putString("result", String.valueOf(result));

                //activity_male_home.putExtras(bundle);


                //startActivity(male);//takes user to male activity

            }
        });
    }


    public double calculateBmi()
    {
        double n1 = Double.valueOf(Weight.getText().toString());
        double n2 = Double.valueOf(Height.getText().toString());
        double n3 = Double.valueOf(Age.getText().toString());

        double result;
        result = 10*n1 + 6.25*n2 - 5*n3 + 5; //Mifflin-St Jeor Equation for men
        bmi_result.setText("Bmi is: " + result);

        return result;
    }



    /*public void makeCalculations()
    {
        double n1 = Double.valueOf(Weight.getText().toString());
        double n2 = Double.valueOf(Height.getText().toString());
        double n3 = Double.valueOf(Age.getText().toString());

        double result;
        result = 10*n1 + 6.25*n2 - 5*n3 + 5; //Mifflin-St Jeor Equation for men
        bmi_result.setText("Bmi is: " + result);



    }*/


}