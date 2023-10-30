package vdo.ai.sample.java.ironsource;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import vdo.ai.android.core.listeners.VdoInterstitialListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.android.ironsource.VdoIronSourceInterstitial;
import vdo.ai.sample.java.ironsource.application.MyApplication;
import vdo.ai.sample.java.ironsource.databinding.ActivityInterstitialAdBinding;

public class InterstitialActivity extends AppCompatActivity {

    ActivityInterstitialAdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInterstitialAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        VdoIronSourceInterstitial interstitialAd =  new VdoIronSourceInterstitial.VdoISInterstitialBuilder()
                .withContext(this)
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTagName("in-app-sample-in-Z1")
                .setIronSourceParams(MyApplication.IRON_SOURCE_APP_KEY,"DefaultInterstitial")
                .setAllowRefresh(false)
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