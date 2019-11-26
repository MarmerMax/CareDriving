package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyPage extends AppCompatActivity implements View.OnClickListener {

    private TextView firstName;
    private TextView lastName;
    private TextView age;
    private TextView city;
    private TextView email;
    private Button logoutButton;


    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;

    private String userInformation = null;
    private final String STUDENTS = "students";
    private final String TEACHERS = "teachers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }
        user = firebaseAuth.getCurrentUser();

        firstName = findViewById(R.id.textViewFirstName);
        lastName = findViewById(R.id.textViewLastName);
        age = findViewById(R.id.textViewAge);
        city = findViewById(R.id.textViewCity);
        email = findViewById(R.id.textViewEmail);
        logoutButton = findViewById(R.id.buttonLogout);

        email.setText(user.getEmail());

        if(userInformation == null){
            setUserInformation();
        }

        logoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == logoutButton){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, Login.class));
        }
    }


    private void setUserInformation(){
        //        firstName.setText(user.getUid());//uid
        ref = FirebaseDatabase.getInstance().getReference().child(STUDENTS).child(user.getUid());



//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                try {
//                    userInformation = dataSnapshot.child("firstName").getValue().toString();
//                } catch (Exception e){}
//                finish();
//                if(userInformation == null){
//                    System.out.println("NOT STUDENT");
//                } else {
//                    firstName.setText(dataSnapshot.child("firstName").getValue().toString());
//                    lastName.setText(dataSnapshot.child("lastName").getValue().toString());
//                    age.setText(dataSnapshot.child("age").getValue().toString());
//                    city.setText(dataSnapshot.child("city").getValue().toString());
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {}
//        });
//
//        if(userInformation == null){
//            ref = FirebaseDatabase.getInstance().getReference().child(TEACHERS).child(user.getUid());
//            ref.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    try {
//                        userInformation = dataSnapshot.child("firstName").getValue().toString();
//                    } catch (Exception e){}
//                    if(userInformation == null){
//                        System.out.println("NOT TEACHER");
//                    } else {
//                        firstName.setText(dataSnapshot.child("firstName").getValue().toString());
//                        lastName.setText(dataSnapshot.child("lastName").getValue().toString());
//                        age.setText(dataSnapshot.child("age").getValue().toString());
//                        city.setText(dataSnapshot.child("city").getValue().toString());
//                    }
//                }
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {}
//            });
//        }
//        Toast.makeText(this, "NAME " + userInformation, Toast.LENGTH_SHORT).show();
    }
}
