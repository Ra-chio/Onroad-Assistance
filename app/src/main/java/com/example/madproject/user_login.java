package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class user_login extends AppCompatActivity {
    Button submit,signin;
    EditText t1,t2;
    TextView t3;
    private FirebaseAuth mAuth;
   // boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        getSupportActionBar().setTitle("Login Page");

        t1 = (EditText) findViewById(R.id.editText2);
        t2 = (EditText) findViewById(R.id.editText3);
        t3 = (TextView) findViewById(R.id.textView2);
        submit = (Button) findViewById(R.id.button);
        signin = (Button) findViewById(R.id.button4);
        mAuth = FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();
               // Intent intent = new Intent(user_login.this, Home.class);
                //   Toast.makeText(this, "feedback sent succefully", Toast.LENGTH_SHORT).show();
                //startActivity(intent);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_login.this, signin.class);
                startActivity(intent);
                finish();
            }
        });
    }
        private void loginuser(){
            //  String name = t1.getText().toString();
            String email = t1.getText().toString();
            // String number = t3.getText().toString();
            String password1 = t2.getText().toString();
            // String password2 = t5.getText().toString();

            if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                if(!password1.isEmpty()){
                   mAuth.signInWithEmailAndPassword(email,password1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                       @Override
                       public void onSuccess(AuthResult authResult) {
                           Toast.makeText(user_login.this,"Login Successfully!!",Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(user_login.this,Home.class));
                           finish();
                       }
                   }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(user_login.this, "Login Failed!!", Toast.LENGTH_SHORT).show();
                       }
                   });
                }else{
                    t2.setError("Empty fields are not allowed");
                }
            }else if(email.isEmpty()){
                t1.setError("Empty fields are not allowed");
            }else{
                t1.setError("Please enter correct email");
            }
        }


}
