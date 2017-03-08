package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.SceneModel;
import view.ToolBarView;

/**
 * Created by cj on 2017-03-08.
 */
public class ToolBarController {
    private ToolBarView toolBarView;
    private SceneModel model;

    public ToolBarController(ToolBarView toolBarView, SceneModel model) {
        this.toolBarView = toolBarView;
        this.model = model;

//        this.toolBarView.setTools(model.getShapes(),onMouseClickHandler());
        updateTools();
    }



    public void updateTools() {
        this.toolBarView.setTools(model.getShapes());
    }

    private EventHandler<MouseEvent> onMouseClickHandler() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
            }
        };

    }
}
