package vdo.ai.sample.java.core;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import vdo.ai.android.core.listeners.OnShowAdCompleteListener;
import vdo.ai.sample.java.core.application.MyApplication;
import vdo.ai.sample.java.core.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    String LOG_TAG = "SplashActivity";

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MyApplication application = (MyApplication) getApplication();


                // If the application is not an instance of MyApplication, log an error message and
                // start the MainActivity without showing the app open ad.
                if (application == null) {
                    Log.e(LOG_TAG, "Failed to cast application to MyApplication.");
                    startMainActivity();
                    return;
                }

                application.appOpenAd.showAdIfAvailable(SplashActivity.this, new OnShowAdCompleteListener() {
                    @Override
                    public void onShowAdComplete() {
                        Log.e(LOG_TAG, " onShowAdComplete");
                        startMainActivity();
                    }
                });
            }
        }, 3000);
    }


    void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}