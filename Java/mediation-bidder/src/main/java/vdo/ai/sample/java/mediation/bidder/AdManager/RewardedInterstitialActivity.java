package vdo.ai.sample.java.mediation.bidder.AdManager;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

import vdo.ai.sample.java.mediation.bidder.databinding.ActivityRewardInterstitialAdBinding;

public class RewardedInterstitialActivity  extends AppCompatActivity {

    ActivityRewardInterstitialAdBinding binding;
    private RewardedInterstitialAd mAdManagerAdView;
    private String mAdUnit ="/22100121508/montest/net_one97_paytm/ellipsis_dfp_in_app_paytm_secure_rw_ellipsis_v2_pre_1";
    private String TAG = RewardedInterstitialActivity.class.getSimpleName();

    private final RewardedInterstitialAdLoadCallback callback =  new RewardedInterstitialAdLoadCallback() {
        @Override
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);

        }

        @Override
        public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
            super.onAdLoaded(rewardedInterstitialAd);
            mAdManagerAdView =rewardedInterstitialAd;
            showRewardedInterstitialAd();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRewardInterstitialAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        example();
    }
    private void example(){
        AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
        if(mAdManagerAdView == null){
            RewardedInterstitialAd.load(this, mAdUnit, adRequest,callback);
        }
        else{
            showRewardedInterstitialAd();
        }

    }

    private void showRewardedInterstitialAd(){
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
