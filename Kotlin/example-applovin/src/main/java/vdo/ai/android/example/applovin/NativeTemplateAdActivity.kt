package vdo.ai.android.example.applovin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import vdo.ai.android.applovin.VdoApplovinNativeTemplate
import vdo.ai.android.core.listeners.VdoNativeTemplateAdListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.core.utils.VdoMediaAspectRatio
import vdo.ai.android.core.utils.gone
import vdo.ai.android.core.utils.visible
import vdo.ai.android.example.applovin.databinding.ActivityNativeTemplateAdBinding

/**
 *  created by Ashish Saini at 5th Oct 2023
 *
 **/
class NativeTemplateAdActivity : AppCompatActivity() {

    lateinit var  binding: ActivityNativeTemplateAdBinding
    var TAG= NativeTemplateAdActivity :: class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNativeTemplateAdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        smallNativeAd()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_native_ad, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.small_native_ad ->{
                smallNativeAd()
                return true
            }

            R.id.medium_native_ad ->{
                mediumNativeAd()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun smallNativeAd(){
        binding.templateSmall.visible()
        binding.templateMedium.gone()

        val nativeAd = VdoApplovinNativeTemplate.VdoApplovinNativeTemplateBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTemplateView(binding.templateSmall)
            .setTagName("in-app-sample-n-Z1")
            .setMediaAspectRatio(VdoMediaAspectRatio.PORTRAIT)
            .setBackgroundColor(R.color.white)
            .setListener(object : VdoNativeTemplateAdListener {

                override fun onAdLoaded() {
                    Log.d(TAG, "Applovin NativeAd onAdLoaded >>>>>>>>> ")
                }

                override fun onAdOpened() {
                    Log.d(TAG, "Applovin NativeAd onAdOpened >>>>>>>>> ")

                }

                override fun onAdImpression() {
                    Log.d(TAG, "Applovin NativeAd onAdImpression >>>>>>>>> ")
                }

                override fun onAdClosed() {
                    Log.d(TAG, "Applovin NativeAd onAdClosed >>>>>>>>> ")
                }

                override fun onAdClicked() {
                    Log.d(TAG, "Applovin NativeAd onAdClicked >>>>>>>>> ")
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "Applovin NativeAd onAdFailedToLoad $adError >>>>>>>>> ")
                }

            }).build()
    }

    private fun mediumNativeAd(){


        binding.templateSmall.gone()
        binding.templateMedium.visible()

        val nativeAd = VdoApplovinNativeTemplate.VdoApplovinNativeTemplateBuilder()
            .withContext(this)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTemplateView(binding.templateMedium)
            .setAllowRefresh(false)
            .setTagName("in-app-sample-n-Z1")
            .setMediaAspectRatio(VdoMediaAspectRatio.PORTRAIT)
            .setBackgroundColor(R.color.white)
            .setListener(object : VdoNativeTemplateAdListener {

                override fun onAdLoaded() {
                    Log.d(TAG, "Applovin NativeAd onAdLoaded >>>>>>>>> ")

                }
                override fun onAdOpened() {
                    Log.d(TAG, "Applovin NativeAd onAdOpened >>>>>>>>> ")

                }
                override fun onAdImpression() {
                    Log.d(TAG, "Applovin NativeAd onAdImpression >>>>>>>>> ")

                }

                override fun onAdClosed() {
                    Log.d(TAG, "Applovin NativeAd onAdClosed >>>>>>>>> ")

                }

                override fun onAdClicked() {
                    Log.d(TAG, "Applovin NativeAd onAdClicked >>>>>>>>> ")

                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    Log.d(TAG, "Applovin NativeAd onAdFailedToLoad $adError >>>>>>>>> ")

                }

            }).build()
    }


}