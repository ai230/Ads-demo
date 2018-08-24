//
//  SmaatoBannerAdsViewController.swift
//  AdsDemoIOS
//
//  Created by Ai Yamamoto on 2018-08-23.
//  Copyright © 2018 Ai Yamamoto. All rights reserved.
//

import UIKit

class SmaatoBannerAdsViewController: UIViewController, SOMAAdViewDelegate {

    
    
    @IBOutlet weak var adView: SOMAAdView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        adView.adSettings.adSpaceId = 0
        adView.adSettings.publisherId = 0
        adView.delegate = self

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func somaAdViewDidLoadAd(_ adview: SOMAAdView!) {
        
    }

}
