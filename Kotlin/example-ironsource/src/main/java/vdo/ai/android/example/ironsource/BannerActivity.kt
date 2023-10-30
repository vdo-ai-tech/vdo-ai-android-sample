package vdo.ai.android.example.ironsource

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.core.listeners.VdoBannerAdListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.core.utils.VdoAdSize
import vdo.ai.android.example.ironsource.databinding.ActivityBannerBinding
import vdo.ai.android.ironsource.VdoIronSourceBanner
import vdo.ai.android.ironsource.utils.VdoIronSourceUtils

/**
 *  created by Ashish Saini at 5th Oct 2023
 *
 **/
const val ironSourceApiKey :String="85460dcd"
const val ironSourceOfferApiKey:String ="194c4bf7d"
class BannerActivity : AppCompatActivity() {

    lateinit var binding : ActivityBannerBinding
    var bannerAd : VdoIronSourceBanner?=null
    val builder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        example()
    }

    private fun example(){
        bannerAd = VdoIronSourceBanner.VdoISBannerBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setBannerView(binding.bannerAdsContainer)
            .setTagName("in-app-sample-b-Z1")
            .setIronSourceParams(ironSourceApiKey,"DefaultBanner")
            .setAllowRefresh(false)
            .setAddSize(VdoAdSize.BANNER)
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
        VdoIronSourceUtils.onPause(this@BannerActivity,bannerAd)
    }

    override fun onResume() {
        super.onResume()
        VdoIronSourceUtils.onResume(this@BannerActivity,bannerAd)
    }

    override fun onDestroy() {
        super.onDestroy()
        VdoIronSourceUtils.destroyBanner(bannerAd)
    }

}
