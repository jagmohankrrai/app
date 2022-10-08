package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
    EditText memail,mpassword;
    Button mloginbutton;
    String id,pass;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memail =findViewById(R.id.Email);
        mpassword=findViewById(R.id.Password);
        mloginbutton=findViewById(R.id.login);

        mloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=memail.getText().toString().trim();
                String password=mpassword.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                Log.i("id",password);
                if (email.matches(emailPattern))
                {
                }
                else
                {

                    memail.setError("Invalid email address");
                    return;
                }
                if(TextUtils.isEmpty(email))
                {
                    memail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    mpassword.setError("password is required");
                    return;
                }
                if(password.length()<8)
                {
                    mpassword.setError("password should be >=8 char ");
                    Log.i("id",password);
                    return;
                }
                postDataUsingVolley(memail,mpassword);
            }
        });

    }
    public interface VolleyCallback {
        void onSuccessResponse(JSONObject result);
    }
    private void postDataUsingVolley(EditText memail, EditText mpassword ) {
        // url to post our data
        String url = "https://mockapi.io/clone/634034b5d1fcddf69cb3ddb5";
        JSONObject data= null;
        try {
            data  = new JSONObject();
            // get employee name and salary
            id = data.getString(String.valueOf(memail));
            pass = data.getString(String.valueOf(mpassword));
            data.put("email","id");
            data.put("password","pass");
        }catch (JSONException e){
            e.printStackTrace();
        }
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
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
                Toast.makeText(MainActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
        }



}

