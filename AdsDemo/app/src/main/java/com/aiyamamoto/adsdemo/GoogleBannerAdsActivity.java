package com.aiyamamoto.adsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by aiyamamoto on 2018-08-21.
 */

public class GoogleBannerAdsActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_banner_ads);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, String.valueOf(R.string.google_app_id));

        mAdView = findViewById(R.id.adview);
        AdRequest adRequest = new AdRequest.Builder().build();

        if(mAdView != null) {
            mAdView.loadAd(adRequest);
        }

    }
}
