package vdo.ai.android.example.mediation.bidder.Admob

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.admanager.AdManagerAdView
import vdo.ai.android.example.mediation.bidder.databinding.ActivityBannerBinding

class BannerActivity : AppCompatActivity() {
    private var binding: ActivityBannerBinding? = null
    private var mAdManagerAdView: AdManagerAdView? = null
    private var banner: ViewGroup? = null
    private val mAdUnit = "ca-app-pub-5764867881717582/4020939472"
    private val TAG = BannerActivity::class.java.simpleName
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBannerBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        example()
    }

    private fun example() {
        banner = binding?.bannerAdsContainer
        banner?.removeAllViews()
        val adRequest = AdRequest.Builder().build()
        mAdManagerAdView = AdManagerAdView(this)
        mAdManagerAdView?.setAdUnitId(mAdUnit)
        mAdManagerAdView?.setAdSize(AdSize.BANNER)
        mAdManagerAdView?.setAdListener(object : AdListener() {
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
        mAdManagerAdView?.loadAd(adRequest)
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