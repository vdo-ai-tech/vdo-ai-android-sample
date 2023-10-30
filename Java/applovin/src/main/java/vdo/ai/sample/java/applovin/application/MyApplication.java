package vdo.ai.sample.java.applovin.application;

import android.app.Application;
import android.content.Context;

import androidx.annotation.Nullable;
import vdo.ai.android.applovin.VdoApplovinAppOpen;
import vdo.ai.android.core.listeners.VdoAppOpenListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.sample.java.applovin.BuildConfig;


public class MyApplication extends Application {

    public VdoApplovinAppOpen appOpenAd;

    @Override
    public void onCreate() {
        super.onCreate();


        appOpenAd = new VdoApplovinAppOpen.VdoApplovinAppOpenBuilder()
                .withContext(this)
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTagName("in-app-sample-ap-Z1")
                .setApplovinAdUnitId("65b7c54d8705c333")
                .setListener(new VdoAppOpenListener() {
                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdFailedToLoad(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@Nullable VdoAdError vdoAdError) {

                    }
                }).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // if using MultiDexApplication not required Z1MediaManager.initMultiDex function
    }
}
