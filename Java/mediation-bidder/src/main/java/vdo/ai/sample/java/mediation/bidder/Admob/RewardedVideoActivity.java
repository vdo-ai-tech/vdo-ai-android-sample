package vdo.ai.sample.java.mediation.bidder.Admob;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import vdo.ai.sample.java.mediation.bidder.databinding.ActivityRewardedVideoBinding;

public class RewardedVideoActivity extends AppCompatActivity {

    ActivityRewardedVideoBinding binding;
    private RewardedAd mAdManagerAdView;
    private String mAdUnit = "ca-app-pub-5764867881717582/4052729061";
    private String TAG = RewardedVideoActivity.class.getSimpleName();
    private final RewardedAdLoadCallback callback =new RewardedAdLoadCallback() {
        @Override
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);

        }

        @Override
        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
            super.onAdLoaded(rewardedAd);
            mAdManagerAdView =rewardedAd;
            showRewardedAd();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRewardedVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        example();

    }

    private void example() {
        AdRequest adRequest = new AdRequest.Builder().build();
        if (mAdManagerAdView == null) {
            RewardedAd.load(this, mAdUnit, adRequest, callback);
        } else {
            showRewardedAd();
        }

    }

    private void showRewardedAd() {
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
        mAdManagerAdView.show(this, rewardItem -> Log.d(TAG, "User earned the reward. Amount: "+rewardItem.getAmount()+"\nType"+rewardItem.getType()));

    }

}