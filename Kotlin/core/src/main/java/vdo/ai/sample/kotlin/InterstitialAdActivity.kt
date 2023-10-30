package vdo.ai.sample.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.core.VdoInterstitialAd
import vdo.ai.android.core.listeners.VdoInterstitialListener
import vdo.ai.android.core.models.VdoAdError

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

        val interstitialAd =  VdoInterstitialAd.VdoInterstitialAdBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-in-Z1")
            .setAllowRefresh(false)
            .setListener( object : VdoInterstitialListener {
                override fun onAdLoaded() {
                    Log.d(TAG, "GAM onAdLoaded >>>>>>>>> ")
                }

                override fun onAdImpression() {
                    Log.d(TAG, "GAM onAdImpression >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "GAM onAdFailedToLoad $adError>>>>>>>>> ")
                }

                override fun onAdClicked() {
                    Log.d(TAG, "GAM onAdClicked >>>>>>>>> ")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "GAM onAdDismissedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "GAM onAdFailedToShowFullScreenContent $adError>>>>>>>>> ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "GAM onAdShowedFullScreenContent >>>>>>>>> ")
                }
            }).build()
    }
}