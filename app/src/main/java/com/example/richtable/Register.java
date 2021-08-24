
package com.example.richtable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
     EditText edit1,edit2,edit3,edit4;
     Button submit;
    String name,email, password,username;
//                                                                               https://richtable-e4105-default-rtdb.firebaseio.com/
   DatabaseReference myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://richtable-e4105-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp firebaseApp = FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_register);
       
        

        //Toast.makeText(Register.this, "User already exists ", Toast.LENGTH_LONG).show();
        edit1 = findViewById(R.id.first);
        edit2 = findViewById(R.id.ln);
        edit3 = findViewById(R.id.pass);
        edit4 = findViewById(R.id.idc);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = edit1.getText().toString();
                email = edit2.getText().toString();
                password = edit3.getText().toString();
                username = edit4.getText().toString();

                if (name.length() == 0 || email.length() == 0 || submit.length() == 0 || username.length()==0) {
                    Toast.makeText(Register.this, "Enter all fields", Toast.LENGTH_LONG).show();

                }
                else
                {
                    myRef.child("Client").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(username)){
                                Toast.makeText(Register.this, "User already exists ", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                myRef.child("Client").child(username).child("name").setValue(name);
                                myRef.child("Client").child(username).child("email").setValue(email);
                                myRef.child("Client").child(username).child("password").setValue(password);
                               myRef.child("Client").child(username).child("username").setValue(username);

                                Toast.makeText(Register.this, "Successfully registered", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }

            }
        });


            }

        }
