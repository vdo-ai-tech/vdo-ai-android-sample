package vdo.ai.android.example.sdk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.core.listeners.VdoInterstitialListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.sdk.VdoAIInterstitial

/**
 *  created by Ashish Saini at 9th Oct 2023
 *
 **/
class InterstitialAdActivity : AppCompatActivity() {
    var TAG = InterstitialAdActivity :: class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial_ad)

        example()
    }

    private fun example(){

        val interstitialAd =  VdoAIInterstitial.VdoAIInterstitialBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-in-Z1")
            .setAllowRefresh(false)
            .setApplovinAdUnitId("da2399776013e5b9")
            .setIronSourceParams(ironSourceApiKey,"DefaultInterstitial")
            .setListener( object : VdoInterstitialListener {
                override fun onAdLoaded() {
                    Log.d(TAG, "interstitialAd onAdLoaded >>>>>>>>> ")
                }

                override fun onAdImpression() {
                    Log.d(TAG, "interstitialAd onAdImpression >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "interstitialAd onAdFailedToLoad $adError >>>>>>>>> ")
                }

                override fun onAdClicked() {
                    Log.d(TAG, "interstitialAd onAdClicked >>>>>>>>> ")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "interstitialAd onAdDismissedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "interstitialAd onAdFailedToShowFullScreenContent $adError >>>>>>>>> ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "interstitialAd onAdShowedFullScreenContent >>>>>>>>> ")
                }
            }).build()
    }
}