package view;

import SubjectObserver.ObserverEmpty;
import SubjectObserver.ObserverImpl;
import controllers.MainViewController;
import controllers.SceneController;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by o_0 on 2017-02-17.
 */
public class MainView {
    private Scene scene;
    private int width = 1024;
    private int height = 720;
//    Canvas canvas;
    ArrayList<DrawView> toolBarViews;
    DrawView canvasView;
    HBox mainDisplay;
    public MainView(ArrayList<DrawView> toolBarView,DrawView canvasView) {
        this.toolBarViews = toolBarView;
        this.canvasView = canvasView;
        setup();
    }

    private SceneController controller;

    private void setup() {

        StackPane mainPane = new StackPane();
        this.mainDisplay = new HBox();
        VBox toolArea= new VBox();
        for (DrawView view : toolBarViews) {
            view.addMeToView(toolArea);
        }
        mainDisplay.getChildren().add(toolArea);

        this.canvasView.addMeToView(mainDisplay);


        mainPane.getChildren().add(mainDisplay);
//        canvas = new Canvas(width,height);
//        mainPane.getChildren().add(canvas);
        this.scene = new Scene(mainPane, width, height);

    }

    public void drawScene() {


    }

    public void showScene(Stage rootStage) {
        rootStage.setResizable(false);
        rootStage.setTitle("Hello World");
        rootStage.setScene(scene);
        rootStage.sizeToScene();
        rootStage.show();
    }


}
