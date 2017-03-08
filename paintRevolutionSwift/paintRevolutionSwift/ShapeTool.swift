//
//  ShapeTool.swift
//  paintRevolutionSwift
//
//  Created by o_0 on 2017-02-24.
//  Copyright © 2017 Magnus. All rights reserved.
//

import Foundation

protocol ShapeToolInfo {
    func shapeName() -> String
}

class DrawTools {
    var shapeTools:[ShapeToolInfo] = []
    
    func add(shape:ShapeToolInfo) -> Void {
        shapeTools.append(shape)
    }
    
    func shapeInfo(at:Int) -> ShapeToolInfo? {
        if 0 <= at && at < shapeTools.count {
            return shapeTools[at]
        }
        return nil
    }
    
}
