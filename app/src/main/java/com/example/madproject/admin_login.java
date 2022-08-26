package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class admin_login extends AppCompatActivity implements View.OnClickListener {
    EditText t1, t2;
    Button submit;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getSupportActionBar().setTitle("Admin Login");
        t1 = (EditText) findViewById(R.id.editText2);
        t2 = (EditText) findViewById(R.id.editText3);
        submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        isAllFieldsChecked = CheckAllFields();
        if (isAllFieldsChecked) {
            Intent intent = new Intent(admin_login.this, admin.class);
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

        return true;

    }
}
