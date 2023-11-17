package vdo.ai.sample.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.core.VdoInterstitialAd
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

        val interstitialAd =  VdoInterstitialAd.VdoInterstitialAdBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-in-Z1")
            .setAllowRefresh(false)
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