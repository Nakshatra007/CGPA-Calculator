package com.example.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public double cgpa = 0.0;
    public int semester = 1;
    String[] semesters = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /*Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.semester_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);*/


        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, semesters);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        // Toast.makeText(getApplicationContext(),semesters[position] , Toast.LENGTH_LONG).show();
       // Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();
        semester = position + 1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void CalculateCGPA(View view)
    {
        double sem1 = 0, sem2=0, sem3=0, sem4=0, sem5=0, sem6=0, sem7=0, sem8=0;
        double den = 1;
        if (semester >= 1) {
            EditText first = findViewById(R.id.sem1);
            sem1 = Double.parseDouble(first.getText().toString());
        }
        if (semester >= 2) {
            EditText second = findViewById(R.id.sem2);
            sem2 = Double.parseDouble(second.getText().toString());
        }
        if (semester >= 3) {
            EditText third = findViewById(R.id.sem3);
            sem3 = Double.parseDouble(third.getText().toString());
        }
        if (semester >= 4) {
            EditText fourth = findViewById(R.id.sem4);
            sem4 = Double.parseDouble(fourth.getText().toString());
        }
        if (semester >= 5) {
            EditText fifth = findViewById(R.id.sem5);
            sem5 = Double.parseDouble(fifth.getText().toString());
        }
        if (semester >= 6) {
            EditText sixth = findViewById(R.id.sem6);
            sem6 = Double.parseDouble(sixth.getText().toString());
        }
        if (semester >= 7) {
            EditText seventh = findViewById(R.id.sem7);
            sem7 = Double.parseDouble(seventh.getText().toString());
        }
        if (semester >= 8) {
            EditText eighth = findViewById(R.id.sem8);
            sem8 = Double.parseDouble(eighth.getText().toString());
        }
        switch (semester) {
            case 1:

                cgpa = sem1;
                break;
            case 2:
                cgpa = (sem1 + sem2) / 2.0;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:

                break;
        }
        den = (20 * 2.0) + 22 * (semester - 2);
        if (semester > 2) {
            double num = (sem1 + sem2) * 20 + (sem3 + sem4 + sem5 + sem6 + sem7 + sem8) * 22;
            cgpa = num / den;
        }
        TextView scoreView = (TextView) findViewById(R.id.result);
        scoreView.setText(String.valueOf(cgpa));

    }

}