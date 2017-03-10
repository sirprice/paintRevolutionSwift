package controllers;

import SubjectObserver.MyObservable;
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
        MyObservable<ShapeAdded> observer = this.model.getObserver();
        observer.add(this,this::drawScene);
    }

    private void canvasClick() {

    }

    public void drawScene() {
        view.renderView(model.getShapes());
    }

    public void showScene(Stage rootStage)
    {

    }
}
