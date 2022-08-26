package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class user extends AppCompatActivity implements View.OnClickListener {
    EditText t1, t2, t3, t4, t5;
    Button reg,map;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Users");
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        getSupportActionBar().setTitle("Service Page");
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
        map=(Button)findViewById(R.id.button6);


        t1 = (EditText) findViewById(R.id.editText6);
        t2 = (EditText) findViewById(R.id.editText7);
        t3 = (EditText) findViewById(R.id.editText);
        t4 = (EditText) findViewById(R.id.editText4);
        t5 = (EditText) findViewById(R.id.editText5);
        reg = (Button) findViewById(R.id.button);
        reg.setOnClickListener(this);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                   if(getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                       //GET THE LOCATION HERE
                       fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                           @Override
                           public void onSuccess(Location location) {
                               if(location != null){
                                   Double lat = location.getLatitude();
                                   Double longt = location.getLongitude();
                                   t5.setText(lat+" , "+longt);
                               }
                           }
                       });
                   }else{
                       requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
                   }
               }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.f1:
                startActivity(new Intent(this, Home.class));
                return true;
            case R.id.f2:
                startActivity(new Intent(this, user.class));
                return true;
            case R.id.f3:
                startActivity(new Intent(this, Feedback.class));
                return true;
            case R.id.f4:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onClick(View v) {
        String name =t1.getText().toString();
        String phone =t2.getText().toString();
        String problem =t3.getText().toString();
        String landmark =t4.getText().toString();
        String location=t5.getText().toString();

        HashMap<String , String> userMap = new HashMap<>();
        userMap.put("name", name);
        userMap.put("phone" , phone);
        userMap.put("problem" , problem);
        userMap.put("landmark", landmark);
        userMap.put("location" , location);

        root.push().setValue(userMap);

        isAllFieldsChecked = CheckAllFields();
        if (isAllFieldsChecked) {


            Intent intent = new Intent(user.this, Home.class);
            Toast.makeText(this, "Your problem got registered successfully", Toast.LENGTH_SHORT).show();
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
            t4.setError("This field is required");
            return false;
        }
        if (t5.length() == 0) {
            t5.setError("This field is required");
            return false;
        }
        return true;
    }
}