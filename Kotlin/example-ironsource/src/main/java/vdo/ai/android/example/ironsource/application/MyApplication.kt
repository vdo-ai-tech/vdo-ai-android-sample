package vdo.ai.android.example.ironsource.application

import android.app.Application
import android.content.Context
import android.util.Log

import vdo.ai.android.core.listeners.VdoAppOpenListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.example.ironsource.BuildConfig
import vdo.ai.android.example.ironsource.ironSourceOfferApiKey
import vdo.ai.android.ironsource.VdoIronSourceAppOpen

/**
 *  created by Ashish Saini at 6th Oct 2023
 *
 **/
class MyApplication : Application() {

    var appOpenAd: VdoIronSourceAppOpen?= null
    var TAG= MyApplication :: class.java.simpleName

    override fun onCreate() {
        super.onCreate()

        appOpenAd = VdoIronSourceAppOpen.VdoISAppOpenBuilder()
            .withContext(this@MyApplication)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-ap-Z1")
            .setIronSourceParams(ironSourceOfferApiKey, "DefaultOfferWall")
            .setListener(object:VdoAppOpenListener{
                override fun onAdLoaded() {
                    Log.d(TAG, "IronSource onAdLoaded >>>>>>>>> ")

                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "IronSource onAdFailedToLoad $adError >>>>>>>>> ")

                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "IronSource onAdDismissedFullScreenContent >>>>>>>>> ")

                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "IronSource onAdShowedFullScreenContent >>>>>>>>> ")


                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "IronSource onAdFailedToShowFullScreenContent $adError >>>>>>>>> ")

                }

            }).build()

    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
//        Z1MediaManager.initMultiDex(this)
    }
}

