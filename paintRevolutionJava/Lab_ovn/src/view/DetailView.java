package view;

import SubjectObserver.MySubject;
import SubjectObserver.ObserverImpl;
import SubjectObserver.ObserverShapeProperties;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Shape;


import java.util.List;

/**
 * Created by cj on 2017-03-09.
 */
public class DetailView implements DrawView , MySubject<ObserverShapeProperties> {


    private VBox vbox;
    private Slider lineWidthParameter;
    private ColorPicker colorPicker;
    private CheckBox filled;
    private Label lineWidthLabel, colorLabel, filledLabel;
    private ObserverImpl<ObserverShapeProperties> observer;

    public DetailView() {

        observer = new ObserverImpl<>();

        setup();
    }

    private void setup() {
        vbox = new VBox();
        vbox.setPrefWidth(300);
        lineWidthLabel = new Label("Line width");
        colorLabel = new Label("Color");
        filledLabel = new Label("Filled or not");

        lineWidthParameter = new Slider(1,100,1);
        lineWidthParameter.setShowTickLabels(true);
        lineWidthParameter.setShowTickMarks(true);
        lineWidthParameter.setMajorTickUnit(50);
        lineWidthParameter.setMinorTickCount(5);
        lineWidthParameter.setBlockIncrement(10);
        lineWidthParameter.valueProperty().addListener((observable, oldValue, newValue) -> {
            observer.notifyObservers(m -> m.changeProperties( colorPicker.getValue(),filled.isSelected(),newValue.intValue()));
        });
        colorPicker = new ColorPicker();
        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                observer.notifyObservers(m -> m.changeProperties( colorPicker.getValue(),filled.isSelected(),lineWidthParameter.getValue()));
            }
        });
        filled = new CheckBox();
        filled.setOnAction((event) -> {
            System.out.println("check: "+filled.isSelected());
            observer.notifyObservers(m -> m.changeProperties( colorPicker.getValue(),filled.isSelected(),lineWidthParameter.getValue()));
        });

        vbox.getChildren().addAll(lineWidthLabel,lineWidthParameter,colorLabel,colorPicker, filledLabel,filled);


    }

    @Override
    public ObserverImpl<ObserverShapeProperties> getObserver() {
        return observer;
    }

    @Override
    public void addMeToView(Pane pane) {
        pane.getChildren().add(vbox);
    }

    @Override
    public void renderView(List<Shape> shapes) {

    }
}
