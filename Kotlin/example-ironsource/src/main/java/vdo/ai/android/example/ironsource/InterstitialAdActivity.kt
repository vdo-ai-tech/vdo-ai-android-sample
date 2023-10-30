package vdo.ai.android.example.ironsource

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.core.listeners.VdoInterstitialListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.ironsource.VdoIronSourceInterstitial

/**
 *  created by Ashish Saini at 5th Oct 2023
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

        val interstitialAd =  VdoIronSourceInterstitial.VdoISInterstitialBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-in-Z1")
            .setIronSourceParams(ironSourceApiKey,"DefaultInterstitial")
            .setAllowRefresh(false)
            .setListener( object : VdoInterstitialListener {
                override fun onAdLoaded() {
                    Log.d(TAG, "IronSource onAdLoaded >>>>>>>>> ")
                }

                override fun onAdImpression() {
                    Log.d(TAG, "IronSource onAdImpression >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "IronSource onAdFailedToLoad $adError >>>>>>>>> ")
                }

                override fun onAdClicked() {
                    Log.d(TAG, "IronSource onAdClicked >>>>>>>>> ")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "IronSource onAdDismissedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "IronSource onAdFailedToShowFullScreenContent $adError >>>>>>>>> ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "IronSource onAdShowedFullScreenContent >>>>>>>>> ")
                }
            }).build()
    }
}