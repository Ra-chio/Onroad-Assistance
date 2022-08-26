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

public class admin extends AppCompatActivity {
    Button add,user,mechanic,msgUser,msgMechanic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setTitle("Admin Page");
        add = (Button)findViewById(R.id.button1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this,Mechanic.class));
            }
        });
        user =(Button)findViewById(R.id.button);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             startActivity(new Intent(admin.this,ShowUser.class));
            }
        });
        mechanic = (Button)findViewById(R.id.button2);
        mechanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this,ShowMechanic.class));

            }
        });

        msgUser = (Button)findViewById(R.id.button3);
        msgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this,MsgUser.class));
            }
        });

        msgMechanic = (Button)findViewById(R.id.button4);
        msgMechanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this,MsgMechanic.class));
            }
        });
    }


}
