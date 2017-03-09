package view;

import SubjectObserver.*;
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
public class CanvasView implements DrawView, MyObservable<CanvasClick> {


    private int width = 824;
    private int height = 720;
    Canvas canvas;
    StackPane mainPane;
    private ObserverImpl<CanvasClick> observer;
    public CanvasView() {
        this.observer = new ObserverImpl<CanvasClick>();
        setup();
    }

    private SceneController controller;

    private void setup() {

        this.mainPane = new StackPane();
        this.canvas = new Canvas(width,height);
//        this.canvas = new Canvas();
        this.canvas.setOnMouseClicked( mouse -> {
            observer.notifyObservers(m -> m.clickedAt(mouse.getX(),mouse.getY()));
        });

        this.mainPane.getChildren().add(canvas);
//        this.scene = new Scene(mainPane, width, height);
    }

    public void addMeToView(Pane pane) {

        pane.getChildren().add(mainPane);
    }

    @Override
    public void renderView(List<Shape> shapes) {
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        for(Shape s : shapes) {
            s.draw(canvas);
        }
    }

    @Override
    public ObserverImpl<CanvasClick> getObserver() {
        return observer;
    }

}
