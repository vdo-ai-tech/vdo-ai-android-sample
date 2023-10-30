package vdo.ai.sample.java.ironsource;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import vdo.ai.android.core.listeners.VdoRewardedListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.android.ironsource.VdoIronSourceRewardedVideo;
import vdo.ai.sample.java.ironsource.application.MyApplication;
import vdo.ai.sample.java.ironsource.databinding.ActivityRewardedVideoBinding;

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


        VdoIronSourceRewardedVideo rewardedVideoAd = new VdoIronSourceRewardedVideo.VdoISRewardedVideoBuilder()
                .withContext(this)
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTagName("in-app-sample-rw-Z1")
                .setAllowRefresh(false)
                .setIronSourceParams(MyApplication.IRON_SOURCE_APP_KEY,"DefaultRewardedVideo")
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