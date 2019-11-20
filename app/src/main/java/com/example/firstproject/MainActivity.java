package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        changeActivityToRegistration();
    }

    @Override
    public void onClick(View v) {

    }

    private void changeActivityToRegistration(){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }


//    Button sign;
//    Switch changeSign;
//    EditText email;
//    EditText password;
//    boolean signin = true;

//    protected void switchHandler() {
//        changeSign = findViewById(R.id.switch1);
//        sign = findViewById(R.id.button1);
//        changeSign.setChecked(signin);
//        final String signinText = "SIGNIN";
//        final String signupText = "SIGNUP";
//        System.out.println("inside");
//        changeSign.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
//                if (!isChecked) {
//                    sign.setText(signinText);
//                    changeSign.setChecked(false);
//                    signin = true;
////                    Toast.makeText(getApplicationContext(), "Switch !!!", Toast.LENGTH_SHORT).show();
//                } else {
//                    sign.setText(signupText);
//                    changeSign.setChecked(true);
//                    signin = false;
////                    Toast.makeText(getApplicationContext(), "Switch !!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
}