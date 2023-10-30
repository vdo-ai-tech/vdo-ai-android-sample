package vdo.ai.android.example.mediation.bidder.AdManager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback
import vdo.ai.android.example.mediation.bidder.databinding.ActivityInterstitialAdBinding

class InterstitialActivity : AppCompatActivity() {
    var binding: ActivityInterstitialAdBinding? = null
    private var mAdManagerAdView: AdManagerInterstitialAd? = null
    private val mAdUnit =
        "/22100121508/montest/net_one97_paytm/ellipsis_dfp_in_app_paytm_secure_in_ellipsis_pre_1"
    private val TAG = InterstitialActivity::class.java.simpleName
    private val request: AdManagerAdRequest = AdManagerAdRequest.Builder().build()
    private val callback: AdManagerInterstitialAdLoadCallback =
        object : AdManagerInterstitialAdLoadCallback() {
            override fun onAdLoaded(adManagerInterstitialAd: AdManagerInterstitialAd) {
                super.onAdLoaded(adManagerInterstitialAd)
                mAdManagerAdView = adManagerInterstitialAd
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
                Log.d(TAG, "Gam Ad was failed")
            }
        }

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterstitialAdBinding.inflate(getLayoutInflater())
        setContentView(binding?.root)
        example()
    }

    private fun example() {
        AdManagerInterstitialAd.load(this, mAdUnit, request, callback)
    }
}