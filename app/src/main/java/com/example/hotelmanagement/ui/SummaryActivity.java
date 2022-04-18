package com.example.hotelmanagement.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotelmanagement.databinding.ActivitySummaryBinding;

public class SummaryActivity extends AppCompatActivity {

    String checkIn, checkOut, total;
    int adult, children, room;
    ActivitySummaryBinding binding;
    String newline = System.getProperty("line.separator");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySummaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getFromIntent();
        initView();
    }

    private void initView() {
        StringBuilder builder = new StringBuilder();
        builder.append("Adults  " + "X" + adult+newline);
        builder.append("Children  " + "X" + children);
        binding.tvCheckIn.setText(checkIn);
        binding.tvCheckOut.setText(checkOut);
        binding.tvRooms.setText(String.valueOf(room));
        binding.tvGuests.setText(builder);
        binding.tvTotal.setText(String.valueOf(total) + "£");
        binding.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SummaryActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getFromIntent() {
        Bundle bundle = getIntent().getExtras();
        checkIn = bundle.getString("checkIn");
        checkOut = bundle.getString("checkOut");
        adult = bundle.getInt("adult");
        children = bundle.getInt("children");
        room = bundle.getInt("rooms");
        total = bundle.getString("total");
    }
}