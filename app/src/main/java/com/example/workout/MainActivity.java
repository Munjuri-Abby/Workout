package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnMale = (Button) findViewById(R.id.btnmale); //male button
        Button btnFemale = (Button) findViewById(R.id.btnfemale); //female button
        //Button btnCalculate = (Button) findViewById(R.id.btncalculate);

        btnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent male = new Intent(MainActivity.this, MaleActivity.class);

                MainActivity.this.startActivity(male);
                //startActivity(male);//takes user to male activity

            }
        });


        btnFemale.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent female = new Intent(MainActivity.this,FemaleActivity.class);

                MainActivity.this.startActivity(female);
            }
        });
    }
}