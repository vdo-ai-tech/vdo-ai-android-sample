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
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
import vdo.ai.android.example.mediation.bidder.databinding.ActivityRewardInterstitialAdBinding

class RewardedInterstitialActivity : AppCompatActivity() {
    var binding: ActivityRewardInterstitialAdBinding? = null
    private var mAdManagerAdView: RewardedInterstitialAd? = null
    private val mAdUnit = "ca-app-pub-5764867881717582/2516286115"
    private val TAG = RewardedInterstitialActivity::class.java.simpleName
    private val callback: RewardedInterstitialAdLoadCallback =
        object : RewardedInterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                super.onAdFailedToLoad(loadAdError)
            }

            override fun onAdLoaded(rewardedInterstitialAd: RewardedInterstitialAd) {
                super.onAdLoaded(rewardedInterstitialAd)
                mAdManagerAdView = rewardedInterstitialAd
                showRewardedInterstitialAd()
            }
        }

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardInterstitialAdBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        example()
    }

    private fun example() {
        val adRequest = AdRequest.Builder().build()
        if (mAdManagerAdView == null) {
            RewardedInterstitialAd.load(this, mAdUnit, adRequest, callback)
        } else {
            showRewardedInterstitialAd()
        }
    }

    private fun showRewardedInterstitialAd() {
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