//
//  ViewController.swift
//  AdsDemoIOS
//
//  Created by Ai Yamamoto on 2018-08-22.
//  Copyright © 2018 Ai Yamamoto. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet weak var table: UITableView!
    var tableData:[String] = ["Google Banner","Google Native","Smaato Banner", "Smaato Toaster", "Smaato Native", "Mopub Banner"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        table.delegate = self
        table.dataSource = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return tableData.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        var cell: UITableViewCell = tableView.dequeueReusableCell(withIdentifier: "cell")!
        if cell != nil {
            cell = UITableViewCell(style: .default, reuseIdentifier: "cell")
        }
        cell.textLabel?.text = tableData[indexPath.row]
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        
        switch indexPath.row {
        case 0:
            performSegue(withIdentifier: "goToGoogleBannerAdsVC", sender: nil)
            break
        case 1:
            performSegue(withIdentifier: "goToGoogleNativeAdsVC", sender: nil)
            break
        case 2:
            performSegue(withIdentifier: "goToSmaatoAdsVC", sender: nil)
            break
        case 3:
            performSegue(withIdentifier: "goToSmaatoToasterAdsVC", sender: nil)
            break
        case 4:
            performSegue(withIdentifier: "goToSmaatoNativeAdsVC", sender: nil)
            break

        case 5:
            performSegue(withIdentifier: "goToMopubBannerAdsVC", sender: nil)
            break
            
        default:
            break
        }
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if(segue.identifier == "goToNextView") {
            let googleBannewAdsVC: GoogleBannerAdsViewController = (segue.destination as? GoogleBannerAdsViewController)!
            
            
        }
    }
    
}

