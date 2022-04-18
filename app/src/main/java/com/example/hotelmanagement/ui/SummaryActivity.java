package com.example.hotelmanagement.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotelmanagement.databinding.ActivitySummaryBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

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
        builder.append("Adults  " + "X" + adult + newline);
        builder.append("Children  " + "X" + children);
        binding.tvCheckIn.setText(checkIn);
        binding.tvCheckOut.setText(checkOut);
        binding.tvRooms.setText(String.valueOf(room));
        binding.tvGuests.setText(builder);
        binding.tvTotal.setText(String.valueOf(total) + "£");
        binding.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmDialog();
            }
        });
        binding.ivBack.setOnClickListener(view -> finish());
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

    public void showConfirmDialog() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SummaryActivity.this);
        builder.setTitle("Booking Confirmation");
        builder.setMessage("Are you sure to confirm the booking?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(SummaryActivity.this, PaymentActivity.class);
                intent.putExtra("checkIn", checkIn);
                intent.putExtra("checkOut", checkOut);
                intent.putExtra("adult", adult);
                intent.putExtra("children", children);
                intent.putExtra("rooms", room);
                intent.putExtra("total", total);
                startActivity(intent);
                dialogInterface.dismiss();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();

    }
}