package vdo.ai.sample.java.ironsource;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import vdo.ai.android.core.VdoBannerAd;
import vdo.ai.android.core.listeners.VdoBannerAdListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.android.core.utils.VdoAdSize;
import vdo.ai.android.core.utils.VdoKUtils;
import vdo.ai.android.ironsource.VdoIronSourceBanner;
import vdo.ai.android.ironsource.utils.VdoIronSourceUtils;
import vdo.ai.sample.java.ironsource.application.MyApplication;
import vdo.ai.sample.java.ironsource.databinding.ActivityBannerBinding;

public class BannerActivity extends AppCompatActivity {
        private VdoIronSourceBanner bannerAd = null;
        private ActivityBannerBinding binding;
        StringBuilder builder = new StringBuilder();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                binding = ActivityBannerBinding.inflate(getLayoutInflater());
                setContentView(binding.getRoot());
                example();
        }

        private void example() {

                bannerAd = new VdoIronSourceBanner.VdoISBannerBuilder()
                        .withContext(this)
                        .setEnvironment(BuildConfig.BUILD_TYPE)
                        .setBannerView(binding.bannerAdsContainer)
                        .setTagName("in-app-sample-b-Z1")
                        .setIronSourceParams(MyApplication.IRON_SOURCE_APP_KEY,"DefaultBanner")
                        .setAllowRefresh(false)
                        .setAddSize(VdoAdSize.BANNER)
                        .setListener(new VdoBannerAdListener() {

                                @Override
                                public void onAdOpened() {
                                        builder.append("Add Opened \n");
                                        binding.textView.setText(builder.toString());
                                }

                                @Override
                                public void onAdLoaded() {
                                        builder.append("Add Loaded \n");
                                        binding.textView.setText(builder.toString());
                                }

                                @Override
                                public void onAdImpression() {
                                        builder.append("Add Impression \n");
                                        binding.textView.setText(builder.toString());
                                }

                                @Override
                                public void onAdFailedToLoad(@Nullable VdoAdError vdoAdError) {
                                        builder.append("Add Fail to load \n");
                                        binding.textView.setText(builder.toString());
                                }

                                @Override
                                public void onAdClosed() {
                                        builder.append("Add Closed \n");
                                        binding.textView.setText(builder.toString());
                                }

                                @Override
                                public void onAdClicked() {
                                        builder.append("Add Clicked \n");
                                        binding.textView.setText(builder.toString());
                                }

                                @Override
                                public void onMediationSuccess() {
                                }

                        }).build();
        }

        @Override
        protected void onResume() {
            super.onResume();
            VdoIronSourceUtils.onResume(this, bannerAd);
        }

        @Override
        protected void onPause() {
            super.onPause();
            VdoIronSourceUtils.onPause(this, bannerAd);
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            VdoIronSourceUtils.destroyBanner(bannerAd);
        }
}