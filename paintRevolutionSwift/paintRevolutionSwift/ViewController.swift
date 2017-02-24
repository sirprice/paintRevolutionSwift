//
//  ViewController.swift
//  paintRevolutionSwift
//
//  Created by o_0 on 2017-02-24.
//  Copyright © 2017 Magnus. All rights reserved.
//

import Cocoa

class ViewController: NSViewController {

    @IBOutlet weak var selectedShape: NSTextField!
    
    @IBOutlet weak var shapeToolTable: NSTableView!
    var tools = DrawTools()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        tools.add(shape: MyShape(name: "round ball"))
        tools.add(shape: MyShape(name: "thingy"))
        tools.add(shape: MyShape(name: "shape"))
        shapeToolTable.delegate = self
        shapeToolTable.dataSource = self
        selectedShape.stringValue = "Select shape"
        
    }

    override var representedObject: Any? {
        didSet {
        // Update the view, if already loaded.
        }
    }
    

}

class MyShape: ShapeToolInfo {
    let name:String
    init(name:String) {
        self.name = name
    }
    func shapeName() -> String {
        return name
    }
    
}

extension ViewController : NSTableViewDataSource {
    func numberOfRows(in tableView: NSTableView) -> Int {
        return tools.shapeTools.count
    }
}

extension ViewController : NSTableViewDelegate {
    enum ToolCellIdentifiers {
        static let ShapeCell = "ShapeCellView"
    }
    
    func tableViewSelectionDidChange(_ notification: Notification) {
        let selectedRow = shapeToolTable.selectedRow
        let shape = tools.shapeInfo(at: selectedRow)?.shapeName() ?? "Select shape"
        selectedShape.stringValue = shape
        print("tableViewSelectionDidChange: \(selectedRow) name: \(shape)")
        
    }
    
    func tableView(_ tableView: NSTableView, viewFor tableColumn: NSTableColumn?, row: Int) -> NSView? {
        if let cell = tableView.make(withIdentifier: ToolCellIdentifiers.ShapeCell, owner: nil) as? ShapeToolCell {
            cell.shapeName?.stringValue = tools.shapeInfo(at: row)?.shapeName() ?? "Shape Out of bounds"
            return cell
        }
        return nil
    }
}
