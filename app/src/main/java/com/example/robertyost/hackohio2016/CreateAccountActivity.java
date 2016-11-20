package com.example.robertyost.hackohio2016;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Date;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText firstNameTxt;
    private EditText lastNameTxt;
    private EditText emailTxt;
    private EditText emailConfirmTxt;
    private EditText passwordTxt;
    private EditText passwordConfirmTxt;
    private RadioGroup genderRadioGroup;
    private EditText dateTxt;
    private EditText majorTxt;
    private Button submitBtn;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstNameTxt = (EditText) findViewById(R.id.firstNameTxt);
        lastNameTxt = (EditText) findViewById(R.id.lastNameTxt);
        emailTxt = (EditText) findViewById(R.id.emailTxt);
        emailConfirmTxt = (EditText) findViewById(R.id.emailConfirmTxt);

        passwordTxt = (EditText) findViewById(R.id.passwordTxt);
        passwordConfirmTxt = (EditText) findViewById(R.id.passwordTxtConfirm);
        genderRadioGroup = (RadioGroup) findViewById(R.id.radioGroupGender);

        dateTxt = (EditText) findViewById(R.id.dateTxt);
        majorTxt = (EditText) findViewById(R.id.majorTxt);
        submitBtn = (Button) findViewById(R.id.signUpBtn);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void onSignUpBtnClick(View view) {
        String firstName, lastName, email, emailConfirm, password, passwordConfirm, gender, major;
        Date birthday;
        RadioButton genderRadioBtn = (RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId());

        firstName = firstNameTxt.getText().toString();
        lastName = lastNameTxt.getText().toString();
        email = emailTxt.getText().toString();
        emailConfirm = emailConfirmTxt.getText().toString();
        password = passwordTxt.getText().toString();
        passwordConfirm = passwordConfirmTxt.getText().toString();
        gender = genderRadioBtn.getText().toString();
        major = majorTxt.getText().toString();

        //TODO: Perform some account validation

        //TODO: Figure out why this isn't working nicely with the emulator
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(CreateAccountActivity.this, "Sorry, your account could not be created at this moment.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
