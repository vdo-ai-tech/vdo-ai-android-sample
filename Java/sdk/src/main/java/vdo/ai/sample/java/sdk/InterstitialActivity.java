package vdo.ai.sample.java.sdk;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import vdo.ai.android.core.listeners.VdoInterstitialListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.android.sdk.VdoAIInterstitial;
import vdo.ai.sample.java.sdk.application.MyApplication;
import vdo.ai.sample.java.sdk.databinding.ActivityInterstitialAdBinding;

public class InterstitialActivity extends AppCompatActivity {

    ActivityInterstitialAdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInterstitialAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        VdoAIInterstitial interstitialAd =  new VdoAIInterstitial.VdoAIInterstitialBuilder()
                .withContext(this)
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTagName("in-app-sample-in-Z1")
                .setAllowRefresh(false)
                .setApplovinAdUnitId("da2399776013e5b9")
                .setIronSourceParams(MyApplication.IRON_SOURCE_APP_KEY,"DefaultInterstitial")
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