package com.aiyamamoto.adsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
