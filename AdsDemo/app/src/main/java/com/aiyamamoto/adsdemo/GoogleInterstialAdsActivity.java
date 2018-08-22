package com.aiyamamoto.adsdemo;

/**
 * Created by aiyamamoto on 2018-08-21.
 */

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class GoogleInterstialAdsActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    private Button showAdBtn;
    private CountDownTimer countDownTimer;
    private boolean gameIsInProgress;
    private long timerMilliseconds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_interstial_ads);

        showAdBtn = (Button) findViewById(R.id.showAdBtn);
        showAdBtn.setVisibility(View.INVISIBLE);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, String.valueOf(R.string.google_app_id));

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        loadAd();

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                showAdBtn.setVisibility(View.VISIBLE);
            }


            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdClosed() {
                loadAd();
            }
        });
    }

    public void showInterstitialAd(View view) {
        showInterstitial();
    }

    public void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
        }
    }


    private void loadAd() {
        showAdBtn.setVisibility(View.INVISIBLE);
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);
        }
    }
}
