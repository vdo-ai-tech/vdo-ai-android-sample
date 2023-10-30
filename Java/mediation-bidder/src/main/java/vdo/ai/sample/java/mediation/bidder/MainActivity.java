package vdo.ai.sample.java.mediation.bidder;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import vdo.ai.sample.java.mediation.bidder.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.adManager.setOnClickListener(v -> {
            startActivity(new Intent(this, AdManagerHomeActivity.class));
        });
        binding.admob.setOnClickListener(v ->{
            startActivity(new Intent(this, AdMobHomeActivity.class));
        });
    }
}