package com.aiyamamoto.adsdemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smaato.soma.BannerView;

public class SmaatoBannerAdsActivity extends AppCompatActivity {

    BannerView mBannerView;
    Button loadBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smaato_banner_ads);

        mBannerView = (BannerView) findViewById(R.id.bannerView) ;
        mBannerView.getAdSettings().setPublisherId(0);
        mBannerView.getAdSettings().setAdspaceId(0);
        setTitleColor(Color.WHITE);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3498db")));
        mBannerView = (BannerView) findViewById(R.id.bannerView);
        loadBanner = (Button) findViewById(R.id.load_ad );
        mBannerView.asyncLoadNewBanner();
    }

    public void loadBannerAd(View view) {
        mBannerView.asyncLoadNewBanner();
    }

    @Override
    public void onDestroy() {
        if(mBannerView!=null){
            mBannerView.destroy();
        }

        super.onDestroy();
    }
}
