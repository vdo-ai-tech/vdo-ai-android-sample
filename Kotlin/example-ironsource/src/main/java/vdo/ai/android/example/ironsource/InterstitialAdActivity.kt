package vdo.ai.android.example.ironsource

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.core.listeners.VdoInterstitialListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.ironsource.VdoIronSourceInterstitial

/**
 *  created by Harsh Shrivastava at 6th Oct 2023
 *
 **/
class InterstitialAdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial_ad)

        example()
    }

    private fun example(){

        val interstitialAd =  VdoIronSourceInterstitial.VdoISInterstitialBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-in-Z1")
            .setIronSourceParams(ironSourceApiKey,"DefaultInterstitial")
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