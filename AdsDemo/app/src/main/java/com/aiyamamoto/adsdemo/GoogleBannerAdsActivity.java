package com.aiyamamoto.adsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by aiyamamoto on 2018-08-21.
 */

public class GoogleBannerAdsActivity extends AppCompatActivity {

    private AdView mAdView;
    private TextView loadingText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_banner_ads);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, String.valueOf(R.string.google_app_id));

        mAdView = findViewById(R.id.adview);
        loadingText = (TextView) findViewById(R.id.loadingTxt);
        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                loadingText.setText("Loaded!");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                loadingText.setText("Load failed...");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });
        if(mAdView != null) {
            mAdView.loadAd(adRequest);
        }

    }
}
