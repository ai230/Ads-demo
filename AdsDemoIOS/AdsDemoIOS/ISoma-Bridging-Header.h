//
//  ISoma-Bridging-Header.h
//  AdsDemoIOS
//
//  Created by Ai Yamamoto on 2018-08-23.
//  Copyright © 2018 Ai Yamamoto. All rights reserved.
//

#ifndef ISoma_Bridging_Header_h
#define ISoma_Bridging_Header_h
#import <iSoma/iSoma.h>
//#import <mopub-ios-sdk/MoPub-Bridging-Header.h>

#import "MoPub/MoPub.h"

#import "MoPub/MPAdConversionTracker.h"
#import "MoPub/MPAdView.h"
#import "MoPub/MPBannerCustomEvent.h"
#import "MoPub/MPBannerCustomEventDelegate.h"
#import "MoPub/MPConstants.h"
#import "MoPub/MPInterstitialAdController.h"
#import "MoPub/MPInterstitialCustomEvent.h"
#import "MoPub/MPInterstitialCustomEventDelegate.h"

#if MP_HAS_NATIVE_PACKAGE

#import "MoPub/MPNativeAd.h"
#import "MoPub/MPNativeAdAdapter.h"
#import "MoPub/MPNativeAdConstants.h"
#import "MoPub/MPNativeCustomEvent.h"
#import "MoPub/MPNativeCustomEventDelegate.h"
#import "MoPub/MPNativeAdDelegate.h"
#import "MoPub/MPNativeAdError.h"
#import "MoPub/MPNativeAdRendering.h"
#import "MoPub/MPNativeAdRequest.h"
#import "MoPub/MPNativeAdRequestTargeting.h"
#import "MoPub/MPStaticNativeAdRendererSettings.h"
#import "MoPub/MPNativeAdRendererConfiguration.h"
#import "MoPub/MPNativeAdRendererSettings.h"
#import "MoPub/MPNativeAdRenderer.h"
#import "MoPub/MPStaticNativeAdRenderer.h"
#import "MoPub/MOPUBNativeVideoAdRendererSettings.h"
#import "MoPub/MOPUBNativeVideoAdRenderer.h"
#import "MoPub/MPNativeAdRenderingImageLoader.h"
#import "MoPub/MPClientAdPositioning.h"
#import "MoPub/MPServerAdPositioning.h"
#import "MoPub/MPCollectionViewAdPlacer.h"
#import "MoPub/MPTableViewAdPlacer.h"

#endif


#import "MoPub/MPMediationSettingsProtocol.h"
#import "MoPub/MPRewardedVideo.h"
#import "MoPub/MPRewardedVideoReward.h"
#import "MoPub/MPRewardedVideoCustomEvent.h"
#import "MoPub/MPRewardedVideoError.h"
#endif /* ISoma_Bridging_Header_h */
