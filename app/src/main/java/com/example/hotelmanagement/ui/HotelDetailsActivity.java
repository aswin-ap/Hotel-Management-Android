package com.example.hotelmanagement.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.hotelmanagement.databinding.ActivityHotelDetailsBinding;

public class HotelDetailsActivity extends AppCompatActivity {
    private ActivityHotelDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setFromIntent();
        initView();
    }

    private void initView() {
        binding.ivBack.setOnClickListener(view -> { finish(); });
    }

    private void setFromIntent() {
        Bundle b = getIntent().getExtras();
        Glide.with(this)
                .load(b.getString("image"))
                .into(binding.ivHotel);
        binding.tvHotelName.setText(b.getString("name"));
        binding.tvLocation.setText(b.getString("location"));
        binding.textHotelRating.setText("Rating: "+b.getString("rating"));
    }
}