package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FemaleActivity extends AppCompatActivity
{

    EditText Weight;
    EditText Height;
    EditText Age;
    Button btncalulate;
    Button femalehome;
    TextView bmi_result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);

        Weight = findViewById(R.id.textWeight);
        Height = findViewById(R.id.editTextHeight);
        Age = findViewById(R.id.editTextAge);
        btncalulate = findViewById(R.id.btncalculate); //Button to calculate BMI
        femalehome= (Button) findViewById(R.id.femalehome);

        bmi_result = (TextView) findViewById(R.id.bmi_result);
        btncalulate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                makeCalculations();

            }
        });

        /*femalehome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent activity_female_home = new Intent(FemaleActivity.this, Male_home.class);

                FemaleActivity.this.startActivity(activity_female_home);
                //startActivity(male);//takes user to male activity

            }
        });*/
    }

    public void makeCalculations()
    {
        double n1 = Double.valueOf(Weight.getText().toString());
        double n2 = Double.valueOf(Height.getText().toString());
        double n3 = Double.valueOf(Age.getText().toString());

        double result;
        result = 10*n1 + 6.25*n2 - 5*n3 - 161; //Mifflin-St Jeor Equation for Woman
        bmi_result.setText("Bmi is: " + result);
    }

}