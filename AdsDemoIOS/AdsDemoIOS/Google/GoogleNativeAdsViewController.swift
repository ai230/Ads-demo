//
//  GoogleNativeAdsViewController.swift
//  AdsDemoIOS
//
//  Created by AiYamamoto on 2018-08-22.
//  Copyright © 2018 Ai Yamamoto. All rights reserved.
//

import GoogleMobileAds
import UIKit

class GoogleNativeAdsViewController: UIViewController, GADUnifiedNativeAdLoaderDelegate {

    let adUnitID = "ca-app-pub-3940256099942544/3986624511"
    @IBOutlet weak var refreshAdButton: UIButton!
    @IBOutlet weak var nativeAdPlaceholder: UIView!
    
    var adLoader: GADAdLoader!
    /// The native ad view that is being presented.
    var nativeAdView: GADUnifiedNativeAdView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let multipleAdsOptions = GADMultipleAdsAdLoaderOptions()
        multipleAdsOptions.numberOfAds = 5

        adLoader = GADAdLoader(adUnitID: adUnitID,
                               rootViewController: self,
                               adTypes: [GADAdLoaderAdType.unifiedNative],
                               options: [multipleAdsOptions])
        adLoader.delegate = self
        adLoader.load(GADRequest())
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func adLoader(_ adLoader: GADAdLoader,
                  didReceive nativeAd: GADUnifiedNativeAd) {
        // A unified native ad has loaded, and can be displayed.
        
        print("Received unified native ad: \(nativeAd)")
        refreshAdButton.isEnabled = true
        // Create and place ad in view hierarchy.
        let nibView = Bundle.main.loadNibNamed("UnifiedNativeAdView", owner: nil, options: nil)?.first
        guard let nativeAdView = nibView as? GADUnifiedNativeAdView else {
            return
        }
        setAdView(nativeAdView)
        
        // Associate the native ad view with the native ad object. This is
        // required to make the ad clickable as well as populate the media view.
        nativeAdView.nativeAd = nativeAd
        
        // Populate the native ad view with the native ad assets.
        // Some assets are guaranteed to be present in every native ad.
        (nativeAdView.headlineView as? UILabel)?.text = nativeAd.headline
        (nativeAdView.bodyView as? UILabel)?.text = nativeAd.body
        (nativeAdView.callToActionView as? UIButton)?.setTitle(nativeAd.callToAction, for: .normal)
        
        // These assets are not guaranteed to be present. Check that they are before
        // showing or hiding them.
        (nativeAdView.iconView as? UIImageView)?.image = nativeAd.icon?.image
        if let _ = nativeAd.icon {
            nativeAdView.iconView?.isHidden = false
        } else {
            nativeAdView.iconView?.isHidden = true
        }
        (nativeAdView.starRatingView as? UIImageView)?.image = imageOfStars(from:nativeAd.starRating)
        if let _ = nativeAd.starRating {
            nativeAdView.starRatingView?.isHidden = false
        }
        else {
            nativeAdView.starRatingView?.isHidden = true
        }
        (nativeAdView.storeView as? UILabel)?.text = nativeAd.store
        if let _ = nativeAd.store {
            nativeAdView.storeView?.isHidden = false
        }
        else {
            nativeAdView.storeView?.isHidden = true
        }
        (nativeAdView.priceView as? UILabel)?.text = nativeAd.price
        if let _ = nativeAd.price {
            nativeAdView.priceView?.isHidden = false
        }
        else {
            nativeAdView.priceView?.isHidden = true
        }
        (nativeAdView.advertiserView as? UILabel)?.text = nativeAd.advertiser
        if let _ = nativeAd.advertiser {
            nativeAdView.advertiserView?.isHidden = false
        }
        else {
            nativeAdView.advertiserView?.isHidden = true
        }
        // In order for the SDK to process touch events properly, user interaction
        // should be disabled.
        nativeAdView.callToActionView?.isUserInteractionEnabled = false
        
        
    }
    
    func adLoaderDidFinishLoading(_ adLoader: GADAdLoader) {
        // The adLoader has finished loading ads, and a new request can be sent.
    }

    public func adLoader(_ adLoader: GADAdLoader,
                         didFailToReceiveAdWithError error: GADRequestError) {
        
    }
    
    @IBAction func didRefreshAdButtonClick(_ sender: Any) {
        
        refreshAdButton.isEnabled = false
        adLoader = GADAdLoader(adUnitID: adUnitID, rootViewController: self,
                               adTypes: [ .unifiedNative ], options: nil)
        adLoader.delegate = self
        adLoader.load(GADRequest())
        
    }
    
    private func disolayAds(adLoader: GADAdLoader,
                            didReceive nativeAd: GADUnifiedNativeAd) {
        
    }
    
    func setAdView(_ view: GADUnifiedNativeAdView) {
        // Remove the previous ad view.
        nativeAdView = view
        nativeAdPlaceholder.addSubview(nativeAdView)
        nativeAdView.translatesAutoresizingMaskIntoConstraints = false
        
        // Layout constraints for positioning the native ad view to stretch the entire width and height
        // of the nativeAdPlaceholder.
        let viewDictionary = ["_nativeAdView": nativeAdView!]
        self.view.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "H:|[_nativeAdView]|",
                                                                options: NSLayoutFormatOptions(rawValue: 0), metrics: nil, views: viewDictionary))
        self.view.addConstraints(NSLayoutConstraint.constraints(withVisualFormat: "V:|[_nativeAdView]|",
                                                                options: NSLayoutFormatOptions(rawValue: 0), metrics: nil, views: viewDictionary))
    }
    
    /// Returns a `UIImage` representing the number of stars from the given star rating; returns `nil`
    /// if the star rating is less than 3.5 stars.
    func imageOfStars(from starRating: NSDecimalNumber?) -> UIImage? {
        guard let rating = starRating?.doubleValue else {
            return nil
        }
        if rating >= 5 {
            return UIImage(named: "stars_5")
        } else if rating >= 4.5 {
            return UIImage(named: "stars_4_5")
        } else if rating >= 4 {
            return UIImage(named: "stars_4")
        } else if rating >= 3.5 {
            return UIImage(named: "stars_3_5")
        } else {
            return nil
        }
    }

}
