package com.example.hotelmanagement.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.hotelmanagement.R;
import com.example.hotelmanagement.databinding.ActivityPaymentBinding;
import com.example.hotelmanagement.utils.NetworkManager;

public class PaymentActivity extends AppCompatActivity {
    private ActivityPaymentBinding binding;
    private String total;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getFromIntent();
        initView();
    }

    private void initView() {

        binding.radioDebit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.cardDebitDetails.setVisibility(View.VISIBLE);
                    binding.buttonConfirmOrder.setVisibility(View.GONE);
                    binding.radioCod.setChecked(false);
                } else {
                    binding.cardDebitDetails.setVisibility(View.GONE);

                }
            }
        });

        binding.radioCod.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.radioDebit.setChecked(false);
                    binding.buttonConfirmOrder.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.buttonDebitPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.etCard.getText().toString().isEmpty()) {
                    if (!binding.etExpiry.getText().toString().isEmpty()) {
                        if (!binding.etCvv.getText().toString().isEmpty()) {
                            type = "card";
                            if (NetworkManager.isNetworkAvailable(PaymentActivity.this)) {
                                //goToOrderSuccess();
                            }else {
                                binding.containerNoInternet.setVisibility(View.VISIBLE);
                            }
                        } else binding.etCvv.setError("Please enter CVV");
                    } else binding.etExpiry.setError("Please enter expiry");
                } else binding.etCard.setError("Please enter card no");
            }
        });

        binding.buttonConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "direct";
                if (NetworkManager.isNetworkAvailable(PaymentActivity.this)) {
                   // goToOrderSuccess();
                } else {
                    binding.containerNoInternet.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void getFromIntent() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
       // binding.tvCash.setText("Amount to be paid : £"+ total);
    }
}