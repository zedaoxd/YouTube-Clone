package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.youtube.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final static String GOOGLE_API_KEY = "AIzaSyBC0PdaLsaVd5lOtlpPkpnLAwsqGB0llJw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialSettings();
    }

    private void initialSettings(){
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}