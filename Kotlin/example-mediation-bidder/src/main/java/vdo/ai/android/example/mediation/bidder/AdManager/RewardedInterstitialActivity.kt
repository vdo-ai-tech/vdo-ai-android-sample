package vdo.ai.android.example.mediation.bidder.AdManager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
import vdo.ai.android.example.mediation.bidder.databinding.ActivityRewardInterstitialAdBinding

class RewardedInterstitialActivity : AppCompatActivity() {
    var binding: ActivityRewardInterstitialAdBinding? = null
    private var mAdManagerAdView: RewardedInterstitialAd? = null
    private val mAdUnit =
        "/22100121508/montest/net_one97_paytm/ellipsis_dfp_in_app_paytm_secure_rw_ellipsis_v2_pre_1"
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
        binding = ActivityRewardInterstitialAdBinding.inflate(getLayoutInflater())
        setContentView(binding?.getRoot())
        example()
    }

    private fun example() {
        val adRequest: AdManagerAdRequest = AdManagerAdRequest.Builder().build()
        if (mAdManagerAdView == null) {
            RewardedInterstitialAd.load(this, mAdUnit, adRequest, callback)
        } else {
            showRewardedInterstitialAd()
        }
    }

    private fun showRewardedInterstitialAd() {
        mAdManagerAdView?.setFullScreenContentCallback(object : FullScreenContentCallback() {
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
        })
        mAdManagerAdView?.show(this, OnUserEarnedRewardListener { rewardItem: RewardItem ->
            Log.d(
                TAG, """User earned the reward. Amount: ${rewardItem.amount} Type${rewardItem.type}""".trimIndent()
            )
        })
    }
}