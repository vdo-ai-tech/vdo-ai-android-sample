package vdo.ai.sample.java.mediation.bidder.AdManager;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import vdo.ai.sample.java.mediation.bidder.databinding.ActivityInterstitialAdBinding;

public class InterstitialActivity extends AppCompatActivity {

    ActivityInterstitialAdBinding binding;
    private AdManagerInterstitialAd mAdManagerAdView;
    private String mAdUnit ="/22100121508/montest/net_one97_paytm/ellipsis_dfp_in_app_paytm_secure_in_ellipsis_pre_1";
    private String TAG = InterstitialActivity.class.getSimpleName();
    private final AdManagerAdRequest request = new AdManagerAdRequest.Builder().build();
    private final AdManagerInterstitialAdLoadCallback callback =new AdManagerInterstitialAdLoadCallback() {
        @Override
        public void onAdLoaded(@NonNull AdManagerInterstitialAd adManagerInterstitialAd) {
            super.onAdLoaded(adManagerInterstitialAd);
            mAdManagerAdView = adManagerInterstitialAd;
            mAdManagerAdView.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                }

                @Override
                public void onAdImpression() {
                    super.onAdImpression();
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent();
                }

            });
            if (mAdManagerAdView != null) {
                mAdManagerAdView.show(InterstitialActivity.this);
            }
        }

        @Override
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            Log.d(TAG,"Gam Ad was failed");
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInterstitialAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        example();
    }
    private void example() {
        AdManagerInterstitialAd.load(this, mAdUnit, request, callback );
    }
}