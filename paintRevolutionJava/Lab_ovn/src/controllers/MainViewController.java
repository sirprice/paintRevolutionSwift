package controllers;

import javafx.stage.Stage;
import models.DrawModel;
import view.DrawView;

public class MainViewController implements SceneController {
    DrawView view;
    DrawModel model;
    public MainViewController(DrawModel model,DrawView view) {
        this.view = view;
        this.model = model;
        view.setDelegate(this);
    }



    public void showScene(Stage rootStage)
    {
        view.showScene(rootStage);
    }
}
