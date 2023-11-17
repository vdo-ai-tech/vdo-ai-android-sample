package vdo.ai.sample.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.VideoOptions
import com.google.android.gms.ads.nativead.NativeAdOptions
import vdo.ai.android.core.VdoNativeAd
import vdo.ai.android.core.utils.VdoNativeAdBinder
import vdo.ai.android.core.listeners.VdoNativeAdListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.core.utils.VdoMediaAspectRatio
import vdo.ai.sample.kotlin.databinding.ActivityNativeAdBinding

class NativeAdActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityNativeAdBinding
    private var TAG = NativeAdActivity:: class.java.simpleName
    private var nativeAd : VdoNativeAd?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNativeAdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        example()
    }

    private fun example(){

        val nativeAdOption = NativeAdOptions.Builder()
                .setVideoOptions(VideoOptions.Builder().setStartMuted(true).build())
                .setMediaAspectRatio(VdoMediaAspectRatio.LANDSCAPE.ratio).build()

        val nativeAdBinder = VdoNativeAdBinder.VdoNativeAdBinderBuilder(R.layout.native_ad_layout)
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


        nativeAd = VdoNativeAd.VdoNativeAdBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-n-Z1")
            .setNativeAdContainer(binding.nativeAdContainer)
            .setNativeAdBinder(nativeAdBinder)
            .setNativeAdOptions(nativeAdOption)
            .setAllowRefresh(false)
            .setListener( object : VdoNativeAdListener {

//                override fun onNativeAd(nativeAd: NativeAd) {
//                    Log.d(TAG, "GAM  onNativeAd >>>>>>>>> ")
////                    val nativeBinding: NativeAdLayoutBinding = NativeAdLayoutBinding.inflate(layoutInflater)
////                    populateNativeAdView(nativeAd, nativeBinding)
//                }

                override fun onAdLoaded() {
                    Log.d(TAG, "GAM  onAdLoaded >>>>>>>>> ")
                }

                override fun onAdImpression() {
                    Log.d(TAG, "GAM  onAdImpression >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "GAM  onAdFailedToLoad >>>>>>>>> ")
                }

                override fun onAdClicked() {
                    Log.d(TAG, "GAM  onAdClicked >>>>>>>>> ")
                }

                override fun onAdOpened() {
                    Log.d(TAG, "GAM  onAdOpened >>>>>>>>> ")
                }

                override fun onAdClosed() {
                    Log.d(TAG, "GAM  onAdClosed >>>>>>>>> ")
                }
            }).build()
    }

}