package controllers;

import javafx.stage.Stage;
import models.SceneModel;
import view.DrawView;
import view.MainView;

import java.util.ArrayList;

public class MainViewController implements SceneController {
    MainView view;
    public MainViewController(ArrayList<DrawView> toolBarView,ArrayList<DrawView> rightToolBarView, DrawView canvasView) {
        this.view = new MainView(toolBarView,rightToolBarView,canvasView);
    }



    @Override
    public void drawScene() {

    }

    public void showScene(Stage rootStage)
    {
        view.showScene(rootStage);
    }
}
