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
                    Log.d(TAG, "rewardedInterstitialAd onAdLoaded >>>>>>>>> ")

                }

                override fun onAdImpression() {
                    Log.d(TAG, "rewardedInterstitialAd onAdImpression >>>>>>>>> ")

                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "rewardedInterstitialAd onAdFailedToLoad $adError >>>>>>>>> ")

                }

                override fun onAdClicked() {
                    Log.d(TAG, "rewardedInterstitialAd onAdClicked >>>>>>>>> ")

                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "rewardedInterstitialAd onAdDismissedFullScreenContent >>>>>>>>> ")

                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "rewardedInterstitialAd onAdFailedToShowFullScreenContent $adError>>>>>>>>> ")

                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "rewardedInterstitialAd onAdShowedFullScreenContent >>>>>>>>> ")

                }

                override fun onUserEarnedReward(amount: Int, type: String) {
                    Log.d(TAG, "rewardedInterstitialAd onUserEarnedReward amount : $amount >>>>>>>>> ")
                }

            }).build()
    }

}