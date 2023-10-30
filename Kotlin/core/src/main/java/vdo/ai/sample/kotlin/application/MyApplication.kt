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
                    Log.d(TAG, "GAM onAdLoaded >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "GAM onAdFailedToLoad $adError >>>>>>>>> ")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "GAM onAdDismissedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "GAM onAdShowedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "GAM onAdFailedToShowFullScreenContent $adError >>>>>>>>> ")
                }

            }).build()

    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
    }
}

