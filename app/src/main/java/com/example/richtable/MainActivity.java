package com.example.richtable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Client");
    // DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://richtable-e4105-default-rtdb.firebaseio.com/");
    Button login, register;
    EditText username, password;
    String UsernameField, PasswordField;
    String FirePass;
    TextView verify;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.edit1);
        password = findViewById(R.id.edit2);
        login = findViewById(R.id.login);
        register = findViewById(R.id. register);
        verify = findViewById(R.id.check);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Register.class);
                //Toast.makeText(MainActivity.this, "User dcfb exists ", Toast.LENGTH_LONG).show();
                startActivity(in);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsernameField = username.getText().toString();
                PasswordField = password.getText().toString();
                Query check = FirebaseDatabase.getInstance().getReference("Client").orderByChild("username").equalTo(UsernameField);
                check.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            username.setError(null);
                            //username.setErrorEnabled(false);
                            FirePass = dataSnapshot.child(UsernameField).child("password").getValue(String.class);
                            if (FirePass.equals(PasswordField)) {
                                password.setError(null);
                                verify.setText(FirePass);
                                Toast.makeText(MainActivity.this, "Successfully Login", Toast.LENGTH_LONG).show();

                                     Intent intent = new Intent(MainActivity.this,Dashboard.class);
                                     startActivity(intent);
                                finish();

                            } else {
                                Toast.makeText(MainActivity.this, "Password do not match ", Toast.LENGTH_LONG).show();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "User do not exists ", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
//                 if(UsernameField.length()== 0 || PasswordField.length()==0){
//                     Toast.makeText(MainActivity.this, "Please enter Fields", Toast.LENGTH_LONG).show();
//                 }
//                 else if(!(UsernameField.length()== 0 || PasswordField.length()==0)) {
//
//                     databaseReference.child("Client").addListenerForSingleValueEvent(new ValueEventListener() {
//                         @Override
//                         public void onDataChange(@NonNull DataSnapshot snapshot) {
//                             if(snapshot.hasChild(UsernameField)) {
//                                 verify.setText(UsernameField);
//                                 FirePass = snapshot.child("Client").child("password").getValue(String.class);
//                                 verify.setText(FirePass);
//
//
//                                 if(FirePass.equals(PasswordField)){
//                                     Toast.makeText(MainActivity.this, "Successfully Login", Toast.LENGTH_LONG).show();
//                                     finish();
//                                     Intent intent = new Intent(MainActivity.this,Dashboard.class);
//                                     startActivity(intent);
//
//
//                                 }
//
//
//                 }
//
//                             else if(!(FirePass.equals(PasswordField))){
//                                 Toast.makeText(MainActivity.this, "Invalid Password or email", Toast.LENGTH_LONG).show();
//                             }
//
//                         }
//
//                         @Override
//                         public void onCancelled(@NonNull  DatabaseError databaseError) {
//                             Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
//                         }
//                     });
//                 }
//            }
    }



        });
    }
}