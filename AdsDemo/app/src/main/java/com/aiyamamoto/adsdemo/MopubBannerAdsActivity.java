package com.aiyamamoto.adsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;

import java.util.ArrayList;
import java.util.List;

public class MopubBannerAdsActivity extends AppCompatActivity implements MoPubView.BannerAdListener{

    private MoPubView mMoPubView;
    TextView loadingTxt;
    public boolean isInit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mopub_banner_ads);

        loadingTxt = (TextView) findViewById(R.id.loadingTxt);

        String unitId = "b195f8dd8ded45fe847ad89ed1d016da";
        mMoPubView = (MoPubView) findViewById(R.id.adview);
        mMoPubView.setAdUnitId(unitId);
        mMoPubView.setBannerAdListener(this);

        mMoPubView.loadAd();
        loadingTxt.setText("Loading...");
    }

    @Override
    public void onBannerLoaded(MoPubView banner) {
        loadingTxt.setText("Ad is loaded");
    }

    @Override
    public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode) {
        loadingTxt.setText("Ad is not available");
    }

    @Override
    public void onBannerClicked(MoPubView banner) {

    }

    @Override
    public void onBannerExpanded(MoPubView banner) {

    }

    @Override
    public void onBannerCollapsed(MoPubView banner) {

    }

    public void loadBannerMopubAd(View v) {
        mMoPubView.loadAd();
        loadingTxt.setText("Loading...");
    }
}
