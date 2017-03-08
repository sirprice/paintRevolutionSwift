package view;

import controllers.MainViewController;
import controllers.SceneController;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Shape;

import java.util.List;

/**
 * Created by o_0 on 2017-02-17.
 */
public class MainView implements DrawView {
    private Scene scene;
    private int width = 500;
    private int height = 500;
    Canvas canvas;
    public MainView() {
        setup();
    }

    private SceneController controller;

    private void setup() {

        StackPane mainPane = new StackPane();
        canvas = new Canvas(width,height);
        mainPane.getChildren().add(canvas);
        this.scene = new Scene(mainPane, width, height);
    }

    public void showScene(Stage rootStage) {

        rootStage.setTitle("Hello World");
        rootStage.setScene(scene);
        rootStage.sizeToScene();
        rootStage.show();
    }

    @Override
    public void renderView(List<Shape> shapes) {
        for(Shape s : shapes) {
            s.draw(canvas);
        }
    }

    @Override
    public void setDelegate(SceneController controller) {
        this.controller = controller;
    }
}
