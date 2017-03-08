package view;

import SubjectObserver.ObserverEmpty;
import SubjectObserver.ObserverImpl;
import controllers.MainViewController;
import controllers.SceneController;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Shape;

import java.util.List;

/**
 * Created by o_0 on 2017-02-17.
 */
public class MainView {
    private Scene scene;
    private int width = 500;
    private int height = 500;
//    Canvas canvas;
    DrawView toolBarView;
    DrawView canvasView;
    HBox mainDisplay;
    public MainView(DrawView toolBarView,DrawView canvasView) {
        this.toolBarView = toolBarView;
        this.canvasView = canvasView;
        setup();
    }

    private SceneController controller;

    private void setup() {

        StackPane mainPane = new StackPane();
        this.mainDisplay = new HBox();

        this.toolBarView.addMeToView(mainDisplay);
        this.canvasView.addMeToView(mainDisplay);


        mainPane.getChildren().add(mainDisplay);
//        canvas = new Canvas(width,height);
//        mainPane.getChildren().add(canvas);
        this.scene = new Scene(mainPane, width, height);

    }

    public void drawScene() {


    }

    public void showScene(Stage rootStage) {

        rootStage.setTitle("Hello World");
        rootStage.setScene(scene);
        rootStage.sizeToScene();
        rootStage.show();
    }


}
