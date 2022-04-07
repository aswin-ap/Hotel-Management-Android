package com.example.hotelmanagement.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hotelmanagement.BaseActivity;
import com.example.hotelmanagement.R;
import com.example.hotelmanagement.data.prefrence.SessionManager;
import com.example.hotelmanagement.databinding.ActivityLoginBinding;
import com.example.hotelmanagement.ui.HomeActivity;
import com.example.hotelmanagement.utils.Validation;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding binding;
    private long mLastClickTime = 0;
   /* private final FirebaseFirestore fb = getFireStoreInstance();*/
    private boolean isMatch;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sessionManager = new SessionManager(LoginActivity.this);
        initView();
    }

    private void initView() {
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validation.isValidEmail(binding.txtEmail.getText().toString())) {
                    if (!binding.txtPass.getText().toString().isEmpty()) {
                        showToast(LoginActivity.this,"Login Successfully");
                        // login(binding.txtEmail.getText().toString(), binding.txtPass.getText().toString());
                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(i);
                    } else
                        binding.txtPass.setError("Please enter valid password");
                } else
                    binding.txtEmail.setError("Please enter valid email");
            }
        });
    }
}