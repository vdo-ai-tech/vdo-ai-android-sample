package vdo.ai.sample.java.core;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import vdo.ai.android.core.VdoRewardedVideoAd;
import vdo.ai.android.core.listeners.VdoRewardedListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.sample.java.core.databinding.ActivityRewardedVideoBinding;

public class RewardedVideoActivity extends AppCompatActivity {

    ActivityRewardedVideoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRewardedVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        example();

    }

    public void example() {


        VdoRewardedVideoAd rewardedVideoAd = new VdoRewardedVideoAd.VdoRewardedVideoAdBuilder()
                .withContext(this)
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTagName("in-app-sample-rw-Z1")
                .setAllowRefresh(false)
                .setListener(new VdoRewardedListener() {

                    @Override
                    public void onUserEarnedReward(int i, @NonNull String s) {
                        binding.title.setText("Reward Amount " + i + ", type: " + s);
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                    }

                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdImpression() {

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdFailedToLoad(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {

                    }

                    @Override
                    public void onAdClicked() {

                    }
                }).build();
    }
}