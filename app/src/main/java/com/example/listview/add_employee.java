package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class add_employee extends AppCompatActivity {
    EditText email,password,mname,mphone,mdep,mdate;
    Button madd;
    String id,pass,name,dep,date,phone;
    RequestQueue queue;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        email =findViewById(R.id.EmailAddress);
        password=findViewById(R.id.TextPassword);
        mname =findViewById(R.id.employee_name);
        mphone=findViewById(R.id.editTextPhone);
        mdate=findViewById(R.id.editTextDate);
        mdep = findViewById(R.id.department);
        madd=findViewById(R.id.add_employee);
        madd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=email.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String name=mname.getText().toString().trim();
                String phone=mphone.getText().toString().trim();
                String date=mdate.getText().toString().trim();
                String dep=mdep.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (id.matches(emailPattern))
                {
                }
                else
                {

                    email.setError("Invalid email address");
                    return;
                }
                if(TextUtils.isEmpty(id))
                {
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    password.setError("password is required");
                    return;
                }
                if(TextUtils.isEmpty(name))
                {
                    mname.setError("name is required");
                    return;
                }
                if(TextUtils.isEmpty(phone))
                {
                    mphone.setError("phone number is required");
                    return;
                }
                if(TextUtils.isEmpty(date))
                {
                    mdate.setError("date is required");
                    return;
                }
                if(TextUtils.isEmpty(dep))
                {
                    mdep.setError("department  is required");
                    return;
                }
                if(pass.length()<8)
                {
                    password.setError("password should be >=8 char ");
                    return;
                }
                if(name.length()<4)
                {
                    mname.setError("name should be >=4 char ");
                    return;
                }
                if(dep.length()<1)
                {
                    mdep.setError("deaprtment should be >=1 char ");
                    return;
                }
                if(phone.length()<10)
                {
                    mphone.setError("password should be =10 char ");
                    return;
                }
                postDataUsingVolley(mname,mphone,email,password,mdep,mdate);

            }
        });

    }
    public void postDataUsingVolley(EditText mname,EditText mphone,EditText email,EditText password,EditText mdep,EditText mdate){
    String url = "https://mockapi.io/clone/634034b5d1fcddf69cb3ddb5";
    JSONObject data=null;
        data  = new JSONObject();

        try {
            id = data.getString(String.valueOf(email));
            pass = data.getString(String.valueOf(password));
            name=data.getString(String.valueOf(mname));
            dep = data.getString(String.valueOf(mdep));
            date = data.getString(String.valueOf(mdate));
            phone=data.getString(String.valueOf(mphone));
            data.put("email","id");
            data.put("password","pass");
            data.put("name","name");
            data.put("department","dep");
            data.put("date","date");
            data.put("phone","phone");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    RequestQueue queue;
        queue = Volley.newRequestQueue(add_employee.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                JSONObject res = response.getJSONObject("response");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, new com.android.volley.Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            // method to handle errors.
            Toast.makeText(add_employee.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
        }
    });
        queue.add(jsonObjectRequest);
}
}