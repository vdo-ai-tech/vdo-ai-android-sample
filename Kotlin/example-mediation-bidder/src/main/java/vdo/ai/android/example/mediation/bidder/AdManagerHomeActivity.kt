package vdo.ai.android.example.mediation.bidder

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.example.mediation.bidder.AdManager.BannerActivity
import vdo.ai.android.example.mediation.bidder.AdManager.InterstitialActivity
import vdo.ai.android.example.mediation.bidder.AdManager.RewardedVideoActivity
import vdo.ai.android.example.mediation.bidder.AdManager.RewardedInterstitialActivity

import vdo.ai.android.example.mediation.bidder.databinding.ActivityHomeBinding

class AdManagerHomeActivity : AppCompatActivity() {
    var binding: ActivityHomeBinding? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
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