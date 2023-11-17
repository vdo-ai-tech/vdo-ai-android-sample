package vdo.ai.sample.kotlin.application

import android.app.Application
import android.content.Context
import android.util.Log
import vdo.ai.sample.kotlin.BuildConfig
import vdo.ai.android.core.VdoAppOpenAd
import vdo.ai.android.core.listeners.VdoAppOpenListener
import vdo.ai.android.core.models.VdoAdError

/**
 *  created by Harsh Shrivastava at 6th Oct 2023
 *
 **/
class MyApplication : Application() {

    var appOpenAd:VdoAppOpenAd?= null
    var TAG= MyApplication :: class.java.simpleName
    override fun onCreate() {
        super.onCreate()

        appOpenAd = VdoAppOpenAd.VdoAppOpenAdBuilder()
            .withContext(this@MyApplication)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-ap-Z1")
            .setListener(object : VdoAppOpenListener {
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
    }
}

