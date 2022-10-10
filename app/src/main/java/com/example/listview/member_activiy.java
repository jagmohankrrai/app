package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class member_activiy extends AppCompatActivity {
    private Button button;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_activiy);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView edtText = (TextView) findViewById(R.id.name_mem);
        edtText.setText(name);
        String token = intent.getStringExtra("token");
        button= (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(member_activiy.this, newTask.class);
                intent.putExtra("token", token);
                startActivity(intent);
            }
        });
    }
}