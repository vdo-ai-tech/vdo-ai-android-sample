package vdo.ai.sample.java.mediation.bidder.Admob;

import android.os.Bundle;

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
    private InterstitialAd mAdManagerAdView;
    private String mAdUnit ="ca-app-pub-5764867881717582/2931219089";
    private String TAG = InterstitialActivity.class.getSimpleName();
    private final InterstitialAdLoadCallback callback =  new InterstitialAdLoadCallback() {
        @Override
        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
            super.onAdLoaded(interstitialAd);
            mAdManagerAdView = interstitialAd;
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
        final AdRequest adRequest =new AdRequest.Builder().build() ;
        InterstitialAd.load(this, mAdUnit, adRequest,callback );
    }
}