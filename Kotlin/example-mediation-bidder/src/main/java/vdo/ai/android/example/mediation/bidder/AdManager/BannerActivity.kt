package vdo.ai.android.example.mediation.bidder.AdManager

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.admanager.AdManagerAdView
import vdo.ai.android.example.mediation.bidder.databinding.ActivityBannerBinding

class BannerActivity : AppCompatActivity() {
    private var binding: ActivityBannerBinding? = null
    private var mAdManagerAdView: AdManagerAdView? = null
    private var banner: ViewGroup? = null
    private val mAdUnit =
        "/22100121508/montest/net_one97_paytm/ellipsis_dfp_in_app_paytm_secure_b_ellipsis_pre_1"
    private val TAG = BannerActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBannerBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        example()
    }

    private fun example() {
        banner = binding?.bannerAdsContainer
        banner?.removeAllViews()
        val adRequest: AdManagerAdRequest = AdManagerAdRequest.Builder().build()
        mAdManagerAdView = AdManagerAdView(this)
        mAdManagerAdView?.apply {
            setAdUnitId(mAdUnit)
            setAdSize(AdSize.BANNER)
            setAdListener(object : AdListener() {
            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdClosed() {
                super.onAdClosed()
            }

            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                super.onAdFailedToLoad(loadAdError)
                Log.e(TAG, "failed to load banner :$loadAdError")
                Toast.makeText(getApplicationContext(), "Failed to show Ad", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onAdImpression() {
                super.onAdImpression()
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
            }

            override fun onAdOpened() {
                super.onAdOpened()
            }
        })
            loadAd(adRequest)

        }
        banner?.addView(mAdManagerAdView)
    }

    protected override fun onResume() {
        super.onResume()
        mAdManagerAdView?.resume()
    }

    protected override fun onPause() {
        super.onPause()
        mAdManagerAdView?.pause()
    }

    protected override fun onDestroy() {
        super.onDestroy()
        mAdManagerAdView?.destroy()
    }
}