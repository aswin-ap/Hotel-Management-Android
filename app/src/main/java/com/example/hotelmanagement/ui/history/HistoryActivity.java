package com.example.hotelmanagement.ui.history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hotelmanagement.databinding.ActivityHistoryBinding;

public class HistoryActivity extends AppCompatActivity {
  private ActivityHistoryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}