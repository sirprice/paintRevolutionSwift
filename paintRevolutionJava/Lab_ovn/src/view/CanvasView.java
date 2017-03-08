package view;

import SubjectObserver.MyObservable;
import SubjectObserver.ObserverEmpty;
import SubjectObserver.ObserverImpl;
import SubjectObserver.ToolSelect;
import controllers.SceneController;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Shape;

import java.util.List;

/**
 * Created by o_0 on 2017-03-08.
 */
public class CanvasView implements DrawView, MyObservable<ToolSelect> {


    private int width = 400;
    private int height = 500;
    Canvas canvas;
    StackPane mainPane;
    public CanvasView() {
        setup();
    }

    private SceneController controller;

    private void setup() {

        this.mainPane = new StackPane();
        this.canvas = new Canvas(width,height);
        this.mainPane.getChildren().add(canvas);
//        this.scene = new Scene(mainPane, width, height);
    }

    public void addMeToView(Pane pane) {
        pane.getChildren().add(mainPane);
    }

    @Override
    public void renderView(List<Shape> shapes) {
        for(Shape s : shapes) {
            s.draw(canvas);
        }
    }

    @Override
    public ObserverImpl<ToolSelect> getObserver() {
        return null;
    }

}
