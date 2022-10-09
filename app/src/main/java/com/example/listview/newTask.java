package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.os.Bundle;

public class newTask extends AppCompatActivity {
    Spinner spinner;
    EditText etDate;
    EditText tvtime;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        button1=(Button)findViewById(R.id.save);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(newTask.this, "Task Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        etDate = findViewById(R.id.et_date);
        Calendar calendar= Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        final int[] t1Hour = new int[1];
        final int[] t1Minute = new int[1];

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(
                        newTask.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = month+1;
                        String date =day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        tvtime=(EditText)findViewById(R.id.tv_time);
        tvtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        newTask.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        t1Hour[0] = hourOfDay;
                        t1Minute[0] = minute;
                        Calendar calendar= Calendar.getInstance();
                        calendar.set(0,0,0,hourOfDay,minute);
                        tvtime.setText(DateFormat.format("hh:mm aa",calendar));
                    }
                },12,0,false
                );
                timePickerDialog.updateTime(t1Hour[0], t1Minute[0]);
                timePickerDialog.show();
            }
        });


        spinner=(Spinner) findViewById(R.id.spinner);

        List<String>list=new ArrayList<String>();
        list.add("Break");
        list.add("Meetings");
        list.add("Work");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

    }
}