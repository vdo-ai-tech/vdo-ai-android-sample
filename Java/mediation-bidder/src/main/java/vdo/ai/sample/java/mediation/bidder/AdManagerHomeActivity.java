package vdo.ai.sample.java.mediation.bidder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import vdo.ai.sample.java.mediation.bidder.AdManager.BannerActivity;
import vdo.ai.sample.java.mediation.bidder.AdManager.InterstitialActivity;
import vdo.ai.sample.java.mediation.bidder.AdManager.RewardedInterstitialActivity;
import vdo.ai.sample.java.mediation.bidder.AdManager.RewardedVideoActivity;
import vdo.ai.sample.java.mediation.bidder.databinding.ActivityHomeBinding;

public class AdManagerHomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.banner_ad) {
            startActivity(new Intent(this, BannerActivity.class));
        } else if (itemId == R.id.interstitialAd) {
            startActivity(new Intent(this, InterstitialActivity.class));
        } else if (itemId == R.id.rewarded_videoAd) {
            startActivity(new Intent(this, RewardedVideoActivity.class));
        } else if (itemId == R.id.rewarded_interstitialAd) {
            startActivity(new Intent(this, RewardedInterstitialActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}