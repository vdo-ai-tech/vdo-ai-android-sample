package vdo.ai.android.example.mediation.bidder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.android.example.mediation.bidder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.adManager?.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AdManagerHomeActivity::class.java
                )
            )
        }
        binding?.admob?.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AdMobHomeActivity::class.java
                )
            )
        }
    }
}