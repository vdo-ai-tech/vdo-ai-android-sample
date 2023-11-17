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
 *  created by Harsh Shrivastava at 6th Oct 2023
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
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                }

                override fun onAdDismissedFullScreenContent() {
                }

                override fun onAdShowedFullScreenContent() {
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                }

            }).build()

    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
//        Z1MediaManager.initMultiDex(this)
    }
}

