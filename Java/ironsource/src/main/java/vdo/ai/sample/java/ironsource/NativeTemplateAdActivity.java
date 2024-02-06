package vdo.ai.sample.java.ironsource;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.nativead.NativeAd;
import vdo.ai.android.core.listeners.VdoNativeTemplateAdListener;
import vdo.ai.android.core.models.VdoAdError;
import vdo.ai.android.core.utils.VdoMediaAspectRatio;
import vdo.ai.android.ironsource.VdoIronSourceNativeTemplate;
import vdo.ai.sample.java.ironsource.databinding.ActivityNativeTemplateAdBinding;

public class NativeTemplateAdActivity extends AppCompatActivity {

    ActivityNativeTemplateAdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNativeTemplateAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        smallNativeAd();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_native_ad, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.small_native_ad) {
            smallNativeAd();
        } else if (itemId == R.id.medium_native_ad) {
            mediumNativeAd();
        }
        return super.onOptionsItemSelected(item);
    }

    private void smallNativeAd(){
        binding.templateSmall.setVisibility(View.VISIBLE);
        binding.templateMedium.setVisibility(View.GONE);

        VdoIronSourceNativeTemplate nativeAd = new VdoIronSourceNativeTemplate.VdoIronSourceNativeTemplateBuilder()
                .withContext(this.getApplicationContext())
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTemplateView(binding.templateSmall)
                .setTagName("in-app-sample-n-Z1")
                .setMediaAspectRatio(VdoMediaAspectRatio.PORTRAIT)
                .setBackgroundColor(vdo.ai.android.core.R.color.gnt_white)
                .setListener(new VdoNativeTemplateAdListener() {

                    @Override
                    public void onAdOpened() {

                    }

                    @Override
                    public void onAdFailedToLoad(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdClicked() {

                    }

                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdImpression() {

                    }

                    @Override
                    public void onAdClosed() {

                    }
                }).build();

    }

    private void mediumNativeAd(){

        binding.templateSmall.setVisibility(View.GONE);
        binding.templateMedium.setVisibility(View.VISIBLE);

        VdoIronSourceNativeTemplate nativeAd = new VdoIronSourceNativeTemplate.VdoIronSourceNativeTemplateBuilder()
                .withContext(this.getApplicationContext())
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setTemplateView(binding.templateMedium)
                .setTagName("in-app-sample-n-Z1")
                .setMediaAspectRatio(VdoMediaAspectRatio.PORTRAIT)
                .setBackgroundColor(R.color.gnt_white)
                .setListener(new VdoNativeTemplateAdListener() {
                    @Override
                    public void onAdFailedToLoad(@Nullable VdoAdError vdoAdError) {

                    }

                    @Override
                    public void onAdOpened() {

                    }

                    @Override
                    public void onAdClicked() {

                    }

                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdImpression() {

                    }

                    @Override
                    public void onAdClosed() {

                    }
                }).build();

    }

}