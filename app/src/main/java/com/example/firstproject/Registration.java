package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    private Button registerButton;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView toLogin;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        registerButton = findViewById(R.id.registerButton);
        inputEmail = findViewById(R.id.registrationInputEmail);
        inputPassword = findViewById(R.id.registrationInputPassword);

        toLogin = findViewById(R.id.toLogin);


        //
        registerButton.setOnClickListener(this);
        toLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == registerButton) {
            registerUser();
        }

        if (view == toLogin) {
            Toast.makeText(this, "TO LOGIN", Toast.LENGTH_SHORT).show();
            changeActivityToLogin();
        }
    }

    private void hideKeyboard(){
        inputPassword.onEditorAction(EditorInfo.IME_ACTION_DONE);
        inputEmail.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

    private void openFillInfoActivity(){
        Intent intent = new Intent(this, FillInformation.class);
        startActivity(intent);
    }

    private void changeActivityToLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    private void registerUser() {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        hideKeyboard();
        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
//                            inputEmail.setText("");
//                            inputPassword.setText("");
                            progressDialog.dismiss();
                            progressDialog.cancel();
                            openFillInfoActivity();

                        } else {
                            Toast.makeText(Registration.this,
                                    "Failed, please try again...", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            progressDialog.cancel();
                        }
                    }
                });
    }
}
