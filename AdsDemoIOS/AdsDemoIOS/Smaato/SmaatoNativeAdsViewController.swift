//
//  SmaatoNativeAdsViewController.swift
//  AdsDemoIOS
//
//  Created by Ai Yamamoto on 2018-08-23.
//  Copyright © 2018 Ai Yamamoto. All rights reserved.
//

import UIKit

class SmaatoNativeAdsViewController: UIViewController, SOMANativeAdDelegate {

    @IBOutlet weak var conteinerView: UIView!
    var nativeAd: SOMANativeAd!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        nativeAd = SOMANativeAd(publisherId: "0", adSpaceId: "0")
        nativeAd.delegate = self
        nativeAd.layout = SOMANativeAdLayoutContentStream;
        conteinerView.addSubview(nativeAd)
        nativeAd.load()

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    func somaNativeAdDidLoad(_ nativeAd: SOMANativeAd!) {
        nativeAd.registerView(forUserInteraction: conteinerView)
    }

    func somaNativeAdDidFailed(_ nativeAd: SOMANativeAd!, withError error: Error!) {

    }

    func somaNativeAdShouldEnterFullScreen(_ nativeAd: SOMANativeAd!) -> Bool {
        return true
    }
    
    func somaRootViewController() -> UIViewController! {
        return self
    }

}
