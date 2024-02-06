package vdo.ai.android.example.ironsource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.VideoOptions
import com.google.android.gms.ads.nativead.NativeAdOptions
import vdo.ai.android.core.VdoNativeAd
import vdo.ai.android.core.listeners.VdoNativeAdListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.core.utils.VdoMediaAspectRatio
import vdo.ai.android.core.utils.VdoNativeAdBinder
import vdo.ai.android.example.ironsource.databinding.ActivityNativeAdBinding
import vdo.ai.android.ironsource.VdoIronSourceNativeAd

class NativeAdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNativeAdBinding
    private var nativeAd: VdoIronSourceNativeAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNativeAdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        example()
    }

    private fun example() {

        val nativeAdOption = NativeAdOptions.Builder()
            .setVideoOptions(VideoOptions.Builder().setStartMuted(true).build())
            .setMediaAspectRatio(VdoMediaAspectRatio.LANDSCAPE.ratio).build()


        val nativeAdBinder =VdoNativeAdBinder.VdoNativeAdBinderBuilder(R.layout.native_ad_layout)
                .setTitleTextViewId(R.id.ad_headline)
                .setBodyTextViewId(R.id.ad_body)
                .setStarRatingContentViewGroupId(R.id.ad_stars)
                .setAdvertiserTextViewId(R.id.ad_advertiser)
                .setIconImageViewId(R.id.ad_app_icon)
                .setMediaContentViewGroupId(R.id.ad_media)
                .setCallToActionButtonId(R.id.ad_call_to_action)
                .setAdPriceTextViewId(R.id.ad_price)
                .setAdStoreTextViewId(R.id.ad_store)
                .build()


        nativeAd = VdoIronSourceNativeAd.VdoIronSourceNativeBuilder()
            .withContext(applicationContext)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-n-Z1")
            .setNativeAdContainer(binding.nativeAdContainer)
            .setNativeAdBinder(nativeAdBinder)
            .setNativeAdOptions(nativeAdOption)
            .setAllowRefresh(false)
            .setListener(object : VdoNativeAdListener {

                override fun onAdLoaded() {
                }

                override fun onAdImpression() {
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                }

                override fun onAdClicked() {
                }

                override fun onAdOpened() {
                }

                override fun onAdClosed() {
                }
            }).build()
    }
}

