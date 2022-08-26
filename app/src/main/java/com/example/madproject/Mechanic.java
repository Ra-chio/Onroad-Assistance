package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Mechanic extends AppCompatActivity implements View.OnClickListener {
    EditText t1,t2,t3,t4,t5,t6;
    Button add;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Mechanics");
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic);
        getSupportActionBar().setTitle("Mechanic Page");
        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText4);
        t3=(EditText)findViewById(R.id.editText5);
        t4=(EditText)findViewById(R.id.editText7);
        t5=(EditText)findViewById(R.id.editText6);
        t6=(EditText)findViewById(R.id.editText8);
        add=(Button)findViewById(R.id.button);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name =t1.getText().toString();
        String businessname =t2.getText().toString();
        String phone =t3.getText().toString();
        String landmark=t4.getText().toString();
        String state =t5.getText().toString();
        String country =t6.getText().toString();
        HashMap<String , String> userMap = new HashMap<>();
        userMap.put("name", name);
        userMap.put("businessname", businessname);
        userMap.put("phone", phone);
        userMap.put("landmark",landmark);
        userMap.put("state",state);
        userMap.put("country", country);
        root.push().setValue(userMap);

        isAllFieldsChecked = CheckAllFields();
        if (isAllFieldsChecked) {
            Intent intent = new Intent(Mechanic.this, admin.class);
            Toast.makeText(this, "Mechanic added successfully", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

    }
    private boolean CheckAllFields() {
        if (t1.length() == 0) {
            t1.setError("This field is required");
            return false;
        }
        if (t2.length() == 0) {
            t2.setError("This field is required");
            return false;
        }
        if (t3.length() == 0) {
            t3.setError("This field is required");
            return false;
        }
        if (t4.length() == 0) {
            t3.setError("This field is required");
            return false;
        }
        if (t5.length() == 0) {
            t3.setError("This field is required");
            return false;
        }
        return true;
    }
}
