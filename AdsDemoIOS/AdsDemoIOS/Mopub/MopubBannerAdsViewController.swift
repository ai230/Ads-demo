//
//  MopubBannerAdsViewController.swift
//  AdsDemoIOS
//
//  Created by Ai Yamamoto on 2018-08-24.
//  Copyright © 2018 Ai Yamamoto. All rights reserved.
//

import UIKit
import MoPub

class MopubBannerAdsViewController: UIViewController, MPAdViewDelegate {
    func viewControllerForPresentingModalView() -> UIViewController! {
        return self
    }
    
    var adView :MPAdView!
    
 
    @IBOutlet weak var loadAdBtn: UIButton!
    @IBOutlet weak var containerView: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        adView = MPAdView(adUnitId: "23b49916add211e281c11231392559e4", size: MOPUB_BANNER_SIZE)
        adView.delegate = self
        containerView.addSubview(adView)
        adView.loadAd()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    
    func adViewDidLoadAd(_ view: MPAdView!) {
        
    }

    func adViewDidFail(toLoadAd view: MPAdView!) {
        
    }
    
    @IBAction func loadAdsClicked(_ sender: Any) {
        containerView.addSubview(adView)
        adView.loadAd()
    }
}
