package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button userlogin, adminlogin;
    Animation top,bottom;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("");

        top = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image = findViewById(R.id.imageView);

        image.setAnimation(top);

        userlogin = (Button)findViewById(R.id.button2);
        adminlogin = (Button)findViewById(R.id.button3);
        userlogin.setOnClickListener(this);
        adminlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == userlogin.getId()) {
            Intent intent = new Intent(MainActivity.this, user_login.class);
            startActivity(intent);
        }
        if (v.getId() == adminlogin.getId()) {
            Intent intent= new Intent(MainActivity.this, admin_login.class);
            startActivity(intent);
        }

    }
}
