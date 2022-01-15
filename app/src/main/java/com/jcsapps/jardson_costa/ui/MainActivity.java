package com.jcsapps.jardson_costa.ui;

import static com.jcsapps.jardson_costa.utils.Constants.KEY_VALUE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jcsapps.jardson_costa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public native String calcular(int value);

    static {
        System.loadLibrary("jardson_costa");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnCalculate.setOnClickListener(v -> {
            String value = binding.editValue.getText().toString();
            if (isEmptyText(value)){
                binding.resultContainer.setVisibility(View.VISIBLE);
                binding.result.setText(getResult(value));
            }else{
                binding.resultContainer.setVisibility(View.GONE);
                binding.result.setText(null);
            }
        });

        binding.btnSend.setOnClickListener(v -> {
           String value = binding.result.getText().toString();
            if (isEmptyText(value))
                nextScreen(value);
        });
    }

    private void nextScreen(String text) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra(KEY_VALUE, text);
        startActivity(intent);
    }

    private boolean isEmptyText(String text) {
        return !text.isEmpty();
    }

    private String getResult(String value){
        return calcular(Integer.parseInt(value));
    }

}