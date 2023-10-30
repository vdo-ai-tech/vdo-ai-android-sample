package vdo.ai.sample.java.ironsource.application;

import android.app.Application;
import android.content.Context;

import androidx.annotation.Nullable;

import vdo.ai.android.core.VdoAppOpenAd;
import vdo.ai.android.core.listeners.VdoAppOpenListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.android.ironsource.VdoIronSourceAppOpen;
import vdo.ai.sample.java.ironsource.BuildConfig;


public class MyApplication extends Application {

    public VdoIronSourceAppOpen appOpenAd;
    public static String IRON_SOURCE_APP_KEY ="85460dcd"; // sample app key

    @Override
    public void onCreate() {
        super.onCreate();


        appOpenAd = new VdoIronSourceAppOpen.VdoISAppOpenBuilder()
                .withContext(this)
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTagName("in-app-sample-ap-Z1")
                .setIronSourceParams(IRON_SOURCE_APP_KEY, "DefaultOfferWall")
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
