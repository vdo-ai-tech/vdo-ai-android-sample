package vdo.ai.sample.kotlin

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import vdo.ai.sample.kotlin.application.MyApplication
import vdo.ai.android.core.listeners.OnShowAdCompleteListener
import vdo.ai.sample.kotlin.databinding.ActivitySplashBinding

/**
 *  created by Ashish Saini at 6th Oct 2023
 *
 **/
class SplashActivity : AppCompatActivity() {
    private val COUNTER_TIME = 1L
    private val LOG_TAG = "SplashActivity"

    private var secondsRemaining: Long = 0L

    lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Create a timer so the SplashActivity will be displayed for a fixed amount of time.
        createTimer(COUNTER_TIME)

    }

    private fun createTimer(seconds: Long) {
        val countDownTimer: CountDownTimer = object :CountDownTimer(seconds * 1000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                secondsRemaining = millisUntilFinished / 1000 + 1
                binding.timer.text = "App is done loading in: $secondsRemaining"
            }

            override fun onFinish() {
                secondsRemaining = 0
                binding.timer.text = "Done."

                val application = application as? MyApplication

                // If the application is not an instance of MyApplication, log an error message and
                // start the MainActivity without showing the app open ad.
                if (application == null) {
                    Log.e(LOG_TAG, "Failed to cast application to MyApplication.")
                    startMainActivity()
                    return
                }


                application.appOpenAd?.showAdIfAvailable(this@SplashActivity, object : OnShowAdCompleteListener {
                    override fun onShowAdComplete() {
                        Log.e(LOG_TAG, " onShowAdComplete")
                        startMainActivity()
                    }
                })
            }
        }

        countDownTimer.start()
    }

    fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}