package vdo.ai.android.example.ironsource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vdo.ai.android.core.listeners.VdoRewardedListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.example.ironsource.databinding.ActivityRewardedVideoBinding
import vdo.ai.android.ironsource.VdoIronSourceRewardedVideo

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

        val rewardedVideoAd =  VdoIronSourceRewardedVideo.VdoISRewardedVideoBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTagName("in-app-sample-rw-Z1")
            .setAllowRefresh(false)
            .setIronSourceParams(ironSourceApiKey,"DefaultRewardedVideo")
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