package vdo.ai.android.example.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import vdo.ai.android.core.listeners.VdoNativeTemplateAdListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.core.nativeAd.TemplateView
import vdo.ai.android.core.utils.VdoMediaAspectRatio
import vdo.ai.android.core.utils.gone
import vdo.ai.android.core.utils.visible
import vdo.ai.android.sdk.VdoAINativeTemplateAd

class NativeTemplateAdActivity : AppCompatActivity() {
    private var templateSmall : TemplateView?=null
    private var templateMedium : TemplateView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_template_ad)
        templateSmall=findViewById(R.id.template_small)
        templateMedium =findViewById(R.id.template_medium)
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
        templateSmall.visible()
        templateMedium.gone()

        val nativeAd = VdoAINativeTemplateAd.VdoAINativeTemplateAdBuilder()
            .withContext(applicationContext)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTemplateView(templateSmall)
            .setTagName("in-app-sample-n-Z1")
            .setMediaAspectRatio(VdoMediaAspectRatio.PORTRAIT)
            .setBackgroundColor(R.color.white)
            .setListener(object :  VdoNativeTemplateAdListener {

                override fun onAdLoaded() {
                }

                override fun onAdOpened() {
                }

                override fun onAdImpression() {
                }

                override fun onAdClosed() {
                }

                override fun onAdClicked() {
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                }

            }).build()
    }

    private fun mediumNativeAd(){


        templateSmall.gone()
        templateMedium.visible()

        val nativeAd = VdoAINativeTemplateAd.VdoAINativeTemplateAdBuilder()
            .withContext(applicationContext)
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setTemplateView(templateMedium)
            .setAllowRefresh(false)
            .setTagName("in-app-sample-n-Z1")
            .setMediaAspectRatio(VdoMediaAspectRatio.PORTRAIT)
            .setBackgroundColor(R.color.white)
            .setListener(object :  VdoNativeTemplateAdListener {

                override fun onAdLoaded() {
                }

                override fun onAdOpened() {
                }

                override fun onAdImpression() {
                }

                override fun onAdClosed() {
                }

                override fun onAdClicked() {
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                }

            }).build()
    }

}