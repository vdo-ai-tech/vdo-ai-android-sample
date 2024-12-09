package vdo.ai.sample.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.sample.kotlin.databinding.ActivityFragmentBannerBinding


class FragmentBannerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBannerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check if it's the initial creation to avoid adding fragment on configuration changes
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, BannerFragment()) // Replace with your Fragment and container ID
                .commit()
        }
        // ... other code for your MainActivity ...
    }
}