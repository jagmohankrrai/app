package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class admin_screen extends AppCompatActivity {
    Button maddmem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        EditText edtText = (EditText) findViewById(R.id.editTextTextPersonName);
        edtText.setText(name);
        maddmem=findViewById(R.id.button);

        maddmem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin_screen.this, add_employee.class));
            }
        });
    }
}