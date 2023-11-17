package vdo.ai.android.example.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import vdo.ai.android.core.listeners.VdoRewardedListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.sdk.VdoAIRewardedInterstitialAd

class RewardedInterstitialActivity : AppCompatActivity() {
    var TAG= RewardedInterstitialActivity :: class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewarded_interstitial)
        example()
    }

    private fun example(){

        val rewardedInterstitialAd =  VdoAIRewardedInterstitialAd.VdoAIRewardedInterstitialAdBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-rw-Z1")
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