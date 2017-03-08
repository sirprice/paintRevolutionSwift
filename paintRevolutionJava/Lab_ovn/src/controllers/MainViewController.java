package controllers;

import javafx.stage.Stage;
import models.SceneModel;
import view.DrawView;

public class MainViewController implements SceneController {
    DrawView view;
    SceneModel model;
    public MainViewController(SceneModel model, DrawView view) {
        this.view = view;
        this.model = model;
        view.setDelegate(this);

    }



    @Override
    public void drawScene() {
        view.renderView(model.getShapes());
    }

    public void showScene(Stage rootStage)
    {
        view.showScene(rootStage);
    }
}
