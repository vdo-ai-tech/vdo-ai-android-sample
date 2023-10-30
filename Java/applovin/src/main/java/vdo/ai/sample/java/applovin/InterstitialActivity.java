package vdo.ai.sample.java.applovin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import vdo.ai.android.applovin.VdoApplovinInterstitial;
import vdo.ai.android.core.VdoInterstitialAd;
import vdo.ai.android.core.listeners.VdoInterstitialListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.sample.java.applovin.databinding.ActivityInterstitialAdBinding;

public class InterstitialActivity extends AppCompatActivity {

    ActivityInterstitialAdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInterstitialAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        VdoApplovinInterstitial interstitialAd =  new VdoApplovinInterstitial.VdoApplovinInterstitialBuilder()
                .withContext(this)
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTagName("in-app-sample-in-Z1")
                .setAllowRefresh(false)
                .setApplovinAdUnitId("3783ef4231ce9697")
                .setListener(new VdoInterstitialListener() {
                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdFailedToLoad(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                    }

                    @Override
                    public void onAdImpression() {

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