package vdo.ai.android.example.mediation.bidder

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.example.mediation.bidder.Admob.BannerActivity
import vdo.ai.android.example.mediation.bidder.Admob.InterstitialActivity
import vdo.ai.android.example.mediation.bidder.Admob.RewardedInterstitialActivity
import vdo.ai.android.example.mediation.bidder.Admob.RewardedVideoActivity
import vdo.ai.android.example.mediation.bidder.databinding.ActivityAdMobHomeBinding

class AdMobHomeActivity : AppCompatActivity() {
    var binding: ActivityAdMobHomeBinding? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdMobHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.banner_ad) {
            startActivity(Intent(this, BannerActivity::class.java))
        } else if (itemId == R.id.interstitialAd) {
            startActivity(Intent(this, InterstitialActivity::class.java))
        } else if (itemId == R.id.rewarded_videoAd) {
            startActivity(Intent(this, RewardedVideoActivity::class.java))
        } else if (itemId == R.id.rewarded_interstitialAd) {
            startActivity(Intent(this, RewardedInterstitialActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}