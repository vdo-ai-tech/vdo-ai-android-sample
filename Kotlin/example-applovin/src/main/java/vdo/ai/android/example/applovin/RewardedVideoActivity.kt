package vdo.ai.android.example.applovin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import vdo.ai.android.applovin.VdoApplovinRewardedVideo
import vdo.ai.android.core.listeners.VdoRewardedListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.example.applovin.databinding.ActivityRewardedVideoBinding

/**
 *  created by Ashish Saini at 5th Oct 2023
 *
 **/
class RewardedVideoActivity : AppCompatActivity() {

    lateinit var  binding: ActivityRewardedVideoBinding
    var TAG= RewardedVideoActivity :: class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardedVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        example()
    }

    private fun example(){

        val rewardedVideoAd =  VdoApplovinRewardedVideo.VdoApplovinRewardedVideoBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-rw-Z1")
            .setApplovinAdUnitId("8557a384c1586ebc")
            .setAllowRefresh(false)
            .setListener( object : VdoRewardedListener {

                override fun onAdLoaded() {
                    Log.d(TAG, "Applovin onAdLoaded >>>>>>>>> ")
                }

                override fun onAdImpression() {
                    Log.d(TAG, "Applovin onAdImpression >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "Applovin onAdFailedToLoad $adError>>>>>>>>> ")
                }

                override fun onAdClicked() {
                    Log.d(TAG, "Applovin onAdClicked >>>>>>>>> ")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Applovin onAdDismissedFullScreenContent >>>>>>>>> ")
                }

                override fun onAdFailedToShowFullScreenContent(adError: VdoAdError?) {
                    Log.d(TAG, "Applovin onAdFailedToShowFullScreenContent $adError>>>>>>>>> ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "Applovin onAdShowedFullScreenContent >>>>>>>>> ")
                }

                override fun onUserEarnedReward(amount: Int, type: String) {
                    Log.d(TAG, "Applovin onUserEarnedReward amount: $amount>>>>>>>>> ")
                }

            }).build()
    }
}