package vdo.ai.android.example.applovin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.applovin.VdoApplovinInterstitial
import vdo.ai.android.core.listeners.VdoInterstitialListener
import vdo.ai.android.core.models.VdoAdError

/**
 *  created by Harsh Shrivastava at 6th Oct 2023
 *
 **/
class InterstitialAdActivity : AppCompatActivity() {
    var TAG= InterstitialAdActivity :: class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial_ad)

        example()
    }

    private fun example(){

        val interstitialAd =  VdoApplovinInterstitial.VdoApplovinInterstitialBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-in-Z1")
            .setAllowRefresh(false)
            .setApplovinAdUnitId("3783ef4231ce9697")
            .setListener( object : VdoInterstitialListener {
                override fun onAdLoaded() {
                }

                override fun onAdImpression() {
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                }

                override fun onAdClicked() {
                }

                override fun onAdDismissedFullScreenContent() {
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                }

                override fun onAdShowedFullScreenContent() {
                }
            }).build()
    }
}