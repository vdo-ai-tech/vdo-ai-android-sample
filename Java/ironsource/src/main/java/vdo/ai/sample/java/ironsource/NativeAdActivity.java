package vdo.ai.sample.java.ironsource;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;

import vdo.ai.android.core.VdoNativeAd;
import vdo.ai.android.core.listeners.VdoNativeAdListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.android.core.utils.VdoMediaAspectRatio;
import vdo.ai.android.core.utils.VdoNativeAdBinder;
import vdo.ai.android.ironsource.VdoIronSourceNativeAd;
import vdo.ai.sample.java.ironsource.databinding.ActivityNativeAdBinding;

public class NativeAdActivity extends AppCompatActivity {

    private ActivityNativeAdBinding binding;
    private String TAG = NativeAdActivity.class.getSimpleName();
    private VdoIronSourceNativeAd nativeAd ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNativeAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        example();
    }

    private void example(){

        NativeAdOptions nativeAdOption = new NativeAdOptions.Builder()
                .setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build())
                .setMediaAspectRatio(VdoMediaAspectRatio.LANDSCAPE.getRatio()).build();

        VdoNativeAdBinder nativeAdBinder = new VdoNativeAdBinder.VdoNativeAdBinderBuilder(R.layout.native_ad_layout)
                .setTitleTextViewId(R.id.ad_headline)
                .setBodyTextViewId(R.id.ad_body)
                .setStarRatingContentViewGroupId(R.id.ad_stars)
                .setAdvertiserTextViewId(R.id.ad_advertiser)
                .setIconImageViewId(R.id.ad_app_icon)
                .setMediaContentViewGroupId(R.id.ad_media)
                .setCallToActionButtonId(R.id.ad_call_to_action)
                .setAdPriceTextViewId(R.id.ad_price)
                .setAdStoreTextViewId(R.id.ad_store)
                .build();


        nativeAd = new VdoIronSourceNativeAd.VdoIronSourceNativeBuilder()
                .withContext(this.getApplicationContext())
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTagName("in-app-sample-n-Z1")
                .setNativeAdContainer(binding.nativeAdContainer)
                .setNativeAdBinder(nativeAdBinder)
                .setNativeAdOptions(nativeAdOption)
                .setAllowRefresh(false)
                .setListener( new VdoNativeAdListener() {

                    @Override
                    public void onAdOpened() {

                    }

                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdImpression() {

                    }

                    @Override
                    public void onAdFailedToLoad(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdClosed() {

                    }

                    @Override
                    public void onAdClicked() {

                    }
        }).build();
    }

}
