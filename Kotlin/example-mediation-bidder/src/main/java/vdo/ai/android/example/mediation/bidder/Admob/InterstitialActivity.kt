package vdo.ai.android.example.mediation.bidder.Admob

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import vdo.ai.android.example.mediation.bidder.databinding.ActivityInterstitialAdBinding

class InterstitialActivity : AppCompatActivity() {
    var binding: ActivityInterstitialAdBinding? = null
    private var mAdManagerAdView: InterstitialAd? = null
    private val mAdUnit = "ca-app-pub-5764867881717582/2931219089"
    private val TAG = InterstitialActivity::class.java.simpleName
    private val callback: InterstitialAdLoadCallback = object : InterstitialAdLoadCallback() {
        override fun onAdLoaded(interstitialAd: InterstitialAd) {
            super.onAdLoaded(interstitialAd)
            mAdManagerAdView = interstitialAd
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
            if (mAdManagerAdView != null) {
                mAdManagerAdView?.show(this@InterstitialActivity)
            }
        }

        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
            super.onAdFailedToLoad(loadAdError)
        }
    }

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterstitialAdBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        example()
    }

    private fun example() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, mAdUnit, adRequest, callback)
    }
}