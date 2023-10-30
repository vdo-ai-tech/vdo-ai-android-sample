package vdo.ai.sample.java.core.application;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;

import vdo.ai.android.core.VdoAppOpenAd;
import vdo.ai.android.core.listeners.VdoAppOpenListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.sample.java.core.BuildConfig;


public class MyApplication extends Application {

    public VdoAppOpenAd appOpenAd;
    @Override
    public void onCreate() {
        super.onCreate();


        appOpenAd = new VdoAppOpenAd.VdoAppOpenAdBuilder()
                .withContext(this)
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTagName("in-app-sample-ap-Z1")
                .setListener(new VdoAppOpenListener(){

                    @Override
                    public void onAdFailedToShowFullScreenContent(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdFailedToLoad(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                    }
                }).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // if using MultiDexApplication not required Z1MediaManager.initMultiDex function
    }
}
