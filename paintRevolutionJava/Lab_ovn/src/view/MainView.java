package view;

import controllers.SceneController;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by o_0 on 2017-02-17.
 */
public class MainView {
    private Scene scene;
    private int width = 1324;
    private int height = 720;
//    Canvas canvas;
    ArrayList<DrawView> leftBarViews;
    ArrayList<DrawView> rightBarViews;
    DrawView canvasView;
    HBox mainDisplay;


    public MainView(ArrayList<DrawView> leftBarViews, ArrayList<DrawView> rightBarViews, DrawView canvasView) {
        this.leftBarViews = leftBarViews;
        this.canvasView = canvasView;
        this.rightBarViews = rightBarViews;
        setup();
    }



    private SceneController controller;

    private void setup() {

        StackPane mainPane = new StackPane();
        this.mainDisplay = new HBox();
        VBox leftToolArea= new VBox();
        for (DrawView view : leftBarViews) {
            view.addMeToView(leftToolArea);

        }
        mainDisplay.getChildren().add(leftToolArea);

        this.canvasView.addMeToView(mainDisplay);

        VBox rightToolArea= new VBox();

        for (DrawView view : rightBarViews) {
            view.addMeToView(rightToolArea);

        }
        mainDisplay.getChildren().add(rightToolArea);

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
