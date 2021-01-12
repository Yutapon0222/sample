//
//  ViewController.swift
//  Horoscope
//
//  Created by HT1129 on 2020/10/06.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lbSeiza: UILabel!
    @IBOutlet weak var ivSeiza: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func getDate(_ sender: UIDatePicker) {
        
        // 日付の取得
        let df = DateFormatter()
        df.dateFormat = "MMdd"
        let md = Int(df.string(from: sender.date)) ?? 0
//        print(md)
        
        // 星座判定
        switch md {
        case 321...331, 401...419:
            setSeiza(name: "牡羊座", assetname: "seiza01")
        case 420...430, 501...520:
            setSeiza(name: "牡牛座", assetname: "seiza02")
        default:
            break
        }
    }
    
    // 星座情報の表示
    func setSeiza(name: String, assetname: String) {
        
        lbSeiza.text = name
        ivSeiza.image = UIImage(named: assetname)
    }
}

