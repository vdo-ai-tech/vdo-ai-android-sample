package vdo.ai.android.example.applovin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.applovin.VdoApplovinBanner
import vdo.ai.android.applovin.utils.VdoApplovinUtils
import vdo.ai.android.core.listeners.VdoBannerAdListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.core.utils.VdoAdSize
import vdo.ai.android.example.applovin.databinding.ActivityBannerBinding

/**
 *  created by Harsh Shrivastava at 6th Oct 2023
 *
 **/
class BannerActivity : AppCompatActivity() {

    lateinit var binding : ActivityBannerBinding
    var bannerAd : VdoApplovinBanner?=null
    val builder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        example()
    }

    private fun example(){
        bannerAd = VdoApplovinBanner.VdoBannerAdApplovinBuilder()
            .withContext(applicationContext)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setBannerView(binding.bannerAdsContainer)
            .setTagName("in-app-sample-b-Z1")
            .setApplovinAdUnitId("5d304aee42703c8f")
            .setAddSize(VdoAdSize.BANNER)
            .setAllowRefresh(false)
            .setListener( object : VdoBannerAdListener {
                override fun onAdClicked() {
                    builder.append("Add Clicked \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdClosed() {
                    builder.append("Add Closed \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    builder.append("Add Fail to load \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdImpression() {
                    builder.append("Add impression \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdLoaded() {
                    builder.append("Add loaded \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdOpened() {
                    builder.append("Add opened \n")
                    binding.textView.text = builder.toString()
                }
            }).build()

    }

    override fun onPause() {
        super.onPause()
        VdoApplovinUtils.onPause(this@BannerActivity,bannerAd)
    }

    override fun onResume() {
        super.onResume()
        VdoApplovinUtils.onResume(this@BannerActivity,bannerAd)
    }
    override fun onDestroy() {
        super.onDestroy()
        VdoApplovinUtils.destroyBanner(bannerAd)
    }

}
