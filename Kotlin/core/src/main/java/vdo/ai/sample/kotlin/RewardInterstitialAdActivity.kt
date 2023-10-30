package vdo.ai.sample.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import vdo.ai.android.core.VdoRewardInterstitialAd
import vdo.ai.android.core.listeners.VdoRewardedListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.sample.kotlin.databinding.ActivityRewardInterstitialAdBinding


/**
 *  created by Ashish Saini at 5th Oct 2023
 *
 **/
class RewardInterstitialAdActivity : AppCompatActivity() {

   lateinit var binding : ActivityRewardInterstitialAdBinding
    var TAG= RewardInterstitialAdActivity :: class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardInterstitialAdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        example()
    }

    private fun example(){

        val rewardedinterstitialAd =  VdoRewardInterstitialAd.VdoRewardInterstitialAdBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-rw-Z1")
            .setAllowRefresh(false)
            .setListener( object : VdoRewardedListener {


                override fun onAdLoaded() {
                    Log.d(TAG, "GAM onAdLoaded >>>>>>>>> ")
                }

                override fun onAdImpression() {
                    Log.d(TAG, "GAM onAdImpression >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "GAM onAdFailedToLoad $adError>>>>>>>>> ")
                }

                override fun onAdClicked() {
                    Log.d(TAG, "GAM onAdClicked >>>>>>>>> ")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "GAM onAdDismissedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "GAM onAdFailedToShowFullScreenContent $adError >>>>>>>>> ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "GAM onAdShowedFullScreenContent >>>>>>>>> ")
                }
                override fun onUserEarnedReward(amount: Int, type: String) {
                    Log.d(TAG, "GAM onUserEarnedReward: amount: $amount >>>>>>>>> ")
                }
            }).build()
    }
}