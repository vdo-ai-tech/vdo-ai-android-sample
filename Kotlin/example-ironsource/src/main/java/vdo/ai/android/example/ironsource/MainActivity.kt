package vdo.ai.android.example.ironsource

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.example.ironsource.databinding.ActivityMainBinding

/**
 *  created by Ashish Saini at 5th Oct 2023
 *
 **/
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    /** Override the default implementation when the user presses the back key. */
    override fun onBackPressed() {
        // Move the task containing the MainActivity to the back of the activity stack, instead of
        // destroying it. Therefore, MainActivity will be shown when the user switches back to the app.
        moveTaskToBack(true)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.banner_ad -> {
                startActivity(Intent(this@MainActivity, BannerActivity::class.java))
                true
            }
            R.id.interstitialAd ->{
                val intent2 = Intent(this@MainActivity, InterstitialAdActivity::class.java)
                startActivity(intent2)
                return true
            }
            R.id.rewarded_videoAd ->{
                val intent2 = Intent(this@MainActivity, RewardedVideoActivity::class.java)
                startActivity(intent2)
                return true
            }

            R.id.native_ad ->{
                val intent2 = Intent(this@MainActivity, NativeAdActivity::class.java)
                startActivity(intent2)
                return true
            }

            R.id.native_template_ad ->{
                val intent2 = Intent(this@MainActivity, NativeTemplateAdActivity::class.java)
                startActivity(intent2)
                return true
            }
//            R.id.reward_interstitialAd ->{
//                startActivity(Intent(this@MainActivity, RewardInterstitialAdActivity::class.java))
//                return true
//            }
//            R.id.video_player_ads ->{
//                startActivity(Intent(this@MainActivity, VideoAdsActivity::class.java))
//                return true
//            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}