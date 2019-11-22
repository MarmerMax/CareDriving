package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


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
}