package com.aiyamamoto.adsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.nativeads.AdapterHelper;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.ViewBinder;

import java.util.ArrayList;
import java.util.List;

public class MopubNativeAdsActivity extends AppCompatActivity {

    MoPubNative moPubNative;
    AdapterHelper adapterHelper;
    TextView loadingTxt;
    boolean isInit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mopub_native_ads);

        loadingTxt = (TextView) findViewById(R.id.loadingTxt);

        String unitId = "11a17b188668469fb0412708c3d16813";

        moPubNative = new MoPubNative(this, unitId, moPubNativeNetworkListener);

        adapterHelper = new AdapterHelper(this, 0,3);

        ViewBinder viewBinder = new ViewBinder.Builder(R.layout.mopub_native_ad_item)
                .mainImageId(R.id.native_main_image)
                .iconImageId(R.id.native_icon_image)
                .titleId(R.id.native_title)
                .textId(R.id.native_text)
                .privacyInformationIconImageId(R.id.native_privacy_information_icon_image)
                .build();

        MoPubStaticNativeAdRenderer moPubStaticNativeAdRenderer = new MoPubStaticNativeAdRenderer(viewBinder);
        moPubNative.registerAdRenderer(moPubStaticNativeAdRenderer);

        moPubNative.makeRequest();
        loadingTxt.setText("Loading...");

    }



    MoPubNative.MoPubNativeNetworkListener moPubNativeNetworkListener = new MoPubNative.MoPubNativeNetworkListener() {
        @Override
        public void onNativeLoad(NativeAd nativeAd) {
            // Retrieve the pre-built ad view that AdapterHelper prepared for us.
            View v = adapterHelper.getAdView(null, null, nativeAd, new ViewBinder.Builder(0).build());
            // Set the native event listeners (onImpression, and onClick).
            nativeAd.setMoPubNativeEventListener(moPubNativeEventListener);
            // Add the ad view to our view hierarchy
            ViewGroup contentRoot = (ViewGroup)findViewById(R.id.conteiner);
            contentRoot.addView(v);
            loadingTxt.setText("Ad is loaded");
        }

        @Override
        public void onNativeFail(NativeErrorCode errorCode) {
            loadingTxt.setText("Ad is not available");
        }
    };

    NativeAd.MoPubNativeEventListener moPubNativeEventListener = new NativeAd.MoPubNativeEventListener() {

        @Override
        public void onImpression(View view) {
            Log.d("MoPub", "Native ad recorded an impression.");
        }

        @Override
        public void onClick(View view) {
            Log.d("MoPub", "Native ad recorded a click.");
        }
    };

    public void loadNativeMopubAd(View v) {
        moPubNative.makeRequest();
        loadingTxt.setText("Loading...");
    }

}
