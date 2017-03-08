package controllers;

import SubjectObserver.ObserverImpl;
import SubjectObserver.ShapeAdded;
import javafx.stage.Stage;
import models.SceneModel;
import view.DrawView;

/**
 * Created by o_0 on 2017-03-08.
 */
public class CanvasController {
    DrawView view;
    SceneModel model;
    public CanvasController(SceneModel model, DrawView view) {
        this.view = view;
        this.model = model;
//        view.setDelegate(this);
        ObserverImpl<ShapeAdded> observer = this.model.getObserver();
        observer.add(this,this::drawScene);
    }

    public void drawScene() {
        view.renderView(model.getShapes());
    }

    public void showScene(Stage rootStage)
    {

    }
}
