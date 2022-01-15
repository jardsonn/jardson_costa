package com.jcsapps.jardson_costa.ui;

import static com.jcsapps.jardson_costa.utils.Constants.KEY_VALUE;

import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jcsapps.jardson_costa.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;
    private float x, y;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String value = bundle.getString(KEY_VALUE);
            setValue(value);

        }

    }

    private void setValue(String value){
        binding.getRoot().setTextResult(value);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            x = event.getX();
            y = event.getY();
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE){
            float dx = event.getX() - x;
            float dy = event.getY() - y;

            binding.getRoot().setX(binding.getRoot().getX() + dx);
            binding.getRoot().setY(binding.getRoot().getY() + dy);
            x = event.getX();
            y = event.getY();
        }

        return super.onTouchEvent(event);
    }
}
