package com.example.androidgroup;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidgroup.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ActivityForgotPasswordBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


    }
}