package com.aiyamamoto.adsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize Mopub ad
        // A list of rewarded video adapters to initialize
        List<String> networksToInit = new ArrayList<String>();
        SdkConfiguration sdkConfiguration = new SdkConfiguration.Builder("b195f8dd8ded45fe847ad89ed1d016da")
                .withNetworksToInit(networksToInit)
                .build();
        MoPub.initializeSdk(this, sdkConfiguration, initSdkListener());

    }

    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {
           /* MoPub SDK initialized.
           Check if you should show the consent dialog here, and make your ad requests. */
                Button bunnerButton = (Button) findViewById(R.id.btn_mopub_banner_ads);
                bunnerButton.setEnabled(true);
                Button nativeButton = (Button) findViewById(R.id.btn_mopub_native_ads);
                nativeButton.setEnabled(true);
            }
        };
    }

    public void goToGoogleBanner(View view) {
        Intent intent = new Intent(this, GoogleBannerAdsActivity.class);
        startActivity(intent);
    }

    public void goToGoogleInterstitial(View view) {
        Intent intent = new Intent(this, GoogleInterstialAdsActivity.class);
        startActivity(intent);
    }

    public void goToGoogleRewardedVideo(View view) {
        Intent intent = new Intent(this, GoogleRewardedVideoAdsActivity.class);
        startActivity(intent);
    }

    public void goToGoogleNativeAds(View view) {
        Intent intent = new Intent(this, GoogleNativeAdsActivity.class);
        startActivity(intent);
    }

    public void goToSmaatoBannerAds(View view) {
        Intent intent = new Intent(this, SmaatoBannerAdsActivity.class);
        startActivity(intent);
    }

    public void goToSmaatoNativeAds(View view) {
        Intent intent = new Intent(this, SmaatoNativeAdsActivity.class);
        startActivity(intent);
    }

    public void goToMopubBannerAds(View view) {
        Intent intent = new Intent(this, MopubBannerAdsActivity.class);
        startActivity(intent);
    }

    public void goToMopubNativeAds(View view) {
        Intent intent = new Intent(this, MopubNativeAdsActivity.class);
        startActivity(intent);
    }
}
