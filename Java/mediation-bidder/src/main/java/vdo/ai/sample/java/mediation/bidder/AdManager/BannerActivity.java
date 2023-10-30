package vdo.ai.sample.java.mediation.bidder.AdManager;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;

import vdo.ai.sample.java.mediation.bidder.databinding.ActivityBannerBinding;


public class BannerActivity extends AppCompatActivity {
        private ActivityBannerBinding binding;
        private AdManagerAdView mAdManagerAdView;
        private ViewGroup banner;
        private String mAdUnit ="/22100121508/montest/net_one97_paytm/ellipsis_dfp_in_app_paytm_secure_b_ellipsis_pre_1";
        private String TAG = BannerActivity.class.getSimpleName();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                binding = ActivityBannerBinding.inflate(getLayoutInflater());
                setContentView(binding.getRoot());
                example();
        }

        private void example() {
                banner = binding.bannerAdsContainer;
                banner.removeAllViews();
                AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                mAdManagerAdView = new AdManagerAdView(this);
                mAdManagerAdView.setAdUnitId(mAdUnit);
                mAdManagerAdView.setAdSize(AdSize.BANNER);
                mAdManagerAdView.setAdListener(new AdListener() {
                        @Override
                        public void onAdClicked() {
                                super.onAdClicked();
                        }

                        @Override
                        public void onAdClosed() {
                                super.onAdClosed();
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                super.onAdFailedToLoad(loadAdError);
                                Log.e(TAG, "failed to load banner :"+ loadAdError);
                                Toast.makeText(getApplicationContext(),"Failed to show Ad",Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onAdImpression() {
                                super.onAdImpression();
                        }

                        @Override
                        public void onAdLoaded() {
                                super.onAdLoaded();
                        }

                        @Override
                        public void onAdOpened() {
                                super.onAdOpened();
                        }
                });
                mAdManagerAdView.loadAd(adRequest);
                banner.addView(mAdManagerAdView);

        }

        @Override
        protected void onResume() {
            super.onResume();
            mAdManagerAdView.resume();
        }

        @Override
        protected void onPause() {
            super.onPause();
            mAdManagerAdView.pause();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            mAdManagerAdView.destroy();

        }
}