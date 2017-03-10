package controllers;

import models.ToolMenuModel;
import view.ToolBarView;

/**
 * Created by o_0 on 2017-03-09.
 */
public class ToolMenuController {
    private ToolMenuModel menuModel;
    private ToolBarView toolbar;

    public ToolMenuController(ToolMenuModel menuModel, ToolBarView toolbar) {
        this.menuModel = menuModel;
        this.toolbar = toolbar;
        toolbar.getObserver().add(this,this::updateToolbar);
        updateTools();

    }
    private void updateToolbar(String name) {
        updateTools();
    }
    public void updateTools() {
        this.toolbar.setTools(menuModel.getTools());
    }
}
