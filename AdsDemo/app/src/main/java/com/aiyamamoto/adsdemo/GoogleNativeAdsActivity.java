package com.aiyamamoto.adsdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;

import java.util.List;

public class GoogleNativeAdsActivity extends AppCompatActivity {

    private static final String ADMOB_AD_UNIT_ID = "ca-app-pub-3940256099942544/2247696110";

    AdLoader adLoader;
    private Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_native_ads);

        refresh = findViewById(R.id.btn_refresh);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unusedView) {
                refreshAd();
            }
        });

        refreshAd();

//        adLoader = new AdLoader.Builder(this, ADMOB_AD_UNIT_ID)
//                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//                    @Override
//                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//                        // Show the ad.
//                        // Assumes you have a placeholder FrameLayout in your View layout
//                        // (with id fl_adplaceholder) where the ad is to be placed.
//                        FrameLayout frameLayout =
//                                findViewById(R.id.fl_adplaceholder);
//                        // Assumes that your ad layout is in a file call ad_unified.xml
//                        // in the res/layout folder
//                        UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater()
//                                .inflate(R.layout.ad_unified, null);
//
//                        frameLayout.removeAllViews();
//                        frameLayout.addView(adView);
//
//
//                        if (adLoader.isLoading()) {
//                            // The AdLoader is still loading ads.
//                            // Expect more adLoaded or onAdFailedToLoad callbacks.
//                        } else {
//                            // The AdLoader has finished loading ads.
//                        }
//                    }
//                })
//                .withAdListener(new AdListener() {
//                    // optional method
//                    // AdListener callbacks like OnAdFailedToLoad, OnAdOpened, and so on,
//                    // can be overridden here.
//                    @Override
//                    public void onAdFailedToLoad(int errorCode) {
//                        // Handle the failure by logging, altering the UI, and so on.
//                        Toast.makeText(GoogleNativeAdsActivity.this, "Failed to load native ad: "
//                                + errorCode, Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .withNativeAdOptions(new NativeAdOptions.Builder()
//                        // optional method
//                        // Methods in the NativeAdOptions.Builder class can be
//                        // used here to specify individual options settings.
//                        .build())
//                .build();

//        loadAd();
//        displayUnifiedNativeAd();
    }

    private void loadAd() {
        adLoader.loadAd(new AdRequest.Builder().build());
    }


    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
        VideoController vc = nativeAd.getVideoController();

        vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            public void onVideoEnd() {
                // Here apps can take action knowing video playback is finished.
                // It's always a good idea to wait for playback to complete before
                // replacing or refreshing a native ad, for example.
                refresh.setEnabled(true);
                super.onVideoEnd();
            }
        });

        MediaView mediaView = adView.findViewById(R.id.ad_media);
        ImageView imageView = adView.findViewById(R.id.ad_image);

        if(vc.hasVideoContent()) {
            adView.setMediaView(mediaView);
            imageView.setVisibility(View.GONE);
        } else {
            adView.setImageView(imageView);
            mediaView.setVisibility(View.GONE);

            List<NativeAd.Image> images = nativeAd.getImages();
            imageView.setImageDrawable(images.get(0).getDrawable());

            refresh.setEnabled(true);
        }


        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
//        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
//        adView.setPriceView(adView.findViewById(R.id.ad_price));
//        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
//        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        // Some assets are guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        ((TextView) adView.getBodyView()).setText(nativeAd.getBody());

//        ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

//        if (nativeAd.getPrice() == null) {
//            adView.getPriceView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getPriceView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
//        }
//
//        if (nativeAd.getStore() == null) {
//            adView.getStoreView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getStoreView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
//        }
//
//        if (nativeAd.getStarRating() == null) {
//            adView.getStarRatingView().setVisibility(View.INVISIBLE);
//        } else {
//            ((RatingBar) adView.getStarRatingView())
//                    .setRating(nativeAd.getStarRating().floatValue());
//            adView.getStarRatingView().setVisibility(View.VISIBLE);
//        }
//
        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        adView.setNativeAd(nativeAd);

    }




    private void refreshAd() {
        refresh.setEnabled(false);

        AdLoader.Builder builder = new AdLoader.Builder(this, ADMOB_AD_UNIT_ID);

        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            // OnUnifiedNativeAdLoadedListener implementation.
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                FrameLayout frameLayout =
                        findViewById(R.id.fl_adplaceholder);
                UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater()
                        .inflate(R.layout.ad_unified, null);
                populateUnifiedNativeAdView(unifiedNativeAd, adView);
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
            }

        });

//        VideoOptions videoOptions = new VideoOptions.Builder()
//                .setStartMuted(startVideoAdsMuted.isChecked())
//                .build();

//        NativeAdOptions adOptions = new NativeAdOptions.Builder()
//                .setVideoOptions(videoOptions)
//                .build();

//        builder.withNativeAdOptions(adOptions);

        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                refresh.setEnabled(true);
                Toast.makeText(GoogleNativeAdsActivity.this, "Failed to load native ad: "
                        + errorCode, Toast.LENGTH_SHORT).show();
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());

//        videoStatus.setText("");
    }
}
