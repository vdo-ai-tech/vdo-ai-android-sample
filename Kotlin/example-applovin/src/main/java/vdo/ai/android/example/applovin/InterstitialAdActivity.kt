package vdo.ai.android.example.applovin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.applovin.VdoApplovinInterstitial
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

        val interstitialAd =  VdoApplovinInterstitial.VdoApplovinInterstitialBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-in-Z1")
            .setAllowRefresh(false)
            .setApplovinAdUnitId("3783ef4231ce9697")
            .setListener( object : VdoInterstitialListener {
                override fun onAdLoaded() {
                    Log.d(TAG, "Applovin onAdLoaded >>>>>>>>> ")
                }

                override fun onAdImpression() {
                    Log.d(TAG, "Applovin onAdImpression >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "Applovin onAdFailedToLoad $adError >>>>>>>>> ")
                }

                override fun onAdClicked() {
                    Log.d(TAG, "Applovin onAdClicked >>>>>>>>> ")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Applovin onAdDismissedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "Applovin onAdFailedToShowFullScreenContent $adError >>>>>>>>> ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "Applovin onAdShowedFullScreenContent >>>>>>>>> ")
                }
            }).build()
    }
}