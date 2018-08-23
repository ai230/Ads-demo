package com.aiyamamoto.adsdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.smaato.soma.ErrorCode;
import com.smaato.soma.nativead.NativeAd;

public class SmaatoNativeAdsActivity extends AppCompatActivity {

    // Step 1:Declare properties
    NativeAd nativeAd;
    RelativeLayout nativeRelativeLayout;

    NativeAd nativeAd2;
    RelativeLayout nativeRelativeLayout2;

    NativeAd nativeAd3;
    RelativeLayout nativeRelativeLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smaato_native_ads);

        // Step 2: Instantiate & Configure mandatory parameters
        nativeAd = new NativeAd(this);
        nativeRelativeLayout = (RelativeLayout) findViewById(R.id.nativeAdLayout);

        nativeAd.getAdSettings().setPublisherId(0);
        nativeAd.getAdSettings().setAdspaceId(0);

        nativeAd.setMainLayout(nativeRelativeLayout);

        // Following are non mandatory formatting as per your app (look and feel) requirements.
        nativeAd.setTitleTextSize(20);
        nativeAd.setWidthWithoutDensity(120);  // density calculation happens inside SDK for icons width
        nativeAd.setHeightWithoutDensity(120); // default value is 70*density

        requestAd(nativeAd, NativeAd.NativeType.APP_WALL, nativeAdTypeListener);

        // ad2
        nativeAd2 = new NativeAd(this);
        nativeRelativeLayout2 = (RelativeLayout) findViewById(R.id.nativeAdLayout2);
        nativeAd2.getAdSettings().setPublisherId(0);
        nativeAd2.getAdSettings().setAdspaceId(0);
        nativeAd2.setMainLayout(nativeRelativeLayout2);
        requestAd(nativeAd2, NativeAd.NativeType.CAROUSEL, nativeAdTypeListener2);

        // ad3
        nativeAd3 = new NativeAd(this);
        nativeRelativeLayout3 = (RelativeLayout) findViewById(R.id.nativeAdLayout3);
        nativeAd3.getAdSettings().setPublisherId(0);
        nativeAd3.getAdSettings().setAdspaceId(0);
        nativeAd3.setMainLayout(nativeRelativeLayout3);
        requestAd(nativeAd3, NativeAd.NativeType.CONTENT_STREAM, nativeAdTypeListener3);

    }

    private void requestAd(NativeAd ad, NativeAd.NativeType nativeType, NativeAd.NativeAdTypeListener nativeAdTypeListener) {
        ad.asyncLoadNativeType(nativeType, nativeAdTypeListener);
    }

    private void bindAdResponce(NativeAd ad, ViewGroup createdNativeLayout) {
        // if required, configure & format individual element of the generated Layout element before binding.
        //nativeAd.getIconImageView().setBackgroundColor(Color.BLUE);
        ad.getTitleView().setTextColor(Color.BLUE);
        // IMPORTANT FOR IMPRESSION COUNT & BEACONS. Invoke bindAdResponse only after attaching mainLayout with visibility (VISIBLE).
        ad.bindAdResponse(createdNativeLayout);
    }

    // native add type listener
    NativeAd.NativeAdTypeListener nativeAdTypeListener = new NativeAd.NativeAdTypeListener() {
        @Override
        public void onAdResponse(ViewGroup createdNativeLayout) {
            bindAdResponce(nativeAd, createdNativeLayout);
        }

        @Override
        public void onError(ErrorCode errorCode, String errorMessage) {
            Log.e("OnErrorResponse", errorMessage); // No Ad Response is fine. Check for errorCode & errorMessage.

        }
    };

    // native add type listener
    NativeAd.NativeAdTypeListener nativeAdTypeListener2 = new NativeAd.NativeAdTypeListener() {
        @Override
        public void onAdResponse(ViewGroup createdNativeLayout) {
            bindAdResponce(nativeAd2, createdNativeLayout);
        }

        @Override
        public void onError(ErrorCode errorCode, String errorMessage) {
            Log.e("OnErrorResponse", errorMessage); // No Ad Response is fine. Check for errorCode & errorMessage.

        }
    };

    // native add type listener
    NativeAd.NativeAdTypeListener nativeAdTypeListener3 = new NativeAd.NativeAdTypeListener() {
        @Override
        public void onAdResponse(ViewGroup createdNativeLayout) {
            bindAdResponce(nativeAd3, createdNativeLayout);
        }

        @Override
        public void onError(ErrorCode errorCode, String errorMessage) {
            Log.e("OnErrorResponse", errorMessage); // No Ad Response is fine. Check for errorCode & errorMessage.

        }
    };

    public void loadNativeAd(View view) {
        requestAd(nativeAd, NativeAd.NativeType.APP_WALL, nativeAdTypeListener);
        requestAd(nativeAd2, NativeAd.NativeType.CAROUSEL, nativeAdTypeListener2);
        requestAd(nativeAd3, NativeAd.NativeType.CONTENT_STREAM, nativeAdTypeListener3);
    }
}
