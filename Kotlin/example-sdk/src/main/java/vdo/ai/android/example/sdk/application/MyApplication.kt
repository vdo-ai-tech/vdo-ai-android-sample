package vdo.ai.android.example.sdk.application

import android.app.Application
import android.content.Context
import android.util.Log
import vdo.ai.android.core.listeners.VdoAppOpenListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.example.sdk.BuildConfig
import vdo.ai.android.example.sdk.ironSourceOfferApiKey
import vdo.ai.android.sdk.VdoAIAppOpen

/**
 *  created by Ashish Saini at 105h Oct 2023
 *
 **/
class MyApplication : Application() {

    var appOpenAd:VdoAIAppOpen?=null
    private var TAG = MyApplication:: class.java.simpleName

    override fun onCreate() {
        super.onCreate()

        appOpenAd = VdoAIAppOpen.VdoAIAppOpenBuilder()
            .withContext(this@MyApplication)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-ap-Z1")
            .setApplovinAdUnitId("83c31eac2dd321a2")
            .setIronSourceParams(ironSourceOfferApiKey, "DefaultOfferWall")
            .setListener(object : VdoAppOpenListener {
                override fun onAdLoaded() {
                    Log.d(TAG, "VdoAIAppOpen onAdLoaded >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "VdoAIAppOpen onAdFailedToLoad $adError >>>>>>>>> ")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "VdoAIAppOpen onAdDismissedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "VdoAIAppOpen onAdShowedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "VdoAIAppOpen onAdFailedToShowFullScreenContent $adError >>>>>>>>> ")
                }
            }).build()

    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
//        Z1MediaManager.initMultiDex(this)
    }
}

