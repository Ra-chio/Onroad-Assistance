package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    EditText  t2,t4;
    Button create;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
     //   t1 = (EditText) findViewById(R.id.editText);
        t2 = (EditText) findViewById(R.id.editText1);
     //  t3 = (EditText) findViewById(R.id.editText2);
        t4 = (EditText) findViewById(R.id.editText3);
      //  t5 = (EditText) findViewById(R.id.editText4);
        create = (Button) findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }
    private void Register() {
      //  String name = t1.getText().toString();
        String email = t2.getText().toString();
       // String number = t3.getText().toString();
        String password1 = t4.getText().toString();
       // String password2 = t5.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!password1.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(signin.this, "Registered successfully!!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signin.this,user_login.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                            Toast.makeText(signin.this,"Registration Srror!!",Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                t4.setError("Em[pty fields are not allowed");
            }
        }else if(email.isEmpty()){
           t2.setError("Empty fields are not allowed");
        }else{
            t2.setError("Please enter correct email");
        }
    }
}
