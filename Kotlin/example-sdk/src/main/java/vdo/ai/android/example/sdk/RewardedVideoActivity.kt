package vdo.ai.android.example.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import vdo.ai.android.core.listeners.VdoRewardedListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.sdk.VdoAIRewardedVideoAd

class RewardedVideoActivity : AppCompatActivity() {
    var TAG= RewardedVideoActivity :: class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewarded_video)
        example()
    }
    private fun example(){

        val rewardedVideoAd =  VdoAIRewardedVideoAd.VdoAIRewardedVideoAdBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-rw-Z1")
            .setApplovinAdUnitId("cd864cbae2e0ac35")
            .setIronSourceParams(ironSourceApiKey,"DefaultRewardedVideo")
            .setAllowRefresh(false)
            .setListener( object : VdoRewardedListener {

                override fun onAdLoaded() {
                }

                override fun onAdImpression() {
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                }

                override fun onAdClicked() {
                }

                override fun onAdDismissedFullScreenContent() {
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                }

                override fun onAdShowedFullScreenContent() {
                }

                override fun onUserEarnedReward(amount: Int, type: String) {
                }

            }).build()
    }

}