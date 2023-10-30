package vdo.ai.android.example.applovin.application

import android.app.Application
import android.content.Context
import android.util.Log
import vdo.ai.android.applovin.VdoApplovinAppOpen
import vdo.ai.android.core.listeners.VdoAppOpenListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.example.applovin.BuildConfig

/**
 *  created by Ashish Saini at 6th Oct 2023
 *
 **/
class MyApplication : Application() {

    var appOpenAd:VdoApplovinAppOpen?=null
    var TAG = MyApplication:: class.java.simpleName

    override fun onCreate() {
        super.onCreate()

        appOpenAd = VdoApplovinAppOpen.VdoApplovinAppOpenBuilder()
            .withContext(this@MyApplication)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-ap-Z1")
            .setApplovinAdUnitId("65b7c54d8705c333")

            .setListener(object : VdoAppOpenListener {
                override fun onAdLoaded() {
                    Log.d(TAG, "Applovin onAdLoaded >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "Applovin onAdFailedToLoad $adError >>>>>>>>> ")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Applovin onAdDismissedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "Applovin onAdShowedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "Applovin onAdFailedToShowFullScreenContent $adError >>>>>>>>> ")
                }

            }).build()

    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
//        Z1MediaManager.initMultiDex(this)
    }
}

