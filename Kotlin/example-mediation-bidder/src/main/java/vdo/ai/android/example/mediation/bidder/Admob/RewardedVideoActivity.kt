package vdo.ai.android.example.mediation.bidder.Admob

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import vdo.ai.android.example.mediation.bidder.databinding.ActivityRewardedVideoBinding

class RewardedVideoActivity : AppCompatActivity() {
    var binding: ActivityRewardedVideoBinding? = null
    private var mAdManagerAdView: RewardedAd? = null
    private val mAdUnit = "ca-app-pub-5764867881717582/4052729061"
    private val TAG = RewardedVideoActivity::class.java.simpleName
    private val callback: RewardedAdLoadCallback = object : RewardedAdLoadCallback() {
        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
            super.onAdFailedToLoad(loadAdError)
        }

        override fun onAdLoaded(rewardedAd: RewardedAd) {
            super.onAdLoaded(rewardedAd)
            mAdManagerAdView = rewardedAd
            showRewardedAd()
        }
    }

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardedVideoBinding.inflate(getLayoutInflater())
        setContentView(binding?.getRoot())
        example()
    }

    private fun example() {
        val adRequest = AdRequest.Builder().build()
        if (mAdManagerAdView == null) {
            RewardedAd.load(this, mAdUnit, adRequest, callback)
        } else {
            showRewardedAd()
        }
    }

    private fun showRewardedAd() {
        mAdManagerAdView?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent()
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                super.onAdFailedToShowFullScreenContent(adError)
            }

            override fun onAdImpression() {
                super.onAdImpression()
            }

            override fun onAdShowedFullScreenContent() {
                super.onAdShowedFullScreenContent()
            }
        }
        mAdManagerAdView?.show(this, OnUserEarnedRewardListener { rewardItem: RewardItem ->
            Log.d(
                TAG, """
     User earned the reward. Amount: ${rewardItem.getAmount()}
     Type${rewardItem.getType()}
     """.trimIndent()
            )
        })
    }
}