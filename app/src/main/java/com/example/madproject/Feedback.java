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

public class Feedback extends AppCompatActivity implements View.OnClickListener {
    EditText t1,t2,t3;
    Button b;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Feedback");
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setTitle("Feedback Page");

        t1 = (EditText)findViewById(R.id.editText1);
        t2 = (EditText)findViewById(R.id.editText2);
        t3 = (EditText)findViewById(R.id.editText3);
        b = (Button)findViewById(R.id.button);
        b.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=getMenuInflater();
        inflator.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.f1:
                startActivity(new Intent(this,Home.class));
                return true;
            case R.id.f2:
                startActivity(new Intent(this,user.class));
                return true;
            case R.id.f3:
                startActivity(new Intent(this,Feedback.class));
                return true;
            case R.id.f4:
                startActivity(new Intent(this,MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    public void onClick(View v) {
        String name =t1.getText().toString();
        String email =t2.getText().toString();
        String rating =t3.getText().toString();
        HashMap<String , String> userMap = new HashMap<>();
        userMap.put("name", name);
        userMap.put("email", email);
        userMap.put("rating", rating);
        root.push().setValue(userMap);
        isAllFieldsChecked = CheckAllFields();
        if (isAllFieldsChecked) {


            Intent intent = new Intent(Feedback.this, Home.class);
            Toast.makeText(this, "feedback sent succefully", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }
    private boolean CheckAllFields() {
        if (t1.length() == 0) {
            t1.setError("This field is required");
            return false;
        }
        if (t2.length() == 0) {
            t2.setError("Email is required");
            return false;
        }
        if (t3.length() == 0) {
            t3.setError("This field is required");
            return false;
        }
        return true;
    }
}
