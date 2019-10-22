/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import UIKit
import MultiPlatformLibraryUnits
import SwiftyGif

// Fillable interface from https://github.com/icerockdev/moko-units
class GifTableViewCell: UITableViewCell, Fillable {
    typealias DataType = CellModel
    
    struct CellModel {
        let id: Int64
        let gifUrl: String
    }
    
    @IBOutlet private var gifImageView: UIImageView!
    
    private var gifDownloadTask: URLSessionDataTask?
    
    override func prepareForReuse() {
        super.prepareForReuse()
        
        gifDownloadTask?.cancel()
        gifImageView.clear()
    }
    
    func fill(_ data: GifTableViewCell.CellModel) {
        gifDownloadTask = gifImageView.setGifFromURL(URL(string: data.gifUrl)!)
    }
    
    func update(_ data: GifTableViewCell.CellModel) {
        
    }
}

// Reusable interface from https://github.com/icerockdev/moko-units
extension GifTableViewCell: Reusable {
    static func reusableIdentifier() -> String {
        return "GifTableViewCell"
    }
    
    static func xibName() -> String {
        return "GifTableViewCell"
    }
    
    static func bundle() -> Bundle {
        return Bundle.main
    }
}
