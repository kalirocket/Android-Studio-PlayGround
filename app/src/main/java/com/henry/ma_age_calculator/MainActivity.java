package com.henry.ma_age_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtProgram;
    EditText edtAdmissionYear;
    EditText edtDOB;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDOB = findViewById(R.id.btnDOB);
        Button btnAdmissionYear = findViewById(R.id.btnAdmissionYear);
        EditText edtDOB = findViewById(R.id.edtDOB);
        EditText edtAdmissionYear = findViewById(R.id.edtAdmissionYear);

        btnDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalenderDialogue(edtDOB);
            }
        });

        btnAdmissionYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalenderDialogue(edtAdmissionYear);
            }
        });
    }

    private void openCalenderDialogue(EditText edt){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                edt.setText(String.valueOf(year));
            }
        }, year, month, day);
        dialog.show();
    }

    public void btCalc(View view) {
        edtName = (EditText) findViewById(R.id.edtName);
        edtProgram = (EditText) findViewById(R.id.edtProgram);
        edtAdmissionYear= (EditText) findViewById(R.id.edtAdmissionYear);
        edtDOB = (EditText) findViewById(R.id.edtDOB);
        tvResults = (TextView) findViewById(R.id.tvResults);
        String name = edtName.getText().toString();
        String program = edtProgram.getText().toString();
        int admission_year = Integer.parseInt(edtAdmissionYear.getText().toString());
        int dob = Integer.parseInt(edtDOB.getText().toString());

        Calendar cal = Calendar.getInstance();
        int current_year = cal.get(Calendar.YEAR);

        int age = current_year - dob;

        String output = "Your name is " + name + ". You're " + age + " years old! " +
                "You were admitted on " +  admission_year + " to offer " + program;

        tvResults.setText(output);

    }
}

